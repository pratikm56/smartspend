package com.smartspend.dto;

import java.util.UUID;

public class AuthResponse {

    private UUID id;
    private String name;
    private String email;
    private boolean emailVerified;

    public AuthResponse(
            UUID id,
            String name,
            String email,
            boolean emailVerified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.emailVerified = emailVerified;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }
}