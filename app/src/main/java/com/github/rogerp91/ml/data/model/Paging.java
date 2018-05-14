
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

public class Paging {

    @SerializedName("limit")
    private Long mLimit;
    @SerializedName("offset")
    private Long mOffset;
    @SerializedName("primary_results")
    private Long mPrimaryResults;
    @SerializedName("total")
    private Long mTotal;

    public Long getLimit() {
        return mLimit;
    }

    public void setLimit(Long limit) {
        mLimit = limit;
    }

    public Long getOffset() {
        return mOffset;
    }

    public void setOffset(Long offset) {
        mOffset = offset;
    }

    public Long getPrimaryResults() {
        return mPrimaryResults;
    }

    public void setPrimaryResults(Long primaryResults) {
        mPrimaryResults = primaryResults;
    }

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

}
