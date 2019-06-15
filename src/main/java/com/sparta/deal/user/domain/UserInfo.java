package com.sparta.deal.user.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import static javax.persistence.GenerationType.TABLE;

@Getter
@Setter
@Entity
@Table(name = "deal_user")
public class UserInfo implements UserDetails {
    @Id
    private String userId;//유저 ID
    private String password; //패스워드
    private Integer age; //나이
    private Integer sex; //성별
    private String email; //이메일 주소
    private LocalDateTime createTime; //생성 시간
    @ElementCollection
    @CollectionTable(
            name="deal_user_role",
            joinColumns=@JoinColumn(name="deal_authorization"))
    private List<String> roleNames = new ArrayList<>(); //유저 권한 목록

    private UserInfo() {}

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
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.createTime = LocalDateTime.now();
        //default 권한 자동 생성
        this.roleNames = Arrays.asList("ROLE_USER");
    }

    public List<String> getRoleNames() {
        return roleNames;
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


    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", roleNames=" + roleNames +
                '}';
    }
}
