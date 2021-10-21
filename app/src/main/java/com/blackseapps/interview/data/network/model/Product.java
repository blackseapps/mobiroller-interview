package com.blackseapps.interview.data.network.model;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 19.10.2021
 * <p>
 * This is an interview project.
 */

public class Product {

    private String uid;
    private String title;
    private String description;
    private int categoryUid;
    private String categoryName;
    private String brandName;
    private String price;
    private String stockCode;
    private int stockTotal;
    private int stockStatus;

    @Inject
    public Product() {

    }

    public Product(String uid, String title, String description, int categoryUid, String categoryName,  String brandName, String price, String stockCode, int stockTotal, int stockStatus) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
}
