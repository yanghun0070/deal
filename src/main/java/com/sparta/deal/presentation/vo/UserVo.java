package com.sparta.deal.presentation.vo;

public class UserVo {

    private String id;//ID
    private Integer age; //나이
    private Integer sex; //성별
    private String address; //주소
    private String zipCode; //우편 물에 부착된 바코드 Zone Improvement Program
    private String passWord; //패스워드

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
