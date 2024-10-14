package org.himluck.shoppingmall.user.controller;

import org.himluck.shoppingmall.user.entities.ShopOwner;
import org.himluck.shoppingmall.user.service.ShopOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop-owner")
public class ShopOwnerController {
    @Autowired
    private ShopOwnerService customerService;

    @GetMapping
    public List<ShopOwner> getShopOwners() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopOwner> getShopOwner(@PathVariable int id) {

        var c = customerService.findByShopOwnerId(id);

        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<ShopOwner> addShopOwner(@RequestBody ShopOwner customer){
        if(customerService.AddShopOwner(customer) != null){
            return new ResponseEntity<ShopOwner>(customer, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<ShopOwner>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopOwner> updateShopOwner(@PathVariable int id, @RequestBody ShopOwner customer){
        customerService.UpdateShopOwner(id, customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShopOwner> deleteShopOwner(@PathVariable int id){
        customerService.DeleteShopOwner(id);
        return ResponseEntity.ok(null);
    }


}
