package org.himluck.shoppingmall.mall.repositories;

import org.himluck.shoppingmall.mall.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    // Custom query methods (if needed) can be added here.
}
