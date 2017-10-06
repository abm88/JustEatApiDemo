package com.example.abdulbasith.justeatapidemo.model;

/**
 * Created by AbdulBasit on 04/10/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResturentListModel {

    @SerializedName("Restaurants")
    @Expose
    private List<Restaurant> restaurants = null;
    @SerializedName("ShortResultText")
    @Expose
    private String shortResultText;
    @SerializedName("Area")
    @Expose
    private String area;
    @SerializedName("Errors")
    @Expose
    private Object errors;
    @SerializedName("HasErrors")
    @Expose
    private Boolean hasErrors;
    @SerializedName("MetaData")
    @Expose
    private MetaData metaData;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public String getShortResultText() {
        return shortResultText;
    }

    public void setShortResultText(String shortResultText) {
        this.shortResultText = shortResultText;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public Boolean getHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(Boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

}