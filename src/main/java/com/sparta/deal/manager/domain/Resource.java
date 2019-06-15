package com.sparta.deal.manager.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * HTTP 요청했을 시, URI
 * ex) /user/join
 */
@Entity
@Table(name = "deal_resource")
public class Resource {
    @Id
    @GeneratedValue
    private Long id;
    private String name; //리소스명
    private LocalDateTime createTime; //생성 시간

    private Resource() {}

    public Resource(String name) {
        this.name = name;
        this.createTime = LocalDateTime.now();
    }
}
