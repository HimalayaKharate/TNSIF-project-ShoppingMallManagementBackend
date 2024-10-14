package org.himluck.shoppingmall.user.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class ShopOwner extends User1{
    LocalDate birthday;
    String address;

    public ShopOwner() {
        super();
    }

    public ShopOwner(int id, String name, String password, LocalDate birthday, String address) {
        super(name, password, id);
        this.birthday = birthday;
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
