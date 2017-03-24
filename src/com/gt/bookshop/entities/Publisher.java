package com.gt.bookshop.entities;

import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/10/010.
 * 出版社实体类
 */

@Entity
@Table(name="tb_publishers")
public class Publisher {

    // 出版社编号
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_publisher")
//	@SequenceGenerator(name="seq_publisher",sequenceName="seq_publisher_id",allocationSize=1,initialValue=1)
    private int id;

    // 出版社名称
	@Column
    private String name;
	
	@OneToMany(mappedBy = "publisher" , cascade = {CascadeType.ALL})
	private Set<Book> books;

    // 属性的getter setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void setBooks(Set<Book> books) {
		this.books = books;
	}
    
    public Set<Book> getBooks() {
		return books;
	}

    public Publisher(){}
}
