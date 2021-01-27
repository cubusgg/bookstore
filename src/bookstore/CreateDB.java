package bookstore;

import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author jakub
 */
public class CreateDB {
    
    public void createDB() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");

        con.addAnnotatedClass(Customers.class);
        con.addAnnotatedClass(Authors.class);
        con.addAnnotatedClass(Books.class);
        con.addAnnotatedClass(Orders.class);
        con.addAnnotatedClass(Publishers.class);
        con.addAnnotatedClass(Types.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Customers admin = new Customers("Admin", "Nieuser", "admin@bookstore.com", "admin", "999998997", "Krosno", "Adminowa", "256", "38-400", "Podkarpacie", true);
        Customers user = new Customers("User", "Nieadmin", "user@bookstore.com", "user", "123456789", "Krosno", "Użytkownikowa", "128", "38-400", "Podkarpacie", false);
        
        Books mk = new Books();
        mk.setIsbn("978-83-274-3154-7");
        mk.setTitle("Mały Książe");
        mk.setRelease_date("1943");
        mk.setQuantity_available(10);
        mk.setPrice(12.34);
        
        Authors antonie = new Authors();
        antonie.setName("Antoine");
        antonie.setLastname("de Saint-Exupéry");
        
        Publishers rh = new Publishers();
        rh.setName("Reynal & Hitchcock");
        
        Types pf = new Types();
        pf.setName("Powiastka filozoficzna");
        
        antonie.addAuthor(mk);
        rh.addPublisher(mk);
        pf.addType(mk);
        
        session.save(antonie);
        session.save(rh);
        session.save(pf);
        session.save(mk);
        session.save(user);
        session.save(admin);
        
        tx.commit();
        session.close();
        sf.close();
    }
}
