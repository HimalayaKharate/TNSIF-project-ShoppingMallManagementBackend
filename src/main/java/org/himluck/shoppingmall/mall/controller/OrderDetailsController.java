package org.himluck.shoppingmall.mall.controller;

import org.himluck.shoppingmall.mall.entities.OrderDetails;
import org.himluck.shoppingmall.mall.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailsController {

    @Autowired
    private OrderDetailService orderDetailService;

    // GET all order details
    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        List<OrderDetails> orderDetailsList = orderDetailService.findAll();
        return new ResponseEntity<>(orderDetailsList, HttpStatus.OK);
    }

    // GET order details by id
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable("id") int id) {
        OrderDetails orderDetails = orderDetailService.findByOrderDetailsId(id);
        if (orderDetails != null) {
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST - create new order details
    @PostMapping
    public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
        try {
            OrderDetails newOrderDetails = orderDetailService.AddOrderDetails(orderDetails);
            return new ResponseEntity<>(newOrderDetails, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT - update order details
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable("id") int id, @RequestBody OrderDetails orderDetails) {
        try {
            orderDetailService.UpdateOrderDetails(id, orderDetails);
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE - delete order details by id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOrderDetails(@PathVariable("id") int id) {
        try {
            orderDetailService.DeleteOrderDetails(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
