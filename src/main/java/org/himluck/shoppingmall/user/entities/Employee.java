package org.himluck.shoppingmall.user.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Employee extends User1{
    private LocalDate birthday;
    private Double salary;
    private String address;
    private String designation;

    public Employee() {
    }

    public Employee(String name, String password, int id, LocalDate birthday, Double salary, String address, String designation) {
        super(name, password, id);
        this.birthday = birthday;
        this.salary = salary;
        this.address = address;
        this.designation = designation;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
