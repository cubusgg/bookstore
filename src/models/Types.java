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
@Table (name = "types")
public class Types implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_type;
    
    @Column (name = "name")
    private String name;
    
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>();

    public long getId_type() {
        return id_type;
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

    public void addType(Books book) {
        books.add(book);
        book.setType(this);
    }
    
    

    @Override
    public String toString() {
        return "Types{" + "id_type=" + id_type +
                ", name=" + name + '}';
    }
}
