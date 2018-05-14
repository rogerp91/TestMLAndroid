
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

public class SearchLocation {

    @SerializedName("city")
    private City mCity;
    @SerializedName("neighborhood")
    private Neighborhood mNeighborhood;
    @SerializedName("state")
    private State mState;

    public City getCity() {
        return mCity;
    }

    public void setCity(City city) {
        mCity = city;
    }

    public Neighborhood getNeighborhood() {
        return mNeighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        mNeighborhood = neighborhood;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }

}
