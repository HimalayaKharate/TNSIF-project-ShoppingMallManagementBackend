package org.himluck.shoppingmall.user.repo;

import org.himluck.shoppingmall.user.entities.ShopOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOwnerRepo extends JpaRepository<ShopOwner, Integer> {
}
