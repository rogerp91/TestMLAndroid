
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute {

    @SerializedName("attribute_group_id")
    @Expose
    private String attributeGroupId;
    @SerializedName("attribute_group_name")
    @Expose
    private String attributeGroupName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("source")
    @Expose
    private Integer source;
    @SerializedName("value_id")
    @Expose
    private String valueId;
    @SerializedName("value_name")
    @Expose
    private String valueName;
    @SerializedName("value_struct")
    @Expose
    private Object valueStruct;

    public String getAttributeGroupId() {
        return attributeGroupId;
    }

    public void setAttributeGroupId(String attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public String getAttributeGroupName() {
        return attributeGroupName;
    }

    public void setAttributeGroupName(String attributeGroupName) {
        this.attributeGroupName = attributeGroupName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Object getValueStruct() {
        return valueStruct;
    }

    public void setValueStruct(Object valueStruct) {
        this.valueStruct = valueStruct;
    }

}
