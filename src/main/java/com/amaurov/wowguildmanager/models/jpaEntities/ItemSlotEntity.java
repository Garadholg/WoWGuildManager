package com.amaurov.wowguildmanager.models.jpaEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ItemSlot")
public class ItemSlotEntity implements Serializable {

    @Id
    @Column(name = "IDItemSlot")
    private int id;

    private String slot;

    @OneToMany(mappedBy = "slot")
    private Set<CharacterItemEntity> characters;

    @OneToMany(mappedBy = "slot")
    private Set<ItemEntity> items;

    public int getId() {
        return id;
    }

    public String getSlot() {
        return slot;
    }
}
