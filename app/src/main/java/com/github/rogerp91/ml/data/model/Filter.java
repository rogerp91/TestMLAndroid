
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Filter {

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("values")
    private List<Value> mValues;

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

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public List<Value> getValues() {
        return mValues;
    }

    public void setValues(List<Value> values) {
        mValues = values;
    }

}
