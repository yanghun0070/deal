package com.num6pj.molamola.category.domain;

import com.num6pj.molamola.category.presentation.vo.CategoryVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Entity
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String categoryName;
     private int createAt;

    public Category(CategoryVO categoryVO) {
        this.categoryName = categoryVO.getCategoryName();
        this.createAt = categoryVO.getCreateAt();
    }


}
