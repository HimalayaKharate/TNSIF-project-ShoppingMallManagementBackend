package org.himluck.shoppingmall.mall.entities;
import jakarta.persistence.*;
import org.himluck.shoppingmall.user.entities.ShopOwner;

import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private ShopOwner owner;
    private String category;
    private String location;
    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mall_id")
    private Mall mall;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<OrderDetails> orders;

    public Shop() {
    }

    public Shop(int id, String name, ShopOwner owner, String category, String location, String contact, Mall mall, List<OrderDetails> orders) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.category = category;
        this.location = location;
        this.contact = contact;
        this.mall = mall;
        this.orders = orders;
    }

    // Getters and Setters

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

    public ShopOwner getOwner() {
        return owner;
    }

    public void setOwner(ShopOwner owner) {
        this.owner = owner;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<OrderDetails> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
    }
}
