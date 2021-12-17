package com.amaurov.wowguildmanager.utils.messaging.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class EquipItemRequest {
    @NotEmpty
    @Min(1)
    private int characterId;

    @NotEmpty
    @Min(1)
    private int itemId;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
