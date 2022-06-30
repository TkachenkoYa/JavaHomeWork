package com.hl.hw28.src.main.java.domain;

public enum UserRole {
    ADMIN(0,"ADMIN"),
    USER(1,"USER");
    public final int role;
    public final String title;
 ;

    public String getTitle() {
        return title;
    }

    public int getRole() {
        return role;
    }

    UserRole(int role, String title) {
        this.title = title;
        this.role = role;
    }
}
