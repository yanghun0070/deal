package com.num6pj.molamola.user.application;

import com.num6pj.molamola.user.domain.UserInfo;

import java.util.Optional;


public interface UserService {

    /**
     * 회원 가입
     * @param user 신규 생성되는 유저 정보
     */
    public void join(UserInfo user) throws Exception;

    /**
     * ID 에 의해 유저 정보를 찾는다.
     * @param userId ID
     * @return 유저 정보
     * @throws Exception
     */
    public Optional<UserInfo> findByUserId(String userId) throws Exception;

}
