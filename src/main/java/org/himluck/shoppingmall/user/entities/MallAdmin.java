package org.himluck.shoppingmall.user.entities;

import jakarta.persistence.Entity;

@Entity
public class MallAdmin extends User1{
    private String phone;

    public MallAdmin(){
        super();
    }

    public MallAdmin(String name, String password, int id, String phone) {
        super(name, password, id);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
