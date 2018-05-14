package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Rule {

    @SerializedName("default")
    @Expose
    public Boolean _default;
    @SerializedName("free_mode")
    @Expose
    public String freeMode;
    @SerializedName("free_shipping_flag")
    @Expose
    public Boolean freeShippingFlag;

    public Boolean getDefault() {
        return _default;
    }

    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    public String getFreeMode() {
        return freeMode;
    }

    public void setFreeMode(String freeMode) {
        this.freeMode = freeMode;
    }

    public Boolean getFreeShippingFlag() {
        return freeShippingFlag;
    }

    public void setFreeShippingFlag(Boolean freeShippingFlag) {
        this.freeShippingFlag = freeShippingFlag;
    }

}