package com.deal.shoppinggogo.user.domain;

import java.util.regex.Pattern;

public class Email {
    private String name;

    private void validate(String name) {
        boolean isEmailPattern = Pattern.matches("^[a-zA-z0-9]+@[a-zA-Z0-9]+.+[a-zA-Z]$", name);
        if(!isEmailPattern) throw new IllegalArgumentException("email don't match");
    }

    private Email() {
    }

    public Email(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Email{" +
                "name='" + name + '\'' +
                '}';
    }
}
