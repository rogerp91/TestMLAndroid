
package com.github.rogerp91.ml.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("accepts_mercadopago")
    private Boolean mAcceptsMercadopago;
    @SerializedName("attributes")
    private List<Attribute> mAttributes;
    @SerializedName("automatic_relist")
    private Boolean mAutomaticRelist;
    @SerializedName("available_quantity")
    private int mAvailableQuantity;
    @SerializedName("base_price")
    private Double mBasePrice;
    @SerializedName("buying_mode")
    private String mBuyingMode;
    @SerializedName("catalog_product_id")
    private String mCatalogProductId;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("condition")
    private String mCondition;
    @SerializedName("coverage_areas")
    private List<String> mCoverageAreas;
    @SerializedName("currency_id")
    private String mCurrencyId;
    @SerializedName("date_created")
    private String mDateCreated;
    @SerializedName("deal_ids")
    private List<String> mDealIds;
    @SerializedName("descriptions")
    private List<Description> mDescriptions;
    @SerializedName("differential_pricing")
    private String mDifferentialPricing;
    @SerializedName("domain_id")
    private String mDomainId;
    @SerializedName("geolocation")
    private Geolocation mGeolocation;
    @SerializedName("health")
    private String mHealth;
    @SerializedName("id")
    private String mId;
    @SerializedName("initial_quantity")
    private Long mInitialQuantity;
    @SerializedName("international_delivery_mode")
    private String mInternationalDeliveryMode;
    @SerializedName("last_updated")
    private String mLastUpdated;
    @SerializedName("listing_source")
    private String mListingSource;
    @SerializedName("listing_type_id")
    private String mListingTypeId;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("non_mercado_pago_payment_methods")
    private List<String> mNonMercadoPagoPaymentMethods;
    @SerializedName("official_store_id")
    private Long mOfficialStoreId;
    @SerializedName("original_price")
    private String mOriginalPrice;
    @SerializedName("parent_item_id")
    private String mParentItemId;
    @SerializedName("permalink")
    private String mPermalink;
    @SerializedName("pictures")
    private List<Picture> mPictures;
    @SerializedName("price")
    private Double mPrice;
    @SerializedName("secure_thumbnail")
    private String mSecureThumbnail;
    @SerializedName("seller_address")
    private SellerAddress mSellerAddress;
    @SerializedName("seller_contact")
    private String mSellerContact;
    @SerializedName("seller_id")
    private Long mSellerId;
    @SerializedName("shipping")
    private Shipping mShipping;
    @SerializedName("site_id")
    private String mSiteId;
    @SerializedName("sold_quantity")
    private Long mSoldQuantity;
    @SerializedName("start_time")
    private String mStartTime;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("stop_time")
    private String mStopTime;
    @SerializedName("subtitle")
    private String mSubtitle;
    @SerializedName("tags")
    private List<String> mTags;
    @SerializedName("thumbnail")
    private String mThumbnail;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video_id")
    private String mVideoId;
    @SerializedName("warranty")
    private String mWarranty;

    public Boolean getAcceptsMercadopago() {
        return mAcceptsMercadopago;
    }

    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        mAcceptsMercadopago = acceptsMercadopago;
    }

    public List<Attribute> getAttributes() {
        return mAttributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        mAttributes = attributes;
    }

    public Boolean getAutomaticRelist() {
        return mAutomaticRelist;
    }

    public void setAutomaticRelist(Boolean automaticRelist) {
        mAutomaticRelist = automaticRelist;
    }

    public int getAvailableQuantity() {
        return mAvailableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        mAvailableQuantity = availableQuantity;
    }

    public Double getBasePrice() {
        return mBasePrice;
    }

    public void setBasePrice(Double basePrice) {
        mBasePrice = basePrice;
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

    public List<String> getCoverageAreas() {
        return mCoverageAreas;
    }

    public void setCoverageAreas(List<String> coverageAreas) {
        mCoverageAreas = coverageAreas;
    }

    public String getCurrencyId() {
        return mCurrencyId;
    }

    public void setCurrencyId(String currencyId) {
        mCurrencyId = currencyId;
    }

    public String getDateCreated() {
        return mDateCreated;
    }

    public void setDateCreated(String dateCreated) {
        mDateCreated = dateCreated;
    }

    public List<String> getDealIds() {
        return mDealIds;
    }

    public void setDealIds(List<String> dealIds) {
        mDealIds = dealIds;
    }

    public List<Description> getDescriptions() {
        return mDescriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        mDescriptions = descriptions;
    }

    public String getDifferentialPricing() {
        return mDifferentialPricing;
    }

    public void setDifferentialPricing(String differentialPricing) {
        mDifferentialPricing = differentialPricing;
    }

    public String getDomainId() {
        return mDomainId;
    }

    public void setDomainId(String domainId) {
        mDomainId = domainId;
    }

    public Geolocation getGeolocation() {
        return mGeolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        mGeolocation = geolocation;
    }

    public String getHealth() {
        return mHealth;
    }

    public void setHealth(String health) {
        mHealth = health;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Long getInitialQuantity() {
        return mInitialQuantity;
    }

    public void setInitialQuantity(Long initialQuantity) {
        mInitialQuantity = initialQuantity;
    }

    public String getInternationalDeliveryMode() {
        return mInternationalDeliveryMode;
    }

    public void setInternationalDeliveryMode(String internationalDeliveryMode) {
        mInternationalDeliveryMode = internationalDeliveryMode;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public String getListingSource() {
        return mListingSource;
    }

    public void setListingSource(String listingSource) {
        mListingSource = listingSource;
    }

    public String getListingTypeId() {
        return mListingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        mListingTypeId = listingTypeId;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public List<String> getNonMercadoPagoPaymentMethods() {
        return mNonMercadoPagoPaymentMethods;
    }

    public void setNonMercadoPagoPaymentMethods(List<String> nonMercadoPagoPaymentMethods) {
        mNonMercadoPagoPaymentMethods = nonMercadoPagoPaymentMethods;
    }

    public Long getOfficialStoreId() {
        return mOfficialStoreId;
    }

    public void setOfficialStoreId(Long officialStoreId) {
        mOfficialStoreId = officialStoreId;
    }

    public String getOriginalPrice() {
        return mOriginalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        mOriginalPrice = originalPrice;
    }

    public String getParentItemId() {
        return mParentItemId;
    }

    public void setParentItemId(String parentItemId) {
        mParentItemId = parentItemId;
    }

    public String getPermalink() {
        return mPermalink;
    }

    public void setPermalink(String permalink) {
        mPermalink = permalink;
    }

    public List<Picture> getPictures() {
        return mPictures;
    }

    public void setPictures(List<Picture> pictures) {
        mPictures = pictures;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public String getSecureThumbnail() {
        return mSecureThumbnail;
    }

    public void setSecureThumbnail(String secureThumbnail) {
        mSecureThumbnail = secureThumbnail;
    }

    public SellerAddress getSellerAddress() {
        return mSellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        mSellerAddress = sellerAddress;
    }

    public String getSellerContact() {
        return mSellerContact;
    }

    public void setSellerContact(String sellerContact) {
        mSellerContact = sellerContact;
    }

    public Long getSellerId() {
        return mSellerId;
    }

    public void setSellerId(Long sellerId) {
        mSellerId = sellerId;
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

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getStopTime() {
        return mStopTime;
    }

    public void setStopTime(String stopTime) {
        mStopTime = stopTime;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public void setSubtitle(String subtitle) {
        mSubtitle = subtitle;
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

    public String getVideoId() {
        return mVideoId;
    }

    public void setVideoId(String videoId) {
        mVideoId = videoId;
    }

    public String getWarranty() {
        return mWarranty;
    }

    public void setWarranty(String warranty) {
        mWarranty = warranty;
    }

}
