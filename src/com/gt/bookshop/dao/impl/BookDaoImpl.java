package com.gt.bookshop.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gt.bookshop.dao.BaseDao;
import com.gt.bookshop.dao.BookDao;
import com.gt.bookshop.entities.Book;

/**
 * 图书dao类的实现类
 * Created by GongTao on 2017/2/10/010.
 */

@Repository(value="bookDao")
public class BookDaoImpl extends BaseDao implements BookDao{

	@Override
	public int getRecordCount(int categoryid) {
		return (Integer) getSession().createQuery("select Count(*) from Book").uniqueResult();
	}

	@Override
	public List<Book> getNewBooks(int top) {
		List<Book> list=getSession().createSQLQuery("select * from tb_Books order by publishDate desc limit :top")
									.addEntity(Book.class)					
									.setInteger("top", top).list();
		return list;
	}

	@Override
	public List<Book> getHotBooks(int top) {
		return getSession().createSQLQuery("select * from tb_Books order by clicks desc limit :top").addEntity(Book.class).setInteger("top", top).list();
	}

	@Override
	public List<Book> getHomeBooks(int top) {
		return getSession().createSQLQuery("select * from tb_Books limit :top").addEntity(Book.class).setInteger("top", top).list();
	}

	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getListByCategoryId(int categoryid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getList(int start, int end, String sort, int categoryid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getSingle(int id) {
		return (Book) getSession().get(Book.class, id);
	}

	@Override
	public double getBookRating(int bookid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
