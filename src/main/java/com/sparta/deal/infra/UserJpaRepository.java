package com.sparta.deal.infra;

import com.sparta.deal.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserInfo, Integer> {

    public Optional<UserInfo> findById(String id);
}
