package com.num6pj.molamola.category.presentation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class CategoryVO {
    private String categoryName;
    private int createAt;

    public CategoryVO(String categoryName, int createAt) {
        this.categoryName=categoryName;
        this.createAt = createAt;

    }
}
