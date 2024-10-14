package org.himluck.shoppingmall.mall.service;

import org.himluck.shoppingmall.mall.repositories.OrderDetailsRepo;
import org.himluck.shoppingmall.mall.entities.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private OrderDetailsRepo repo;

    public List<OrderDetails> findAll() {
        return repo.findAll();
    }

    public OrderDetails findByOrderDetailsId(int objectId) {
        var object = repo.findById(objectId);
        return object.orElse(null);
    }

    public OrderDetails AddOrderDetails(OrderDetails object) {
        return repo.save(object);
    }

    public void UpdateOrderDetails(int id, OrderDetails object) {
        var objectU = repo.findById(id);
        if (objectU.isPresent()) {
            objectU.get().setCustomer(object.getCustomer());
            objectU.get().setDateTime(object.getDateTime());
            objectU.get().setPaymentMode(object.getPaymentMode());
            objectU.get().setTotal(object.getTotal());
            repo.save(objectU.get());
        }
    }

    public void DeleteOrderDetails(int objectId) {
        repo.deleteById(objectId);
    }
}
