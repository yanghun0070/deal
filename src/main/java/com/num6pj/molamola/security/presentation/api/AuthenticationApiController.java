package com.num6pj.molamola.security.presentation.api;

import com.num6pj.molamola.security.application.AuthenticationService;
import com.num6pj.molamola.security.domain.AuthenticationRequest;
import com.num6pj.molamola.user.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

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
    public ResponseEntity signin(@RequestBody AuthenticationRequest data, HttpServletResponse response) throws Exception {
        return authenticationService.signin(data, response);
    }

    @GetMapping("me")
    public ResponseEntity currentUser(@AuthenticationPrincipal UserInfo userInfo){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userInfo.getUsername());
        model.put("roles", userInfo.getAuthorities()
                .stream()
                .map(a -> ((GrantedAuthority) a).getAuthority())
                .collect(Collectors.toList())
        );
        return ok(model);
    }
}
