
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class SellerAddress {

    @SerializedName("address_line")
    public String mAddressLine;
    @SerializedName("city")
    public City mCity;
    @SerializedName("comment")
    public String mComment;
    @SerializedName("country")
    public Country mCountry;
    @SerializedName("id")
    public String mId;
    @SerializedName("latitude")
    public String mLatitude;
    @SerializedName("longitude")
    public String mLongitude;
    @SerializedName("state")
    public State mState;
    @SerializedName("zip_code")
    public String mZipCode;

    public String getAddressLine() {
        return mAddressLine;
    }

    public void setAddressLine(String addressLine) {
        mAddressLine = addressLine;
    }

    public City getCity() {
        return mCity;
    }

    public void setCity(City city) {
        mCity = city;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public Country getCountry() {
        return mCountry;
    }

    public void setCountry(Country country) {
        mCountry = country;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String zipCode) {
        mZipCode = zipCode;
    }

}
