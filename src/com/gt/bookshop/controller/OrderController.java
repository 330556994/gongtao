package com.gt.bookshop.controller;

import com.gt.bookshop.entities.Item;
import com.gt.bookshop.entities.Order;
import com.gt.bookshop.entities.OrderBook;
import com.gt.bookshop.service.ItemService;
import com.gt.bookshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * ���������� 
 * Created by GongTao on 2017/2/17/017.
 */

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private OrderService orderService;

	// ִ����Ӷ�������
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Order order) {

		// ��ʼ���충����
		Order order1 = new Order();
		order1.setPhone(order.getPhone());
		order1.setAddress(order.getAddress());
		order1.setOrderRemark(order.getOrderRemark());
		order1.setPersonName(order.getPersonName());
		order1.setOrderDate(new Date());
		order1.setFlag(1);
		order1.setSendCash(order.getSendCash());
		order1.setTotalPrice(order.getTotalPrice());
		order1.setUserId(4);

		// ��ʼ���충����ϸ��������ϸ�ڹ��ﳵ��
		order1.setOrderBooks((new HashSet<OrderBook>()));
		for (Item item : itemService.getItems()) {
			OrderBook orderBook = new OrderBook();
			orderBook.setBookID(item.getId());
			orderBook.setQuantity(item.getQty());
			orderBook.setUnitPrice(item.getUnitPrice());
			order1.getOrderBooks().add(orderBook);
		}

		try {
			order1.setId(orderService.add(order1));
			// ��������Ϊsuccess����ͼ������order������Ϊǿ���ʹ���
			// �ɹ��¶����󣬹��ﳵ���
			itemService.removeAll();
			// �����ô�Ź��ﳵ��cookie����ʱ��Ϊ����
			// Request.Cookies["_BookShop_Car"].Expires = System.DateTime.Now;
			// return View("success",order);
			return "success";
		} catch (Exception ex) {
			// String js = "<script>alert('�ö������ʧ��!');history.go(-1);</script>";
			// return Content(js);
		}

		return "success";
	}

}
