package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class FreeMethod {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("rule")
    @Expose
    public Rule rule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

}