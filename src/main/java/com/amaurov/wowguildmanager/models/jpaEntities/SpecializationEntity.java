package com.amaurov.wowguildmanager.models.jpaEntities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Specialization")
public class SpecializationEntity implements Serializable {

    @Id
    @Column(name = "IDSpecialization")
    private int id;

    @Column(name = "SpecName")
    private String name;

    @OneToMany(mappedBy = "spec")
    private Set<CharacterEntity> characters;

    @ManyToOne
    @JoinColumn(name = "ClassID", nullable = false)
    @JsonProperty("class")
    private ClassEntity wowClass;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClassEntity getWowClass() {
        return wowClass;
    }
}
