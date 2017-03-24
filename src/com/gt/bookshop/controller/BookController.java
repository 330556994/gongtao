package com.gt.bookshop.controller;

import com.gt.bookshop.service.BookService;
import com.gt.bookshop.service.CategoryService;
import com.gt.bookshop.service.ItemService;
import com.gt.bookshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 图书控制器
 * Created by GongTao on 2017/2/10/010.
 */

@Controller
@RequestMapping("/books")
public class BookController {

    public BookController(){System.out.print("我的名字叫 BookController 不知不觉被Spring实例化了");}

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/detail/{id}",method=RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id, Map<String, Object> map){
        map.put("categories",categoryService.getList());
        map.put("publishers",publisherService.getList());
        map.put("items", itemService.getItems());
        map.put("book",bookService.getSingle(id));
        return "book/detail";
    }

    @RequestMapping(value = "/index/{id}",method=RequestMethod.GET)
    public String index(@PathVariable("id") Integer id, Map<String, Object> map){
        map.put("categories",categoryService.getList());
        map.put("books",bookService.getListByCategoryId(id));
        map.put("items",itemService.getItems());
        map.put("id",id);
        return "book/index";
    }

    @RequestMapping("/helloword")
    public String testMvc(){
        return "input";
    }


}
