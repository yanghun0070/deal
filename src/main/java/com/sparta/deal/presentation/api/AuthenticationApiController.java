package com.sparta.deal.presentation.api;

import com.sparta.deal.security.JwtTokenProvider;
import com.sparta.deal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

/**
 * 인증 API
 */
@RestController
@RequestMapping("/v1/auth")
public class AuthenticationApiController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    /**
     * 인증 로그인
     * @param data
     * @return
     * @throws Exception
     */
    @PostMapping("signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) throws Exception {

        // @todo 아래 링크 삭제 하고 정리 귀찮아서 나중에.. ㅠㅠㅠㅠ
        // 암호화를 넣지 않는 경우 에러가 난다. "{noop}" https://meaownworld.tistory.com/129
        //https://stackoverflow.com/questions/51208425/how-to-use-spring-security-without-password-encoding
        //https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#pe-dpe
        //https://springbootdev.com/2017/08/29/spring-security-http-basic-authentication-example/
        try {
            String userName = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, data.getPassword()));
            String token = jwtTokenProvider.createToken(userName,
                    this.userService.findRolesById(userName)
                            .orElseThrow(
                                    () -> new UsernameNotFoundException("Username " + userName + " not found"))
                            .getUserRoles()
                            .stream()
                            .map(x -> x.getRole().getName())
                            .collect(Collectors.toList())
            );
            Map<Object, Object> model = new HashMap<>();
            model.put("username", userName);
            model.put("token", token);
            return ok(model);
        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}
