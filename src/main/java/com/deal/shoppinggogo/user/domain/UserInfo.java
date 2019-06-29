package com.deal.shoppinggogo.user.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "deal_user")
public class UserInfo implements UserDetails {
    @Id @Column(name = "user_id")
    private String userId;//유저 ID
    private String password; //패스워드
    private Integer age; //나이
    private Integer sex; //성별
    @Embedded
    private Email email; //이메일 주소
    private LocalDateTime createTime; //생성 시간
    @OneToMany(mappedBy = "user") //연관되어 매핑된 UserInfo 정의된 객체
    private List<UserAuthorization> userAuthorizations = new ArrayList<>();

    private UserInfo() {}

    public UserInfo(String userId) {
        this.userId = userId;
    }

    /**
     * 회원 가입 시에, 추가되는 목록
     * @param userId ID
     * @param password 비밀번호
     * @param age 나이
     * @param sex 성별
     * @param email 이메일
     */
    public UserInfo(String userId, String password, Integer age, Integer sex,
                    String email) {
        this.userId = userId;
        /**
         * @todo 비밀번호 Pattern 추후, 구현
         *      UserDetails 와 Relation 되어 있기 때문에
         *      Security 유저 객체 용도와 Entity 용도를 분리시킨 후,
         *      Password Pattern  구현
         */
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = new Email(email);
        this.createTime = LocalDateTime.now();
    }

    public void addUserAuthorization(UserAuthorization userAuthorization) {
        //무한 루프에 빠지는 거 방지
        if(userAuthorization == null) {
            userAuthorizations = new ArrayList<>();
        }
        userAuthorizations.add(userAuthorization);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
