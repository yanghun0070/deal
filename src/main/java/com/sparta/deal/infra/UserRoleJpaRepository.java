package com.sparta.deal.infra;

import com.sparta.deal.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleJpaRepository extends JpaRepository<UserRole, Integer> {

    /**
     *
     * @param userId
     * @return
     */
    List<UserRole> findByUserId(String userId);
}
