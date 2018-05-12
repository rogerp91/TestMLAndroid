
package com.github.rogerp91.ml.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seller {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("power_seller_status")
    @Expose
    private Object powerSellerStatus;
    @SerializedName("car_dealer")
    @Expose
    private Boolean carDealer;
    @SerializedName("real_estate_agency")
    @Expose
    private Boolean realEstateAgency;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getPowerSellerStatus() {
        return powerSellerStatus;
    }

    public void setPowerSellerStatus(Object powerSellerStatus) {
        this.powerSellerStatus = powerSellerStatus;
    }

    public Boolean getCarDealer() {
        return carDealer;
    }

    public void setCarDealer(Boolean carDealer) {
        this.carDealer = carDealer;
    }

    public Boolean getRealEstateAgency() {
        return realEstateAgency;
    }

    public void setRealEstateAgency(Boolean realEstateAgency) {
        this.realEstateAgency = realEstateAgency;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

}
