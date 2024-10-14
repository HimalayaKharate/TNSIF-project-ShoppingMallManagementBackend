package org.himluck.shoppingmall.user.controller;

import org.himluck.shoppingmall.user.entities.Employee;
import org.himluck.shoppingmall.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService customerService;

    @GetMapping
    public List<Employee> getEmployees() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

        var c = customerService.findByEmployeeId(id);

        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee customer){
        if(customerService.AddEmployee(customer) != null){
            return new ResponseEntity<Employee>(customer, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee customer){
        customerService.UpdateEmployee(id, customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
        customerService.DeleteEmployee(id);
        return ResponseEntity.ok(null);
    }


}
