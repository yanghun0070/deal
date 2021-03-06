package com.num6pj.molamola.user.presentation.vo;


public class UserVo {
    private String userId;//유저 ID
    private String password; //패스워드
    private Integer age; //나이
    private Integer sex; //성별
    private String emailName; //이메일 주소

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSex() {
        return sex;
    }

    public String getEmailName() {
        return emailName;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", emailName='" + emailName + '\'' +
                '}';
    }
}
