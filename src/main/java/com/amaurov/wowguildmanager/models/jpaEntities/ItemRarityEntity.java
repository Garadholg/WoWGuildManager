package com.amaurov.wowguildmanager.models.jpaEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ItemRarity")
public class ItemRarityEntity implements Serializable {

    @Id
    @Column(name = "IDItemRarity")
    private int id;

    private String rarity;

    @OneToMany(mappedBy = "rarity")
    private Set<ItemEntity> items;

    public int getId() {
        return id;
    }

    public String getRarity() {
        return rarity;
    }
}
