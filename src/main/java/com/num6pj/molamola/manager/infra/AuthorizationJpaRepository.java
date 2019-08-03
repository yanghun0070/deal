package com.num6pj.molamola.manager.infra;

import com.deal.shoppinggogo.manager.domain.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizationJpaRepository extends JpaRepository<Authorization, Integer> {

    /**
     * 권한 일련번호 목록틀 통해 권한 정보를 조회한다.
     * @param roleNames ROLE prefix 로된 권한 일련번호 목록
     * @return 권한 정보 목록
     */
    public List<Authorization> findByNameIn(List<Long> roleNames);
}
