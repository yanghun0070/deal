package com.num6pj.molamola.user.application.impl;

import com.num6pj.molamola.user.application.UserService;
import com.num6pj.molamola.user.domain.UserAuthorization;
import com.num6pj.molamola.user.domain.UserInfo;
import com.num6pj.molamola.user.infra.UserAuthorizationJpaRepository;
import com.num6pj.molamola.user.infra.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserAuthorizationJpaRepository userAuthorizationJpaRepository;


    @Override
    public void join(UserInfo user) {
        //1:N 일 경우, insert 를 해 준후, 외래 키 때문에 update 를 해준다.
        UserInfo changedUser = new UserInfo(user.getUserId(),
                user.getPassword(),
                user.getAge(), user.getSex(),
                user.getEmail().getName());
        userJpaRepository.save(changedUser);
        //회원 가입 시, 유저 초기 권한 설정
        UserAuthorization userAuthorization =
            new UserAuthorization(changedUser, "ROLE_USER");
        userAuthorizationJpaRepository.save(userAuthorization);
        changedUser.addUserAuthorization(userAuthorization);
        userJpaRepository.save(changedUser);

    }

    @Override
    public Optional<UserInfo> findByUserId(String userId) throws Exception {
        return userJpaRepository.findByUserId(userId);
    }

}
