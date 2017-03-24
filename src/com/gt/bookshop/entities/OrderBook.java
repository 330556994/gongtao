package com.gt.bookshop.entities;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 * ������ϸ��
 */

@Entity
@Table(name="tb_orderbook")
public class OrderBook {

    /**
     * ��ϸ���
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_orderbook")
//	@SequenceGenerator(name="seq_orderbook",sequenceName="seq_orderbook_id",allocationSize=1,initialValue=1)
    private int id;

    /**
     * �����������
     */
	@Column
    private int orderID;

    /**
     * ����ͼ����
     */
	@Column
    private int bookID;

    /**
     * ��������
     */
	@Column
    private int quantity;

    /**
     * ͼ�鵥��
     */
	@Column
    private double unitPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderID" , insertable = false , updatable = false)
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookID" , insertable = false , updatable = false)
	private Book book;

    /**
     * ������ getter setter ����
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public void setOrder(Order order) {
		this.order = order;
	}
    
    public Order getOrder() {
		return order;
	}
    
    public void setBook(Book book) {
		this.book = book;
	}
    
    public Book getBook() {
		return book;
	}
}
