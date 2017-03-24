package com.gt.bookshop.service;

import com.gt.bookshop.entities.Order;
import com.gt.bookshop.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GongTao on 2017/2/12/012.
 * ���������� ������ҵ����
 */

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;


    /**
     * ���һ��������������Ҫ����������������
     * @param order  ����ӵĶ���
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
