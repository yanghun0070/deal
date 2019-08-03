package com.num6pj.molamola.manager.presentation.vo;


import java.util.List;

/**
 * 리소스
 */
public class ResourceVo {
    private String name; //리소스명
    private String description; //리소스 설명
    private List<String> authorizationNames; //리소스 명

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAuthorizationNames() {
        return authorizationNames;
    }

    @Override
    public String toString() {
        return "ResourceVo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorizationNames=" + authorizationNames +
                '}';
    }
}
