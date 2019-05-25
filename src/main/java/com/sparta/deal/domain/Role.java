package com.sparta.deal.domain;

import javax.persistence.*;

@Entity
@Table(name = "deal_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleSeq;

    @Column
    private String name;
/*
    @Column
    private Date createTime;*/

    @OneToOne
    @JoinColumn(name = "roleSeq", insertable=false, updatable=false)
    private UserRole userRole;

    public Integer getRoleSeq() {
        return roleSeq;
    }

    public void setRoleSeq(Integer roleSeq) {
        this.roleSeq = roleSeq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

/*
    @Override
    public String toString() {
        return "Role{" +
                "roleSeq='" + roleSeq + '\'' +
                ", name='" + name + '\'' +
                ", userRole=" + userRole +
                '}';
    }*/
}
