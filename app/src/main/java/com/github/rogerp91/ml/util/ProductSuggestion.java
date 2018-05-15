package com.github.rogerp91.ml.util;

import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

/**
 * Objeto para hacer filtros en el search - NO USADO
 */
public class ProductSuggestion implements SearchSuggestion {

    private String name;
    private String id;

    public ProductSuggestion(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public ProductSuggestion(String name) {
        this.name = name;
    }

    public ProductSuggestion(Parcel source) {
        this.name = source.readString();
        this.id = source.readString();
    }


    @Override
    public String getBody() {
        return name;
    }

    public static final Creator<ProductSuggestion> CREATOR = new Creator<ProductSuggestion>() {
        @Override
        public ProductSuggestion createFromParcel(Parcel in) {
            return new ProductSuggestion(in);
        }

        @Override
        public ProductSuggestion[] newArray(int size) {
            return new ProductSuggestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
    }
}