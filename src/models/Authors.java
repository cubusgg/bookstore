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
@Table (name = "authors")
public class Authors implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_author;
    
    @Column (name = "name")
    private String name;
    
    @Column (name = "lastname")
    private String lastname;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>();
    
    public long getId_author() {
        return id_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void addAuthor(Books book) {
        books.add(book);
        book.setAuthor(this);
    }
    
    

    @Override
    public String toString() {
        return "Authors{" + "id_authors=" + id_author +
                ", name=" + name +
                ", lastname=" + lastname + '}';
    }

}
