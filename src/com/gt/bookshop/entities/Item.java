package com.gt.bookshop.entities;

/**
 * Created by GongTao on 2017/2/12/012.
 * �������࣬���ڹ����¶����߼���
 */
public class Item {
    /**
     * ͼ����
     */
    private int id;

    /**
     * ����
     */
    private String title;

    /**
     * ��Ա��
     */
    private double unitPrice;

    /**
     * �г���
     */
    public double marketPrice;

    /**
     * ��������
     */
    private int qty;

    /**
     * ֻ������totalUnitPrice ������ ��Ա�ܼ�
     */
    private double TotalUnitPrice;

    /**
     * �г��ܼ�
     */
    private double totalMarketPrice;

    /**
     * ���������Ե� getter setter ����
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
        return this.qty * unitPrice;        //��Ա�ܼ��� ������������������Ļ�Ա��
    }

    public void setTotalUnitPrice(double totalUnitPrice) {
        TotalUnitPrice = totalUnitPrice;
    }

    public double getTotalMarketPrice() {
        return this.qty * marketPrice;       //�г��ܼ��� ��������������������г���
    }

    public void setTotalMarketPrice(double totalMarketPrice) {
        this.totalMarketPrice = totalMarketPrice;
    }
}
