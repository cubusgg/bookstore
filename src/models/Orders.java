/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author jakub
 */
@Entity
@Table (name = "orders")
public class Orders implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_order;
    
    @Column (name = "order_date")
    private String order_date;
    
    @Column (name = "implementation_stage")
    private String implementation_stage;
    
    @ManyToOne()
    @JoinColumn(name = "id_customer")
    private Customers cusotmer;
    
    public long getId_order() {
        return id_order;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getImplementation_stage() {
        return implementation_stage;
    }

    public void setImplementation_stage(String implementation_stage) {
        this.implementation_stage = implementation_stage;
    }

    public Customers getCusotmer() {
        return cusotmer;
    }

    public void setCusotmer(Customers cusotmer) {
        this.cusotmer = cusotmer;
    }

    @Override
    public String toString() {
        return "Orders{" + "id_order=" + id_order +
                ", order_date=" + order_date +
                ", implementation_stage=" + implementation_stage + '}';
    }
    
    
}
