/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jakub
 */
@Entity
@Table (name = "publishers")
public class Publishers implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_publisher;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>();
    

    public long getId_publisher() {
        return id_publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void addPublisher(Books book) {
        books.add(book);
        book.setPublisher(this);
    }

    @Override
    public String toString() {
        return "Publishers{" + "id_publishers=" + id_publisher +
                ", name=" + name + '}';
    }
}
