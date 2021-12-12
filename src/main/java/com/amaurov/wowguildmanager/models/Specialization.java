package com.amaurov.wowguildmanager.models;

public class Specialization {
    private int id;
    private Class specClass;
    private String name;

    public int getId() {
        return id;
    }

    public Class getSpecClass() {
        return specClass;
    }

    public String getName() {
        return name;
    }

    public Specialization(int id, Class specClass, String specName) {
        this.id = id;
        this.specClass = specClass;
        this.name = specName;
    }
}
