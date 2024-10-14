package org.himluck.shoppingmall.user.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.himluck.shoppingmall.mall.entities.OrderDetails;

import java.util.List;

@Entity
public class Customer extends User1 {

    private String phone;
    private String email;

    @OneToMany
    private List<OrderDetails> orderDetails;

    public Customer() {
    }

    public Customer(String name, String password, int id, String phone, String email, List<OrderDetails> orderDetails) {
        super(name, password, id);
        this.phone = phone;
        this.email = email;
        this.orderDetails = orderDetails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
