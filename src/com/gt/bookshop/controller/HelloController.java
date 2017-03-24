package com.gt.bookshop.controller;

import com.gt.bookshop.service.BookService;
import com.gt.bookshop.service.CategoryService;
import com.gt.bookshop.service.ItemService;
import com.gt.bookshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Ê×Ò³¿ØÖÆÆ÷
 * Created by GongTao on 2017/2/10/010.
 */

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private BookService bookService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model,HttpSession session) {
		model.addAttribute("newBooks",bookService.getNewBooks(11));
		model.addAttribute("hotBooks",bookService.getHotBooks(11));
		model.addAttribute("homeBooks",bookService.getHomeBooks(13));
		model.addAttribute("categories",categoryService.getList());
		model.addAttribute("publishers",publisherService.getList());
		model.addAttribute("items",itemService.getItems());
//		session.setAttribute("name","¹¨ÌÎ");
		return "index";
	}
}