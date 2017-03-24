package com.gt.bookshop.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 */

@Entity
@Table(name="tb_readercomments")
public class ReaderComments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_readercomments")
//	@SequenceGenerator(name="seq_readercomments",sequenceName="seq_readercomments_id",allocationSize=1,initialValue=1)
    private int id;
	@Column
    private int bookId;
	@Column
    private String title;
	@Column
    private String comment;
	@Column
    private java.util.Date Date;
	@Column
    private int userId;
	@Column
    private int flag;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bookId" , insertable = false , updatable = false)
    private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId" , insertable = false , updatable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public void setBook(Book book) {
		this.book = book;
	}
    
    public Book getBook() {
		return book;
	}
    
    public void setUser(User user) {
		this.user = user;
	}
    
    public User getUser() {
		return user;
	}

}
