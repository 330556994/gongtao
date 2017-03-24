package com.gt.bookshop.entities;

import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/10/010.
 * 图书类别实体类
 */

@Entity
@Table(name="tb_categories")
public class Category {

    // 类别编号
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_category")
//	@SequenceGenerator(name="seq_category",sequenceName="seq_category_id",allocationSize=1,initialValue=1)
    private int id;

    // 类别名称
	@Column
    private String name;

    // 排序字段，显示列表时，默认的排序方式
	@Column
    private int sortNum;

    // 该类别下图书总数，这个属性是为了在前台列表页中用
	@Transient
    private int bookCount;
	
	@OneToMany(mappedBy = "category" , cascade = {CascadeType.ALL})
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

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public Category(int id, String name, int sortNum, int bookCount) {
        this.id = id;
        this.name = name;
        this.sortNum = sortNum;
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sortNum=" + sortNum +
                ", bookCount=" + bookCount +
                '}';
    }

    public Category(){}
}
