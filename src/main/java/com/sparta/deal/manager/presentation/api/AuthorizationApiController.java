package com.sparta.deal.manager.presentation.api;


import com.sparta.deal.manager.application.AuthorizationService;
import com.sparta.deal.manager.domain.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 권한 API
 */
@RestController
@RequestMapping("/authorization")
public class AuthorizationApiController {

    @Autowired
    private AuthorizationService authorizationService;

    /**
     * 권한 생성
     * @param authorizations
     * @return
     * @throws Exception
     */
    @PostMapping("create")
    public void create(@RequestBody List<Authorization> authorizations) throws Exception {
        authorizationService.create(authorizations);
    }

}
