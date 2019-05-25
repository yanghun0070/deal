package com.sparta.deal.service.impl;

import com.sparta.deal.domain.UserInfo;
import com.sparta.deal.infra.UserJpaRepository;
import com.sparta.deal.infra.UserRoleJpaRepository;
import com.sparta.deal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserRoleJpaRepository userRoleJpaRepository;

    @Override
    public void create(UserInfo user) {
        userJpaRepository.save(user);
    }

    @Override
    public Optional<UserInfo> findById(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<UserInfo> findRolesById(String id) throws Exception {
        return userJpaRepository.findById(id);
    }
}
