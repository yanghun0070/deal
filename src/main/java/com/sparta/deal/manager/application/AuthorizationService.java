package com.sparta.deal.manager.application;

import com.sparta.deal.manager.domain.Authorization;
import com.sparta.deal.manager.infra.AuthorizationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationJpaRepository authorizationJpaRepository;


    /**
     * 권한 목록을 생성한다.
     * @param authorizations 권한 목록
     */
    public void create(List<Authorization> authorizations) {
        authorizationJpaRepository.saveAll(authorizations);
    }
}
