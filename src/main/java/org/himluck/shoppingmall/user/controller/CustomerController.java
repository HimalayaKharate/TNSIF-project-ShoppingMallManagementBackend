package org.himluck.shoppingmall.user.controller;

import org.himluck.shoppingmall.user.entities.Customer;
import org.himluck.shoppingmall.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {

        var c = customerService.findByCustomerId(id);

        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        if(customerService.AddCustomer(customer) != null){
            return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        customerService.UpdateCustomer(id, customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){
        customerService.DeleteCustomer(id);
        return ResponseEntity.ok(null);
    }


}
