package com.sparta.deal.domain;

import javax.persistence.*;

@Entity
@Table(name = "deal_user_role")
public class UserRole {

    @Id
    private Integer userRoleSeq;

    @Column
    private String userId;

    @Column
    private Integer roleSeq;

    @ManyToOne
    @JoinColumn(name = "userId",insertable=false, updatable=false)
    private UserInfo userInfo;

    @OneToOne(mappedBy="userRole")
    private Role role;

    public Integer getUserRoleSeq() {
        return userRoleSeq;
    }

    public void setUserRoleSeq(Integer userRoleSeq) {
        this.userRoleSeq = userRoleSeq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleSeq() {
        return roleSeq;
    }

    public void setRoleSeq(Integer roleSeq) {
        this.roleSeq = roleSeq;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /*@Override
    public String toString() {
        return "UserRole{" +
                "userId='" + userId + '\'' +
                ", roleSeq=" + roleSeq +
                ", userInfo=" + userInfo +
                ", role=" + role +
                '}';
    }*/
}
