package com.gt.bookshop.dao.impl;

import org.springframework.stereotype.Repository;
import com.gt.bookshop.dao.BaseDao;
import com.gt.bookshop.dao.OrderDao;
import com.gt.bookshop.entities.Order;

/**
 * Created by GongTao on 2017/2/10/010.
 */

@Repository(value="orderDao")
public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public int add(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
