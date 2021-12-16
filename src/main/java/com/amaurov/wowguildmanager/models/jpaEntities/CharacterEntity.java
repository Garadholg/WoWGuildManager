package com.amaurov.wowguildmanager.models.jpaEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "userchar")
public class CharacterEntity implements Serializable {

    @Id
    @Column(name = "IDUserCharacter")
    private int id;

    @Column(name = "Username")
    private String user;

    @Column(name = "CharacterName")
    private String name;

    @ManyToOne
    @JoinColumn(name = "SpecID", nullable = false)
    private SpecializationEntity spec;

    @OneToMany(mappedBy = "character")
    private Set<CharacterItemEntity> items;

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public SpecializationEntity getSpec() {
        return spec;
    }

    public Set<CharacterItemEntity> getItems() {
        return items;
    }
}
