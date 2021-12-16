package com.amaurov.wowguildmanager.models;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Character {

    private int id;
    private String user;
    private String name;
    private int race;
    private Specialization spec;
    private boolean isMainChar;

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public int getRace() {
        return race;
    }

    public Specialization getSpec() {
        return spec;
    }

    public boolean isMainChar() {
        return isMainChar;
    }

    public Character() {
    }

    public Character(int id, String user, String name, Specialization spec, boolean isMainChar) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.race = 5;
        this.spec = spec;
        this.isMainChar = isMainChar;
    }
}
