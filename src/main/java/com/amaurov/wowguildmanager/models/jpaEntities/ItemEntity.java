package com.amaurov.wowguildmanager.models.jpaEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Item")
public class ItemEntity implements Serializable {

    @Id
    @Column(name = "IDItem")
    private int id;

    @Column(name = "ItemName")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ItemRarityID", nullable = false)
    private ItemRarityEntity rarity;

    @ManyToOne
    @JoinColumn(name = "ItemSlotID", nullable = false)
    private ItemSlotEntity slot;

    @Column(name = "IconName")
    private String iconName;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemSlotEntity getSlot() {
        return slot;
    }

    public String getIconName() {
        return iconName;
    }
}
