package com.gt.bookshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.gt.bookshop.dao.BaseDao;
import com.gt.bookshop.dao.UserDao;
import com.gt.bookshop.entities.User;

/**
 * Created by GongTao on 2017/2/10/010.
 */

@Repository(value="userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
