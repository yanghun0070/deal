package com.sparta.deal.user.domain;

import javax.persistence.*;

/**
 * 유저 권한
 */
@Entity
@Table(name = "deal_userauthorization")
public class UserAuthorization {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user; //유저 정보
    private String roleName; //권한 명

    private UserAuthorization() {}

    public UserAuthorization(UserInfo user, String roleName) {
        this.user = user;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setUser(UserInfo user) {
        this.user = user;
        //무한 루프에 빠지는 거 방지
        if(this.user.getUserAuthorizations().contains(this)) {
            this.user.getUserAuthorizations().add(this);
        }
    }

    @Override
    public String toString() {
        return "UserAuthorization{" +
                "id=" + id +
                ", user=" + user +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
