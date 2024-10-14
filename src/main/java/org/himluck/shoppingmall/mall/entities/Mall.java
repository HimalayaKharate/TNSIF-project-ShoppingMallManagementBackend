package org.himluck.shoppingmall.mall.entities;

import jakarta.persistence.*;
import org.himluck.shoppingmall.user.entities.ShopOwner;

import java.util.List;

@Entity
public class Mall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String address;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private ShopOwner owner;

    // One Mall has many shops
    @OneToMany(mappedBy = "mall", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shop> shops;

    // Constructors
    public Mall() {
    }

    public Mall(int id, String name, String address, ShopOwner owner, List<Shop> shops) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.shops = shops;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShopOwner getOwner() {
        return owner;
    }

    public void setOwner(ShopOwner owner) {
        this.owner = owner;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
