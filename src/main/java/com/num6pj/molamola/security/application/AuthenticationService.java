package com.num6pj.molamola.security.application;

import com.num6pj.molamola.security.config.JwtTokenProvider;
import com.num6pj.molamola.security.domain.AuthenticationRequest;
import com.num6pj.molamola.user.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
    public ResponseEntity signin(@RequestBody AuthenticationRequest data, HttpServletResponse response) throws Exception {
        try {
            String userName = data.getUsername();
            final Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, data.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenProvider.createToken(userName,
                    userService.findByUserId(userName)
                            .orElseThrow(() ->
                                    new UsernameNotFoundException("Username " + userName + " not found"))
                            .getUserAuthorizations()
                            .stream()
                            .map(userAuthorization ->
                                    userAuthorization.getRoleName())
                            .collect(Collectors.toList()));
            //Header 에 정보를 추가시킨다.
//            jwtTokenProvider.addTokenInHeader(token, response);
            Map<Object, Object> model = new HashMap<>();
            model.put("username", userName);
            model.put("token", token);
            return ok(model);
        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}
