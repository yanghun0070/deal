package com.sparta.deal.user.application.impl;

import com.sparta.deal.user.domain.UserInfo;
import com.sparta.deal.user.infra.UserJpaRepository;
import com.sparta.deal.user.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public void create(UserInfo user) {
        System.out.println("xxx222:" + user.toString());

        userJpaRepository.save(new UserInfo(user.getUserId(),
                user.getPassword(),
                user.getAge(), user.getSex(), user.getEmail()));
    }

    @Override
    public Optional<UserInfo> findByUserId(String userId) throws Exception {
        return userJpaRepository.findByUserId(userId);
    }

}
