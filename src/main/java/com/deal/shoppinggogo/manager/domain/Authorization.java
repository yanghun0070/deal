package com.deal.shoppinggogo.manager.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Security 는 Prefix 를 ROLE 을 통해 ROLE에 등록된 자원을 검색한다.
 * ex) ROLE_ADMIN, ROLE_USER
 */
@Entity
@Table(name = "deal_authorization")
public class Authorization {

    @Id @Column(name = "authorization_id")
    @GeneratedValue
    private Integer id; //권한 일련번호
    private String name; //권한 명
    private String description; //권한 설명
    private LocalDateTime createTime; //권한 생성시간
    @ManyToMany(mappedBy = "authorizations")
    private List<Resource> resources = new ArrayList<>(); //리소스 목록

    private Authorization() {}

    public Authorization(String name, String description) {
        this.name = name;
        this.description = description;
        this.createTime = LocalDateTime.now();
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
        if(resource.getAuthorizations().contains(this)){
            resource.getAuthorizations().add(this);
        }
    }

    public List<Resource> getResources() {
        return resources;
    }

    public String getName() {
        return name;
    }
}
