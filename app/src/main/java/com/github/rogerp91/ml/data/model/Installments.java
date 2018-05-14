
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Installments {

    @SerializedName("amount")
    public Double mAmount;
    @SerializedName("currency_id")
    public String mCurrencyId;
    @SerializedName("quantity")
    public Long mQuantity;
    @SerializedName("rate")
    public Double mRate;

    public Double getAmount() {
        return mAmount;
    }

    public void setAmount(Double amount) {
        mAmount = amount;
    }

    public String getCurrencyId() {
        return mCurrencyId;
    }

    public void setCurrencyId(String currencyId) {
        mCurrencyId = currencyId;
    }

    public Long getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Long quantity) {
        mQuantity = quantity;
    }

    public Double getRate() {
        return mRate;
    }

    public void setRate(Double rate) {
        mRate = rate;
    }

}
