package com.example.abdulbasith.justeatapidemo.model;

/**
 * Created by AbdulBasit on 04/10/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TagDetail {

    @SerializedName("Key")
    @Expose
    private String key;
    @SerializedName("DisplayName")
    @Expose
    private String displayName;
    @SerializedName("Colour")
    @Expose
    private String colour;
    @SerializedName("BackgroundColour")
    @Expose
    private String backgroundColour;
    @SerializedName("Priority")
    @Expose
    private Integer priority;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBackgroundColour() {
        return backgroundColour;
    }

    public void setBackgroundColour(String backgroundColour) {
        this.backgroundColour = backgroundColour;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}

