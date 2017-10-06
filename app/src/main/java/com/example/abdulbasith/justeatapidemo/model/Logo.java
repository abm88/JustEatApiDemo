package com.example.abdulbasith.justeatapidemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by AbdulBasit on 04/10/2017.
 */

public class Logo {

    @SerializedName("StandardResolutionURL")
    @Expose
    private String standardResolutionURL;

    public String getStandardResolutionURL() {
        return standardResolutionURL;
    }

    public void setStandardResolutionURL(String standardResolutionURL) {
        this.standardResolutionURL = standardResolutionURL;
    }
}
