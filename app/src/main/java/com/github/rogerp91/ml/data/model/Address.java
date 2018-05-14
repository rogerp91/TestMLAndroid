package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Address {

    @SerializedName("city_id")
    public String mCityId;
    @SerializedName("city_name")
    public String mCityName;
    @SerializedName("state_id")
    public String mStateId;
    @SerializedName("state_name")
    public String mStateName;

    public String getCityId() {
        return mCityId;
    }

    public void setCityId(String cityId) {
        mCityId = cityId;
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    public String getStateId() {
        return mStateId;
    }

    public void setStateId(String stateId) {
        mStateId = stateId;
    }

    public String getStateName() {
        return mStateName;
    }

    public void setStateName(String stateName) {
        mStateName = stateName;
    }

}
