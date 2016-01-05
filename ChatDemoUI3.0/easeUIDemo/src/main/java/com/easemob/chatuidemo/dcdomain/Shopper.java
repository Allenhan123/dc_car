package com.easemob.chatuidemo.dcdomain;

/**
 * Created by Administrator on 2015/12/29.
 */
public class Shopper {
    private String shopName;
    private String shopType;
    private String telPhone;
    private String shopQQ;

    public Shopper() {
    }

    public Shopper(String shopName, String shopType, String telPhone, String shopQQ) {
        this.shopName = shopName;
        this.shopType = shopType;
        this.telPhone = telPhone;
        this.shopQQ = shopQQ;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getShopQQ() {
        return shopQQ;
    }

    public void setShopQQ(String shopQQ) {
        this.shopQQ = shopQQ;
    }

    @Override
    public String toString() {
        return "Shopper{" +
                "shopName='" + shopName + '\'' +
                ", shopType='" + shopType + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", shopQQ='" + shopQQ + '\'' +
                '}';
    }
}
