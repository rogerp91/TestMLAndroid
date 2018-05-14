
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Value {

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("path_from_root")
    private List<PathFromRoot> mPathFromRoot;
    @SerializedName("results")
    private Long mResults;

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

    public List<PathFromRoot> getPathFromRoot() {
        return mPathFromRoot;
    }

    public void setPathFromRoot(List<PathFromRoot> pathFromRoot) {
        mPathFromRoot = pathFromRoot;
    }

    public Long getResults() {
        return mResults;
    }

    public void setResults(Long results) {
        mResults = results;
    }

}
