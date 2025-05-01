package com.skamix.Cardos.model;

public class AuthResponse {
    private Long id_user;
    private boolean success;
    private String message;

    public AuthResponse() {}

    public AuthResponse(Long id, boolean success, String message) {
        this.id_user = id;
        this.success = success;
        this.message = message;
    }

    public Long getIs_user() {
        return id_user;
    }

    public void setIs_user(Long is_user) {
        this.id_user = is_user;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}