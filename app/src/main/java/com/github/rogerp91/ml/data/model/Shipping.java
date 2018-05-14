
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Shipping {

    @SerializedName("free_shipping")
    public Boolean mFreeShipping;
    @SerializedName("logistic_type")
    public String mLogisticType;
    @SerializedName("mode")
    public String mMode;
    @SerializedName("tags")
    public List<String> mTags;

    @SerializedName("free_methods")
    public List<FreeMethod> freeMethods = null;

    public List<FreeMethod> getFreeMethods() {
        return freeMethods;
    }

    public void setFreeMethods(List<FreeMethod> freeMethods) {
        this.freeMethods = freeMethods;
    }

    public Boolean getFreeShipping() {
        return mFreeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        mFreeShipping = freeShipping;
    }

    public String getLogisticType() {
        return mLogisticType;
    }

    public void setLogisticType(String logisticType) {
        mLogisticType = logisticType;
    }

    public String getMode() {
        return mMode;
    }

    public void setMode(String mode) {
        mMode = mode;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

}
