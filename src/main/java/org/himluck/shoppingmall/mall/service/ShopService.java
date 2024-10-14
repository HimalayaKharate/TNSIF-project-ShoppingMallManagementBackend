package org.himluck.shoppingmall.mall.service;

import org.himluck.shoppingmall.mall.entities.Shop;
import org.himluck.shoppingmall.mall.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    // Find all shops
    public List<Shop> findAllShops() {
        return shopRepository.findAll();
    }

    // Find shop by ID
    public Shop findShopById(int id) {
        return shopRepository.findById(id).orElse(null);
    }

    // Add a new shop
    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    // Update existing shop
    public Shop updateShop(int id, Shop shopDetails) {
        Shop shop = shopRepository.findById(id).orElse(null);
        if (shop != null) {
            shop.setName(shopDetails.getName());
            shop.setOwner(shopDetails.getOwner());
            shop.setCategory(shopDetails.getCategory());
            shop.setLocation(shopDetails.getLocation());
            shop.setContact(shopDetails.getContact());
            return shopRepository.save(shop);
        }
        return null;
    }

    // Delete shop by ID
    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }
}
