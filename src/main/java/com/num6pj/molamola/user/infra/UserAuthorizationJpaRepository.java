package com.num6pj.molamola.user.infra;

import com.deal.shoppinggogo.user.domain.UserAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorizationJpaRepository extends JpaRepository<UserAuthorization, Integer> {
}
