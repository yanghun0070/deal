package com.sparta.deal.service;


        import com.sparta.deal.domain.UserInfo;

        import java.util.Optional;

public interface UserService {


    /**
     * 회원 가입
     * @param user 신규 생성되는 유저 정보
     */
    public void create(UserInfo user) throws Exception;

    /**
     * ID 에 의해 유저 정보를 찾는다.
     * @param id ID
     * @return 유저 정보
     * @throws Exception
     */
    public Optional<UserInfo> findById(String id) throws Exception;

    /**
     * ID 에 의해 유저 권한 정보를 찾는다.
     * @param id ID
     * @return 유저 권한 목록
     * @throws Exception
     */
    public Optional<UserInfo> findRolesById(String id) throws Exception;
}
