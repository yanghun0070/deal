package com.num6pj.molamola.manager.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * HTTP 요청했을 시, URI
 * ex) /user/join
 */
@Entity
@Table(name = "deal_resource")
public class Resource {
    @Id @Column(name = "resource_id")
    @GeneratedValue
    private Integer id;
    private String name; //리소스명
    private String description; //리소스 설명
    private LocalDateTime createTime; //생성 시간
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "deal_authorization_resource",//가상의 연결테이블 생성
    joinColumns = @JoinColumn(name = "resource_id"), //매핑할 조인 칼럼 정보
    inverseJoinColumns = @JoinColumn(name = "authorization_id")) //반대 방향인 상품과 매핑할 조인 칼럼 정보
    private List<Authorization> authorizations = new ArrayList<>(); //권한 목록

    private Resource() {}

    public Resource(String name, String description) {
        this.name = name;
        this.description = description;
        this.createTime = LocalDateTime.now();
    }

    public void addAuthorization(Authorization authorization) {
        this.authorizations.add(authorization);
        if(authorization.getResources().contains(this)){
            authorization.getResources().add(this);
        }
    }

    public List<Authorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<Authorization> authorizations) {
        this.authorizations = authorizations;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", authorizations=" + authorizations +
                '}';
    }
}
