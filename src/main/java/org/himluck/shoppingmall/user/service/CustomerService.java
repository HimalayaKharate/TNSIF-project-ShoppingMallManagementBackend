package org.himluck.shoppingmall.user.service;

import org.himluck.shoppingmall.mall.entities.OrderDetails;
import org.himluck.shoppingmall.user.entities.Customer;
import org.himluck.shoppingmall.user.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo repo;

    public List<Customer> findAll() {
        return repo.findAll();
    }

    public Customer findByCustomerId(int customerId) {
        var customer = repo.findById(customerId);
        return customer.orElse(null);
    }

    public Customer AddCustomer(Customer customer) {
        return repo.save(customer);
    }

    public void UpdateCustomer(int id, Customer customer) {
        var customerU = repo.findById(id);
        if (customerU.isPresent()) {
            customerU.get().setName(customer.getName());
            customerU.get().setEmail(customer.getEmail());
            customerU.get().setPhone(customer.getPhone());
            customerU.get().setPassword(customer.getPassword());
            repo.save(customerU.get());
        }
    }

    public void DeleteCustomer(int customerId) {
        repo.deleteById(customerId);
    }

    public ResponseEntity<Customer> addOrder(int customerId,List<OrderDetails> orderDetails){
        var customerU = repo.findById(customerId);
        if (customerU.isPresent()) {
            customerU.get().getOrderDetails().addAll(orderDetails);
            repo.save(customerU.get());
            return ResponseEntity.ok(customerU.get());
        }
        return ResponseEntity.notFound().build();
    }
}
