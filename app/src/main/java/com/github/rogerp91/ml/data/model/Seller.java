
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Seller {

    @SerializedName("car_dealer")
    public Boolean mCarDealer;
    @SerializedName("id")
    public Long mId;
    @SerializedName("power_seller_status")
    public String mPowerSellerStatus;
    @SerializedName("real_estate_agency")
    public Boolean mRealEstateAgency;
    @SerializedName("tags")
    public List<String> mTags;

    public Boolean getCarDealer() {
        return mCarDealer;
    }

    public void setCarDealer(Boolean carDealer) {
        mCarDealer = carDealer;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getPowerSellerStatus() {
        return mPowerSellerStatus;
    }

    public void setPowerSellerStatus(String powerSellerStatus) {
        mPowerSellerStatus = powerSellerStatus;
    }

    public Boolean getRealEstateAgency() {
        return mRealEstateAgency;
    }

    public void setRealEstateAgency(Boolean realEstateAgency) {
        mRealEstateAgency = realEstateAgency;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

}
