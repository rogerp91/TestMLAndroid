
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Picture {

    @SerializedName("id")
    public String mId;
    @SerializedName("max_size")
    public String mMaxSize;
    @SerializedName("quality")
    public String mQuality;
    @SerializedName("secure_url")
    public String mSecureUrl;
    @SerializedName("size")
    public String mSize;
    @SerializedName("url")
    public String mUrl;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getMaxSize() {
        return mMaxSize;
    }

    public void setMaxSize(String maxSize) {
        mMaxSize = maxSize;
    }

    public String getQuality() {
        return mQuality;
    }

    public void setQuality(String quality) {
        mQuality = quality;
    }

    public String getSecureUrl() {
        return mSecureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        mSecureUrl = secureUrl;
    }

    public String getSize() {
        return mSize;
    }

    public void setSize(String size) {
        mSize = size;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
