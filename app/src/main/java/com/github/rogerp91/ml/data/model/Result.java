package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Result {

    @SerializedName("accepts_mercadopago")
    public Boolean mAcceptsMercadopago;
    @SerializedName("address")
    public Address mAddress;
    @SerializedName("attributes")
    public List<Attribute> mAttributes;
    @SerializedName("available_quantity")
    public Long mAvailableQuantity;
    @SerializedName("buying_mode")
    public String mBuyingMode;
    @SerializedName("catalog_product_id")
    public String mCatalogProductId;
    @SerializedName("category_id")
    public String mCategoryId;
    @SerializedName("condition")
    public String mCondition;
    @SerializedName("currency_id")
    public String mCurrencyId;
    @SerializedName("id")
    public String mId;
    @SerializedName("installments")
    public Installments mInstallments;
    @SerializedName("listing_type_id")
    public String mListingTypeId;
    @SerializedName("official_store_id")
    public Long mOfficialStoreId;
//    @SerializedName("original_price")
//    public Object mOriginalPrice;
    @SerializedName("permalink")
    public String mPermalink;
    @SerializedName("price")
    public Double mPrice;
    @SerializedName("reviews")
    public Reviews mReviews;
    @SerializedName("seller")
    public Seller mSeller;
    @SerializedName("seller_address")
    public SellerAddress mSellerAddress;
    @SerializedName("shipping")
    public Shipping mShipping;
    @SerializedName("site_id")
    public String mSiteId;
    @SerializedName("sold_quantity")
    public Long mSoldQuantity;
    @SerializedName("stop_time")
    public String mStopTime;
    @SerializedName("tags")
    public List<String> mTags;
    @SerializedName("thumbnail")
    public String mThumbnail;
    @SerializedName("title")
    public String mTitle;

    public Boolean getAcceptsMercadopago() {
        return mAcceptsMercadopago;
    }

    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        mAcceptsMercadopago = acceptsMercadopago;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public List<Attribute> getAttributes() {
        return mAttributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        mAttributes = attributes;
    }

    public Long getAvailableQuantity() {
        return mAvailableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        mAvailableQuantity = availableQuantity;
    }

    public String getBuyingMode() {
        return mBuyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        mBuyingMode = buyingMode;
    }

    public String getCatalogProductId() {
        return mCatalogProductId;
    }

    public void setCatalogProductId(String catalogProductId) {
        mCatalogProductId = catalogProductId;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCondition() {
        return mCondition;
    }

    public void setCondition(String condition) {
        mCondition = condition;
    }

    public String getCurrencyId() {
        return mCurrencyId;
    }

    public void setCurrencyId(String currencyId) {
        mCurrencyId = currencyId;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Installments getInstallments() {
        return mInstallments;
    }

    public void setInstallments(Installments installments) {
        mInstallments = installments;
    }

    public String getListingTypeId() {
        return mListingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        mListingTypeId = listingTypeId;
    }

    public Long getOfficialStoreId() {
        return mOfficialStoreId;
    }

    public void setOfficialStoreId(Long officialStoreId) {
        mOfficialStoreId = officialStoreId;
    }

//    public Object getOriginalPrice() {
//        return mOriginalPrice;
//    }
//
//    public void setOriginalPrice(Object originalPrice) {
//        mOriginalPrice = originalPrice;
//    }

    public String getPermalink() {
        return mPermalink;
    }

    public void setPermalink(String permalink) {
        mPermalink = permalink;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Reviews getReviews() {
        return mReviews;
    }

    public void setReviews(Reviews reviews) {
        mReviews = reviews;
    }

    public Seller getSeller() {
        return mSeller;
    }

    public void setSeller(Seller seller) {
        mSeller = seller;
    }

    public SellerAddress getSellerAddress() {
        return mSellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        mSellerAddress = sellerAddress;
    }

    public Shipping getShipping() {
        return mShipping;
    }

    public void setShipping(Shipping shipping) {
        mShipping = shipping;
    }

    public String getSiteId() {
        return mSiteId;
    }

    public void setSiteId(String siteId) {
        mSiteId = siteId;
    }

    public Long getSoldQuantity() {
        return mSoldQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        mSoldQuantity = soldQuantity;
    }

    public String getStopTime() {
        return mStopTime;
    }

    public void setStopTime(String stopTime) {
        mStopTime = stopTime;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
