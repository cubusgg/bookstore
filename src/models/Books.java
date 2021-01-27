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
    private String isbn;
    
    @Column (name = "title")
    private String title;
    
    @Column (name = "release_date")
    private String release_date;
    
    @Column (name = "quantity_available")
    private int quantity_available;
    
    @Column (name = "price")
    private double price;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publisher")
    private Publishers publisher;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Authors author;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    private Types type;
    
    @ManyToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "books_orders", joinColumns = @JoinColumn(name = "isbn"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Orders> orders = new ArrayList<>();
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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
    
    public void addOrder(Orders order) {
        this.orders.add(order);
        order.getBook().add(this);
    }

    public void removeOrder(Orders order) {
        this.orders.remove(order);
        order.getBook().remove(this);
    }

    public List<Orders> getOrder() {
        return orders;
    }

    public void setOrder(List<Orders> orders) {
        this.orders = orders;
    }
    
    

    @Override
    public String toString() {
        return "Books{" + "isbn=" + isbn +
                ", title=" + title +
                ", release_date=" + release_date +
                ", quantity_available=" + quantity_available +
                ", price=" + price +
                ", publisher=" + publisher +
                ", author=" + author +
                ", type=" + type + '}';
    }
    
}
