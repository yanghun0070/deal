package com.num6pj.molamola.category.presentation.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CategoryVo {
    private String name; //카테고리명
    private String userName; //유저명
    private String createDate; //생성일자

    public CategoryVo() {
    }

    public CategoryVo(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
