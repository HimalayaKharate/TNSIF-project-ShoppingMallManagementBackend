package org.himluck.shoppingmall.user.controller;

import org.himluck.shoppingmall.user.entities.MallAdmin;
import org.himluck.shoppingmall.user.service.MallAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mall-admin")
public class MallAdminController {
    @Autowired
    private MallAdminService customerService;

    @GetMapping
    public List<MallAdmin> getMallAdmins() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MallAdmin> getMallAdmin(@PathVariable int id) {

        var c = customerService.findByMallAdminId(id);

        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<MallAdmin> addMallAdmin(@RequestBody MallAdmin customer){
        if(customerService.AddMallAdmin(customer) != null){
            return new ResponseEntity<MallAdmin>(customer, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<MallAdmin>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MallAdmin> updateMallAdmin(@PathVariable int id, @RequestBody MallAdmin customer){
        customerService.UpdateMallAdmin(id, customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MallAdmin> deleteMallAdmin(@PathVariable int id){
        customerService.DeleteMallAdmin(id);
        return ResponseEntity.ok(null);
    }


}
