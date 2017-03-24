package com.gt.bookshop.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 * 订单实体类
 */

@Entity
@Table(name="tb_orders")
public class Order {
    /**
     * 订单编号
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_order")
//	@SequenceGenerator(name="seq_order",sequenceName="seq_order_id",allocationSize=1,initialValue=1)
    private int id;

    /**
     * 订购日期
     */
	@Column
    private Date orderDate;

    /**
     * 所属会员编号
     */
	@Column
    private int userId;

    /**
     * 订购商品总价
     */
	@Column
    private double totalPrice;

    /**
     * 订单状态 1:未处理  只有这个状态会员可以取消，也可以合并订单
     * 2.处理中
     * 3.已发货
     * 4.会员已取消
     * 5.管理员取消
     * 6.已完成
     * 7.订单已合并
     * 8.订单已退
     */
	@Column
    private int flag;

    /**
     * 收件人姓名
     */
	@Column
    private String personName;

    /**
     * 收件人电话号码
     */
	@Column
    private String phone;

    /**
     * 送件地址
     */
	@Column
    private String address;

    /**
     * 快递费用
     */
	@Column
    private int sendCash;

    /**
     * 会员取消理由，当会员取消订单时，必须输入取消理由
     */
	@Column
    private String userCancelReason;

    /**
     * 订单备注，会员填写
     */
	@Column
    private String orderRemark;

    /**
     * 因为业务模型中，通常是通过订单看明细
     * 所以，这里的一对多的设计，采用的是主表里建明细的集合
     * 该订单的明细集合
     * 
	 * 这里使用 @OneToMany 注解设置了 Order 和 OrderBook类之间的一对多关系，通过 cascade={CascadeType.ALL} 设置了级联
	 * 通过 MappedBy="order" 设置维系关系的控制权交给了 OrderBooks类这一方，相当于 Order.hbm.xml 中配置的 inverse="true"
	 * mappedBy 的属性值 order 是 OrderBook 类中的属性名
	 * 
	 * cascade 属性指定级联操作
	 * 	CascadeType.REMOVE:	级联删除
	 * 	CascadeType.PERSIST:persist()方法级联
	 * 	CascadeType.MERGE:	级联更新
	 * 	CascadeType.REFRESH:级联刷新
	 * 	CascadeType.ALL:	包含所有级联操作
	 */
	@OneToMany(mappedBy = "order" , cascade = {CascadeType.ALL})
    private Set<OrderBook> orderBooks;

    /**
     * 下面是各个属性的 getter setter 方法
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

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

    public int getSendCash() {
        return sendCash;
    }

    public void setSendCash(int sendCash) {
        this.sendCash = sendCash;
    }

    public String getUserCancelReason() {
        return userCancelReason;
    }

    public void setUserCancelReason(String userCancelReason) {
        this.userCancelReason = userCancelReason;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
    
    public void setOrderBooks(Set<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}
    
    public Set<OrderBook> getOrderBooks() {
		return orderBooks;
	}

}
