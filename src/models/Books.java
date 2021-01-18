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
@Table (name = "books")
public class Books implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    private long isbn; // 13 numbers
    
    @Column (name = "title")
    private String title;
    
    @Column (name = "release_date")
    private String release_date;
    
    @Column (name = "quantity_available")
    private int quantity_available;
    
    @Column (name = "price")
    private double price;
    
    @ManyToOne()
    @JoinColumn(name = "id_publisher")
    private Publishers publisher;
    
    @ManyToOne()
    @JoinColumn(name = "id_author")
    private Authors author;
    
    @ManyToOne()
    @JoinColumn(name = "id_type")
    private Types type;
    
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Publishers getPublisher() {
        return publisher;
    }

    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Books{" + "isbn=" + isbn +
                ", title=" + title +
                ", release_date=" + release_date +
                ", quantity_available=" + quantity_available +
                ", price=" + price + '}';
    }
    
    
}
