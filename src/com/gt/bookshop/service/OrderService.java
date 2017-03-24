package com.gt.bookshop.service;

import com.gt.bookshop.entities.Order;
import com.gt.bookshop.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GongTao on 2017/2/12/012.
 * 功能描述： 订单的业务类
 */

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;


    /**
     * 添加一个订单，这里需要启用事务来完成添加
     * @param order  待添加的订单
     * @return
     */
    public int add(Order order) {
    	orderDao.add(order);
        return this.getId();
    }

    public int getId(){
        return orderDao.getId();
    }
}
