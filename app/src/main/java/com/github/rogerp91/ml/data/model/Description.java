
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

public class Description {

    @SerializedName("id")
    private String mId;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

}
