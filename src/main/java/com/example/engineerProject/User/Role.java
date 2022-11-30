package com.example.engineerProject.User;

public enum Role {
    MANAGER("Manager"),
    AGENT("Agent");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
