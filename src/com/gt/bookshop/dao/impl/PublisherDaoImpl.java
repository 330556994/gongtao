package com.gt.bookshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gt.bookshop.dao.BaseDao;
import com.gt.bookshop.dao.PublisherDao;
import com.gt.bookshop.entities.Publisher;

/**
 * Created by GongTao on 2017/2/10/010.
 */

@Repository(value="publisherDao")
public class PublisherDaoImpl extends BaseDao implements PublisherDao {

	@Override
	public List<Publisher> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publisher> getList(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecordCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Publisher getSingle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gelete(int id) {
		// TODO Auto-generated method stub

	}

}
