package com.example.engineerProject.OwnValidatior;

public enum Lang {
    INJECTION_WORDS(new String[]
            {
            "select", "update", "drop", "delete", "from",
            "SELECT", "UPDATE", "DROP", "DELETE", "FROM"
            });

    private final String[] injectionWords;

    Lang(String[] injectionWords) {
        this.injectionWords = injectionWords;
    }

    public String[] getInjectionWords() {
        return injectionWords;
    }
}
