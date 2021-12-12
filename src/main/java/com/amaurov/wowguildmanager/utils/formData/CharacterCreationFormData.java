package com.amaurov.wowguildmanager.utils.formData;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CharacterCreationFormData {
    @NotEmpty
    @Size(min = 3, max = 25)
    private String characterName;
    private int specID;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getSpecID() {
        return specID;
    }

    public void setSpecID(int specID) {
        this.specID = specID;
    }
}
