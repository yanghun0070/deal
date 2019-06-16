package com.sparta.deal.user.infra;

import com.sparta.deal.user.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserInfo, Integer> {

    /**
     * ID 에 의해 유저를 조회한다.
     * @param userId 유저 ID
     * @return 유저 정보
     */
    public Optional<UserInfo> findByUserId(String userId);


}
