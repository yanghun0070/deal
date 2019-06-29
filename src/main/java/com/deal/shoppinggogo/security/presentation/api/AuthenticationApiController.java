package com.deal.shoppinggogo.security.presentation.api;

import com.deal.shoppinggogo.security.application.AuthenticationService;
import com.deal.shoppinggogo.security.domain.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 인증 API
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationApiController {

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * 인증 로그인
     * @param data
     * @return
     * @throws Exception
     */
    @PostMapping("signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) throws Exception {
        return authenticationService.signin(data);
    }

}
