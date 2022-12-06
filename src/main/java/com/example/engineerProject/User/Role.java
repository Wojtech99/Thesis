package com.example.engineerProject.User;

public enum Role {
    MANAGER("MANAGER"),
    AGENT("AGENT");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
