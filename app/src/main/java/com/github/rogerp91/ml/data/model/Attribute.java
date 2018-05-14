package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Attribute {

    @SerializedName("attribute_group_id")
    public String mAttributeGroupId;
    @SerializedName("attribute_group_name")
    public String mAttributeGroupName;
    @SerializedName("id")
    public String mId;
    @SerializedName("name")
    public String mName;
    @SerializedName("source")
    public Long mSource;
    @SerializedName("value_id")
    public String mValueId;
    @SerializedName("value_name")
    public String mValueName;

    public String getAttributeGroupId() {
        return mAttributeGroupId;
    }

    public void setAttributeGroupId(String attributeGroupId) {
        mAttributeGroupId = attributeGroupId;
    }

    public String getAttributeGroupName() {
        return mAttributeGroupName;
    }

    public void setAttributeGroupName(String attributeGroupName) {
        mAttributeGroupName = attributeGroupName;
    }

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

    public Long getSource() {
        return mSource;
    }

    public void setSource(Long source) {
        mSource = source;
    }

    public String getValueId() {
        return mValueId;
    }

    public void setValueId(String valueId) {
        mValueId = valueId;
    }

    public String getValueName() {
        return mValueName;
    }

    public void setValueName(String valueName) {
        mValueName = valueName;
    }


}
