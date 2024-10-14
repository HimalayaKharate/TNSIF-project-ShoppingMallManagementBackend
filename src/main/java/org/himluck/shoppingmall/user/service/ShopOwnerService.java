package org.himluck.shoppingmall.user.service;

import org.himluck.shoppingmall.user.entities.ShopOwner;
import org.himluck.shoppingmall.user.repo.ShopOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopOwnerService {
    @Autowired
    private ShopOwnerRepo repo;

    public List<ShopOwner> findAll() {
        return repo.findAll();
    }

    public ShopOwner findByShopOwnerId(int customerId) {
        var customer = repo.findById(customerId);
        return customer.orElse(null);
    }

    public ShopOwner AddShopOwner(ShopOwner customer) {
        return repo.save(customer);
    }

    public void UpdateShopOwner(int id, ShopOwner customer) {
        var customerU = repo.findById(id);
        if (customerU.isPresent()) {
            customerU.get().setName(customer.getName());
            customerU.get().setPassword(customer.getPassword());
            customerU.get().setAddress(customer.getAddress());
            customerU.get().setBirthday(customer.getBirthday());
            repo.save(customerU.get());
        }
    }

    public void DeleteShopOwner(int customerId) {
        repo.deleteById(customerId);
    }
}
