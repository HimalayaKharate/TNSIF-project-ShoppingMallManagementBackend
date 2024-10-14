package org.himluck.shoppingmall.user.repo;

import org.himluck.shoppingmall.user.entities.MallAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallAdminRepo extends JpaRepository<MallAdmin, Integer> {
}
