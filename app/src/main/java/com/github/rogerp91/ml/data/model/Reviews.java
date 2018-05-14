
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Reviews {

    @SerializedName("rating_average")
    public Double mRatingAverage;
    @SerializedName("total")
    public int mTotal;

    public Double getRatingAverage() {
        return mRatingAverage;
    }

    public void setRatingAverage(Double ratingAverage) {
        mRatingAverage = ratingAverage;
    }

    public int getTotal() {
        return mTotal;
    }

    public void setTotal(int total) {
        mTotal = total;
    }

}
