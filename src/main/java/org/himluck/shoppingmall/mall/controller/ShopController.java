package org.himluck.shoppingmall.mall.controller;

import org.himluck.shoppingmall.mall.entities.Shop;
import org.himluck.shoppingmall.mall.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    // Get all shops
    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.findAllShops();
    }

    // Get shop by ID
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable int id) {
        Shop shop = shopService.findShopById(id);
        if (shop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shop);
    }

    // Add a new shop
    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop newShop = shopService.addShop(shop);
        return ResponseEntity.ok(newShop);
    }

    // Update an existing shop by ID
    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable int id, @RequestBody Shop shopDetails) {
        Shop updatedShop = shopService.updateShop(id, shopDetails);
        if (updatedShop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedShop);
    }

    // Delete a shop by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable int id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}
