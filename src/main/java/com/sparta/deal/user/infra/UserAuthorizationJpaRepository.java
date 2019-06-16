package com.sparta.deal.user.infra;

import com.sparta.deal.user.domain.UserAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorizationJpaRepository extends JpaRepository<UserAuthorization, Integer> {
}
