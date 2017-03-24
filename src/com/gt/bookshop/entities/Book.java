package com.gt.bookshop.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/10/010.
 * ͼ��ʵ����
 */

@Entity
@Table(name="tb_books")
public class Book {

    //ͼ����
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_book")
//	@SequenceGenerator(name="seq_book",sequenceName="seq_emp_id",allocationSize=1,initialValue=1)
    private int id;

    //ͼ�����
	@Column
    private String title;

    //ISBN   1 a-f 2[0-5] 12������ ���һ������ĸ
	@Column
    private String ISBN;

    //����
	@Column
    private String author;

    // ��������
	@Column
    private int publisherId;

    // ��������
	@Column
    private Date publishDate;

    // �г���
	@Column
    private double marketPrice;

    // vip�۶�
	@Column
    private double unitPrice;

    // ��������
	@Column
    private String contentDescription;

    ///�½�����
	@Column
    private String TOC;

    ///  //ͼ�������
	@Column
    private int categoryId;

    /// //�����
	@Column
    private int clicks;

    // �������ͼ����һ�Զ��ϵ
	// ����ʹ�� @ManyToOne ������ Book �� Publisher ��֮��Ķ��һ������ʹ�� @JoinColumn(name="publisherId")
	// ָ����άϵ��ϵ������� tb_Books ���е� publisherId. Hibernate ��������������SQL���
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisherId" , insertable = false , updatable = false)
    private Publisher publisher;
	
	//����ͼ����һ�Զ��ϵ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId" , insertable = false , updatable = false)
    private Category category;
	
	@OneToMany(mappedBy = "book",cascade = {CascadeType.ALL})
	private Set<ReaderComments> readerComments;
	
	@OneToMany(mappedBy = "book",cascade = {CascadeType.ALL})
	private Set<OrderBook> orderBooks;

    // �����������չ�ģ����ݿ��ﲻ���ڣ���ʾͼ������
	@Transient
    private double bookRating;

    // ���Ե�getter setter ����
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getTOC() {
        return TOC;
    }

    public void setTOC(String TOC) {
        this.TOC = TOC;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public double getBookRating() {
        return bookRating;
    }

    public void setBookRating(double bookRating) {
        this.bookRating = bookRating;
    }
    
    public void setOrderBooks(Set<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}
    
    public Set<OrderBook> getOrderBooks() {
		return orderBooks;
	}
    
    public void setReaderComments(Set<ReaderComments> readerComments) {
		this.readerComments = readerComments;
	}
    
    public Set<ReaderComments> getReaderComments() {
		return readerComments;
	}

}
