
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuerySearch {

    @SerializedName("available_filters")
    private List<AvailableFilter> mAvailableFilters;
    @SerializedName("available_sorts")
    private List<AvailableSort> mAvailableSorts;
    @SerializedName("filters")
    private List<Filter> mFilters;
    @SerializedName("paging")
    private Paging mPaging;
    @SerializedName("query")
    private String mQuery;
    @SerializedName("related_results")
    private List<Object> mRelatedResults;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("secondary_results")
    private List<Object> mSecondaryResults;
    @SerializedName("site_id")
    private String mSiteId;
    @SerializedName("sort")
    private Sort mSort;

    public List<AvailableFilter> getAvailableFilters() {
        return mAvailableFilters;
    }

    public void setAvailableFilters(List<AvailableFilter> availableFilters) {
        mAvailableFilters = availableFilters;
    }

    public List<AvailableSort> getAvailableSorts() {
        return mAvailableSorts;
    }

    public void setAvailableSorts(List<AvailableSort> availableSorts) {
        mAvailableSorts = availableSorts;
    }

    public List<Filter> getFilters() {
        return mFilters;
    }

    public void setFilters(List<Filter> filters) {
        mFilters = filters;
    }

    public Paging getPaging() {
        return mPaging;
    }

    public void setPaging(Paging paging) {
        mPaging = paging;
    }

    public String getQuery() {
        return mQuery;
    }

    public void setQuery(String query) {
        mQuery = query;
    }

    public List<Object> getRelatedResults() {
        return mRelatedResults;
    }

    public void setRelatedResults(List<Object> relatedResults) {
        mRelatedResults = relatedResults;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

    public List<Object> getSecondaryResults() {
        return mSecondaryResults;
    }

    public void setSecondaryResults(List<Object> secondaryResults) {
        mSecondaryResults = secondaryResults;
    }

    public String getSiteId() {
        return mSiteId;
    }

    public void setSiteId(String siteId) {
        mSiteId = siteId;
    }

    public Sort getSort() {
        return mSort;
    }

    public void setSort(Sort sort) {
        mSort = sort;
    }

}
