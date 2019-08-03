package com.num6pj.molamola.security.application;

import com.num6pj.molamola.user.infra.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return this.userJpaRepository.findByUserId(userId).orElseThrow(
                () -> new UsernameNotFoundException("Username: " + userId + " not found"));
    }
}
