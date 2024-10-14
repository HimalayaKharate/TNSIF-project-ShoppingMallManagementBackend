package org.himluck.shoppingmall.mall.repository;

import org.himluck.shoppingmall.mall.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
