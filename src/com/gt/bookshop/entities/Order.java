package com.gt.bookshop.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 * ����ʵ����
 */

@Entity
@Table(name="tb_orders")
public class Order {
    /**
     * �������
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_order")
//	@SequenceGenerator(name="seq_order",sequenceName="seq_order_id",allocationSize=1,initialValue=1)
    private int id;

    /**
     * ��������
     */
	@Column
    private Date orderDate;

    /**
     * ������Ա���
     */
	@Column
    private int userId;

    /**
     * ������Ʒ�ܼ�
     */
	@Column
    private double totalPrice;

    /**
     * ����״̬ 1:δ����  ֻ�����״̬��Ա����ȡ����Ҳ���Ժϲ�����
     * 2.������
     * 3.�ѷ���
     * 4.��Ա��ȡ��
     * 5.����Աȡ��
     * 6.�����
     * 7.�����Ѻϲ�
     * 8.��������
     */
	@Column
    private int flag;

    /**
     * �ռ�������
     */
	@Column
    private String personName;

    /**
     * �ռ��˵绰����
     */
	@Column
    private String phone;

    /**
     * �ͼ���ַ
     */
	@Column
    private String address;

    /**
     * ��ݷ���
     */
	@Column
    private int sendCash;

    /**
     * ��Աȡ�����ɣ�����Աȡ������ʱ����������ȡ������
     */
	@Column
    private String userCancelReason;

    /**
     * ������ע����Ա��д
     */
	@Column
    private String orderRemark;

    /**
     * ��Ϊҵ��ģ���У�ͨ����ͨ����������ϸ
     * ���ԣ������һ�Զ����ƣ����õ��������ｨ��ϸ�ļ���
     * �ö�������ϸ����
     * 
	 * ����ʹ�� @OneToMany ע�������� Order �� OrderBook��֮���һ�Զ��ϵ��ͨ�� cascade={CascadeType.ALL} �����˼���
	 * ͨ�� MappedBy="order" ����άϵ��ϵ�Ŀ���Ȩ������ OrderBooks����һ�����൱�� Order.hbm.xml �����õ� inverse="true"
	 * mappedBy ������ֵ order �� OrderBook ���е�������
	 * 
	 * cascade ����ָ����������
	 * 	CascadeType.REMOVE:	����ɾ��
	 * 	CascadeType.PERSIST:persist()��������
	 * 	CascadeType.MERGE:	��������
	 * 	CascadeType.REFRESH:����ˢ��
	 * 	CascadeType.ALL:	�������м�������
	 */
	@OneToMany(mappedBy = "order" , cascade = {CascadeType.ALL})
    private Set<OrderBook> orderBooks;

    /**
     * �����Ǹ������Ե� getter setter ����
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
