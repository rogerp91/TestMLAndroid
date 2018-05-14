
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class City {

    @SerializedName("id")
    public String mId;
    @SerializedName("name")
    public String mName;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
