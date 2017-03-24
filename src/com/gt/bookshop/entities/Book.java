package com.gt.bookshop.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/10/010.
 * 图书实体类
 */

@Entity
@Table(name="tb_books")
public class Book {

    //图书编号
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_book")
//	@SequenceGenerator(name="seq_book",sequenceName="seq_emp_id",allocationSize=1,initialValue=1)
    private int id;

    //图书标题
	@Column
    private String title;

    //ISBN   1 a-f 2[0-5] 12个数字 最后一个是字母
	@Column
    private String ISBN;

    //作者
	@Column
    private String author;

    // 出版社编号
	@Column
    private int publisherId;

    // 出版日期
	@Column
    private Date publishDate;

    // 市场价
	@Column
    private double marketPrice;

    // vip价额
	@Column
    private double unitPrice;

    // 内容描述
	@Column
    private String contentDescription;

    ///章节描述
	@Column
    private String TOC;

    ///  //图书类别编号
	@Column
    private int categoryId;

    /// //点击率
	@Column
    private int clicks;

    // 出版社和图书室一对多关系
	// 这里使用 @ManyToOne 配置了 Book 和 Publisher 类之间的多对一关联，使用 @JoinColumn(name="publisherId")
	// 指定了维系关系的外键是 tb_Books 表中的 publisherId. Hibernate 将生成左外连的SQL语句
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisherId" , insertable = false , updatable = false)
    private Publisher publisher;
	
	//类别和图书是一对多关系
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId" , insertable = false , updatable = false)
    private Category category;
	
	@OneToMany(mappedBy = "book",cascade = {CascadeType.ALL})
	private Set<ReaderComments> readerComments;
	
	@OneToMany(mappedBy = "book",cascade = {CascadeType.ALL})
	private Set<OrderBook> orderBooks;

    // 这个属性是扩展的，数据库里不存在，表示图书评分
	@Transient
    private double bookRating;

    // 属性的getter setter 方法
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
