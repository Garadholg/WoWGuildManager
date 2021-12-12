package com.amaurov.wowguildmanager.models;

public class Class {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Class(int id, String className) {
        this.id = id;
        this.name = className;
    }

}
