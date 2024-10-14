package org.himluck.shoppingmall.user.service;

import org.himluck.shoppingmall.user.entities.Employee;
import org.himluck.shoppingmall.user.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Employee findByEmployeeId(int customerId) {
        var customer = repo.findById(customerId);
        return customer.orElse(null);
    }

    public Employee AddEmployee(Employee customer) {
        return repo.save(customer);
    }

    public void UpdateEmployee(int id, Employee customer) {
        var customerU = repo.findById(id);
        if (customerU.isPresent()) {
            customerU.get().setName(customer.getName());
            customerU.get().setAddress(customer.getAddress());
            customerU.get().setSalary(customer.getSalary());
            customerU.get().setBirthday(customer.getBirthday());
            customerU.get().setPassword(customer.getPassword());
            repo.save(customerU.get());
        }
    }

    public void DeleteEmployee(int customerId) {
        repo.deleteById(customerId);
    }
}
