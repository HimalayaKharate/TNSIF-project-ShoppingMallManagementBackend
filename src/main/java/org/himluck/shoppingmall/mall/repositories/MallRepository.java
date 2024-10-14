package org.himluck.shoppingmall.mall.repositories;

import org.himluck.shoppingmall.mall.entities.Mall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallRepository extends JpaRepository<Mall, Integer> {
}
