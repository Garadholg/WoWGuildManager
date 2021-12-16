package com.amaurov.wowguildmanager.models.jpaEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Class")
public class ClassEntity implements Serializable {

    @Id
    @Column(name = "IDClass")
    private int id;

    @Column(name = "ClassName")
    private String name;

    @OneToMany(mappedBy = "wowClass")
    private Set<SpecializationEntity> specs;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
