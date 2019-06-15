package com.sparta.deal.manager.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Security 는 Prefix 를 ROLE 을 통해 ROLE에 등록된 자원을 검색한다.
 * ex) ROLE_ADMIN, ROLE_USER
 */
@Entity
@Table(name = "deal_authorization")
public class Authorization {

    @Id
    @GeneratedValue
    private Integer roleSeq;
    private String name;
    private LocalDateTime createTime;

    private Authorization() {
    }

    public Authorization(String name) {
        this.name = name;
        this.createTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }
}
