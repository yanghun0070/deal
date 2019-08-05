package com.num6pj.molamola.category.domain;



import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String name; //카테고리명
     private String userName; //유저명
     private LocalDateTime createDate; //생성 날짜

    public Category(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.createDate = LocalDateTime.now();
    }

}
