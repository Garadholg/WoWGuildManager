package com.amaurov.wowguildmanager.utils.messaging.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UnequipItemRequest {
    @NotEmpty
    @Min(1)
    private int characterId;

    @NotEmpty
    @Min(1)
    private int slotId;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
}
