package com.gt.bookshop.entities;

/**
 * Created by GongTao on 2017/2/12/012.
 * ������ַ�࣬����һ���������ջ���ַ��Ϣ
 */
public class OrderAddress {
    /**
     * �ֻ�����
     */
    private String phone;

    /**
     * �ͻ���ַ
     */
    private String address;

    /**
     * �ռ���
     */
    private String name;

    /**
     * ������ getter setter ����
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
