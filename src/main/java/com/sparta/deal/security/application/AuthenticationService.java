package com.sparta.deal.security.application;

import com.sparta.deal.manager.domain.Authorization;
import com.sparta.deal.manager.infra.AuthorizationJpaRepository;
import com.sparta.deal.security.config.JwtTokenProvider;
import com.sparta.deal.security.domain.AuthenticationRequest;
import com.sparta.deal.user.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    /**
     *
     * @param data Authentication Request
     * @return
     * @throws Exception
     */
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) throws Exception {
        try {
            String userName = data.getUsername();
            /**
             * @todo 비밀번호 인증 구현할 때, 필요
             */
//            Authentication authentication =
//                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, data.getPassword()));
            String token = jwtTokenProvider.createToken(userName,
                    userService.findByUserId(userName)
                            .orElseThrow(() ->
                                    new UsernameNotFoundException("Username " + userName + " not found"))
                            .getUserAuthorizations()
                            .stream()
                            .map(userAuthorization ->
                                    userAuthorization.getRoleName())
                            .collect(Collectors.toList()));
            Map<Object, Object> model = new HashMap<>();
            model.put("username", userName);
            model.put("token", token);
            return ok(model);
        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}
