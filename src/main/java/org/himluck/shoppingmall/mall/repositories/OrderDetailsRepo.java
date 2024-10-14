package org.himluck.shoppingmall.mall.repositories;

import org.himluck.shoppingmall.mall.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

}
