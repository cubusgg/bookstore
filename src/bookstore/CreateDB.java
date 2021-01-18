/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import models.Authors;
import models.Books;
import models.Customers;
import models.Orders;
import models.Publishers;
import models.Types;
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
        //con.addAnnotatedClass(Orders_Books.class);
        con.addAnnotatedClass(Publishers.class);
        con.addAnnotatedClass(Types.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        
        Orders order = new Orders();
        order.setOrder_date("2020-01-02");
        order.setImplementation_stage("Delivery");
        
        Orders order2 = new Orders();
        order2.setOrder_date("2020-01-02");
        order2.setImplementation_stage("Delivery");
        
        Orders order3 = new Orders();
        order3.setOrder_date("2020-01-02");
        order3.setImplementation_stage("Delivery");
        
        Customers customer = new Customers("Kuba", "Klocek", "email@gmail.com", "password", "123456789", "Krosno", "Tysiąclecia", "12", "38-400", "Podkarpacie");
        customer.addCustomer(order);
        Customers customer2 = new Customers("Jakub", "Klocek", "email@gmail.com", "password", "123456789", "Krosno", "Tysiąclecia", "12", "38-400", "Podkarpacie");
        customer2.addCustomer(order2);
        
        customer.addCustomer(order3);
        
        Books b = new Books();
        b.setIsbn(123);
        b.setTitle("Super");
        b.setRelease_date("2020-01-02");
        b.setQuantity_available(1);
        b.setPrice(10.0);
        
        Publishers publisher = new Publishers();
        publisher.setName("Helion");
        publisher.addPublisher(b);
        
        Authors author = new Authors();
        author.setName("Jakub");
        author.setLastname("Klocek");
        author.addAuthor(b);
        
        Types type = new Types();
        type.setName("Horror");
        type.addType(b);
        
        session.save(type);
        session.save(publisher); 
        session.save(author);
        session.save(customer);
        session.save(customer2);
        session.save(order);
        session.save(order2);
        session.save(order3);
        session.save(b);
            
        tx.commit();
        session.close();
        sf.close();
    }
}
