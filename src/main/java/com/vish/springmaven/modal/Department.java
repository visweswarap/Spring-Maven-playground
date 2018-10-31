package com.vish.springmaven.modal;

public enum Department {

    DEVELOPMENT(1, "Development"),
    TESTING(2, "Testing");

    private int id;

    private String name;

    Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
