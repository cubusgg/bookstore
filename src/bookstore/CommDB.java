/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.List;
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
 * DO EDYCJI JEST TEN PLIK, MOZNA GO SKRÓCIĆ BO NIE KORZYSTA SIĘ Z WYSZYSTIEKGO 
 * I TRZEBA ZROBIĆ METODE TYLKO DO WŁĄCZANIA SESJI!
 * 
 */
public class CommDB {
    
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
        
        Orders first = new Orders();
        first.setOrder_date("22-01-2021");
        first.setImplementation_stage("order accepted"); // order accepted -> delivery -> received
        
        Orders second = new Orders();
        second.setOrder_date("22-01-2021");
        second.setImplementation_stage("order accepted");
        
        antonie.addAuthor(mk);
        rh.addPublisher(mk);
        pf.addType(mk);
        
        mk.addOrder(second);
        admin.addOrder(second);
        
        mk.addOrder(first);
        user.addOrder(first);
        
        
        session.save(antonie);
        session.save(rh);
        session.save(pf);
        session.save(first);
        session.save(second);
        session.save(mk);
        
        session.save(user);
        session.save(admin);

        
        tx.commit();
        session.close();
        sf.close();
    }
    
    public void updateDB() {
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
        
        Customers user1;
        Customers user2;
        
        Integer y = 2;
        long x = y.longValue();
        
        user1 = (Customers) session.get(Customers.class, x);
        System.out.println(user1.getName());
        
        Integer z = 1;
        long c = z.longValue();
        
        user2 = (Customers) session.get(Customers.class, c);
        System.out.println(user2);
        
        List<Orders> ord = user2.getOrders();
        
        ord.forEach((o) -> {
            System.out.println(o);
        });
        
        tx.commit();
        session.close();
        sf.close();
    }
    
    public static Session getCurrentSessionFromConfig() {
        // SessionFactory in Hibernate 5 example
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    
}
