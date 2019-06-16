package com.sparta.deal.manager.domain;

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

    private Resource() {}

    public Resource(String name, String description) {
        this.name = name;
        this.description = description;
        this.createTime = LocalDateTime.now();
    }
}
