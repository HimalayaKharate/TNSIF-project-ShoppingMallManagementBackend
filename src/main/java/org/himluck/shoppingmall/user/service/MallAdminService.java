package org.himluck.shoppingmall.user.service;

import org.himluck.shoppingmall.user.entities.MallAdmin;
import org.himluck.shoppingmall.user.repo.MallAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallAdminService {
    @Autowired
    private MallAdminRepo repo;

    public List<MallAdmin> findAll() {
        return repo.findAll();
    }

    public MallAdmin findByMallAdminId(int customerId) {
        var customer = repo.findById(customerId);
        return customer.orElse(null);
    }

    public MallAdmin AddMallAdmin(MallAdmin customer) {
        return repo.save(customer);
    }

    public void UpdateMallAdmin(int id, MallAdmin customer) {
        var customerU = repo.findById(id);
        if (customerU.isPresent()) {
            customerU.get().setName(customer.getName());
            customerU.get().setPhone(customer.getPhone());
            customerU.get().setPassword(customer.getPassword());
            repo.save(customerU.get());
        }
    }

    public void DeleteMallAdmin(int customerId) {
        repo.deleteById(customerId);
    }
}
