package com.blackseapps.interview.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 19.10.2021
 * <p>
 * This is an interview project.
 */

public class Product implements Parcelable {

    private String uid;
    private String title;
    private String description;
    private int categoryUid;
    private String categoryName;
    private String brandName;
    private double price;
    private String stockCode;
    private int stockTotal;
    private int stockStatus;

    @Inject
    public Product() {

    }

    public Product(String uid, String title, String description, int categoryUid, String categoryName, String brandName, double price, String stockCode, int stockTotal, int stockStatus) {
        this.uid = uid;
        this.title = title;
        this.description = description;
        this.categoryUid = categoryUid;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.price = price;
        this.stockCode = stockCode;
        this.stockTotal = stockTotal;
        this.stockStatus = stockStatus;

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryUid() {
        return categoryUid;
    }

    public void setCategoryUid(int category) {
        this.categoryUid = category;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public int getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public int isStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    protected Product(Parcel in) {
        uid = in.readString();
        title = in.readString();
        description = in.readString();
        categoryUid = in.readInt();
        categoryName = in.readString();
        brandName = in.readString();
        price = in.readDouble();
        stockCode = in.readString();
        stockTotal = in.readInt();
        stockStatus = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(categoryUid);
        dest.writeString(categoryName);
        dest.writeString(brandName);
        dest.writeDouble(price);
        dest.writeString(stockCode);
        dest.writeInt(stockTotal);
        dest.writeInt(stockStatus);
    }
}
