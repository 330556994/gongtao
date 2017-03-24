package com.gt.bookshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gt.bookshop.dao.BaseDao;
import com.gt.bookshop.dao.CategoryDao;
import com.gt.bookshop.entities.Category;

/**
 * Created by GongTao on 2017/2/10/010.
 */

@Repository(value="categoryDao")
public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
