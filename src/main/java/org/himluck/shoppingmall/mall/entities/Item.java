package org.himluck.shoppingmall.mall.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    private String name;
    private LocalDate manufactureDate;
    private LocalDate expiringDate;
    private double total;
    private String categories;

    public Item() {
    }

    public Item(int id, String name, LocalDate manufactureDate, LocalDate expiringDate, double total, String categories) {
        this.id = id;
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.expiringDate = expiringDate;
        this.total = total;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(LocalDate expiringDate) {
        this.expiringDate = expiringDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
