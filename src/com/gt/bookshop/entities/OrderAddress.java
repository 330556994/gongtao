package com.gt.bookshop.entities;

/**
 * Created by GongTao on 2017/2/12/012.
 * 订单地址类，描述一个订单的收货地址信息
 */
public class OrderAddress {
    /**
     * 手机号码
     */
    private String phone;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 收件人
     */
    private String name;

    /**
     * 下面是 getter setter 方法
     */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
