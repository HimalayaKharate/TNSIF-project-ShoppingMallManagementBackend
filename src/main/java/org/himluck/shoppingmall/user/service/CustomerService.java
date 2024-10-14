package org.himluck.shoppingmall.user.service;

import org.himluck.shoppingmall.user.entities.Customer;
import org.himluck.shoppingmall.user.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
}
