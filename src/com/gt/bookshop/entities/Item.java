package com.gt.bookshop.entities;

/**
 * Created by GongTao on 2017/2/12/012.
 * 购物项类，用在购物下订单逻辑里
 */
public class Item {
    /**
     * 图书编号
     */
    private int id;

    /**
     * 书名
     */
    private String title;

    /**
     * 会员价
     */
    private double unitPrice;

    /**
     * 市场价
     */
    public double marketPrice;

    /**
     * 购买数量
     */
    private int qty;

    /**
     * 只读属性totalUnitPrice 代表是 会员总价
     */
    private double TotalUnitPrice;

    /**
     * 市场总价
     */
    private double totalMarketPrice;

    /**
     * 下面是属性的 getter setter 方法
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalUnitPrice() {
        return this.qty * unitPrice;        //会员总价有 所购卖的数量乘以书的会员价
    }

    public void setTotalUnitPrice(double totalUnitPrice) {
        TotalUnitPrice = totalUnitPrice;
    }

    public double getTotalMarketPrice() {
        return this.qty * marketPrice;       //市场总价有 所购卖的数量乘以书的市场价
    }

    public void setTotalMarketPrice(double totalMarketPrice) {
        this.totalMarketPrice = totalMarketPrice;
    }
}
