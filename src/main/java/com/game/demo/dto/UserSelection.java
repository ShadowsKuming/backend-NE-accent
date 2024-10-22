package com.game.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSelection {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_selection")
    private String selection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
}
