package com.amaurov.wowguildmanager.models.jpaEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CharacterItem")
public class CharacterItemEntity implements Serializable {

    @Id
    @Column(name = "IDCharacterItem")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserCharacterID", nullable = false)
    private CharacterEntity character;

    @ManyToOne
    @JoinColumn(name = "ItemSlotID", nullable = false)
    private ItemSlotEntity slot;

    @ManyToOne
    @JoinColumn(name = "ItemID", nullable = false)
    private ItemEntity item;

    public int getId() {
        return id;
    }

    public ItemSlotEntity getSlot() {
        return slot;
    }

    public ItemEntity getItem() {
        return item;
    }
}
