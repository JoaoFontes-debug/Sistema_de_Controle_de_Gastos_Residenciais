package com.teste.gestaofinanceira.dto;

public enum PersonType {
    ADMIN("admin"),
    USER("user");

    private String role;

    PersonType (String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
