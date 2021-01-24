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
@Table (name = "customers")
public class Customers implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_customer;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "house_number")
    private String house_number;
    
    @Column(name = "zipcode")
    private String zipcode;
    
    @Column(name = "voivodeship")
    private String voivodeship;
    
    @Column(name = "admin") // true = admin, false = klient
    private boolean admin; 
    
    @Column(name = "is_login")
    private boolean isLogin;
    
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Orders> orders = new ArrayList<>();
    
    public Customers() {}

    public Customers(String name, String lastname, String email, String password, String phone, String city, String street, String house_number, String zipcode, String voivodeship, boolean admin) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.zipcode = zipcode;
        this.voivodeship = voivodeship;
        this.admin = admin;
        this.isLogin = false;
    }
    
    public long getId_customer() { 
        return id_customer; 
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean user) {
        this.admin = user;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void addOrder(Orders order) {
        orders.add(order);
        order.setCustomer(this);
    }

    @Override
    public String toString() {
        return "Customers{" + "id_customer=" + id_customer +
                ", name=" + name +
                ", lastname=" + lastname +
                ", email=" + email +
                ", password=" + password +
                ", phone=" + phone +
                ", city=" + city +
                ", street=" + street +
                ", house_number=" + house_number +
                ", zipcode=" + zipcode +
                ", voivodeship=" + voivodeship +
                ", admin=" + admin +
                ", isLogin=" + isLogin + '}';
    }

    

    
}
