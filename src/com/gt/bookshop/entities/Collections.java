package com.gt.bookshop.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 */

@Entity
@Table(name="tb_collections")
public class Collections {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_collections")
//	@SequenceGenerator(name="seq_collections",sequenceName="seq_collections_id",allocationSize=1,initialValue=1)
    private int id;
	@Column
    private Date collectTime;
	@Column
    private int bookId;
	@Column
    private int userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId" , insertable = false , updatable = false)
    private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId" , insertable = false , updatable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
