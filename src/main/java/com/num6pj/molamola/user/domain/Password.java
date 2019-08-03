package com.num6pj.molamola.user.domain;

public class Password {
    private String name;
    public Password(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Password{" +
                "name='" + name + '\'' +
                '}';
    }
}
