package org.himluck.shoppingmall.mall.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.himluck.shoppingmall.user.entities.Customer;

import java.time.LocalDateTime;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDateTime dateTime;

    private double total;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String paymentMode;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;


    public OrderDetails() {
    }

    public OrderDetails(int id, LocalDateTime dateTime, double total, String paymentMode, Customer customer) {
        this.id = id;
        this.dateTime = dateTime;
        this.total = total;
        this.paymentMode = paymentMode;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
