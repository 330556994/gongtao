package com.gt.bookshop.controller;

import com.gt.bookshop.entities.Book;
import com.gt.bookshop.entities.Item;
import com.gt.bookshop.service.BookService;
import com.gt.bookshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 购物车控制器
 * Created by GongTao on 2017/2/12/012.
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BookService bookService;

    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("items", itemService.getItems());
        return "car/index";
    }

    @RequestMapping(value = "/buy/{id}",method=RequestMethod.GET)
    public void buy(@PathVariable() Integer id,HttpServletResponse response,HttpSession session) throws IOException {
        /*1. 根据id得到图书对象
         * 2.根据图书对象创建购物项对象
         * 3.调用购物车操作类完成添加
         * 4. 返回当前视图，并提示添加成功
         */

        Book book = bookService.getSingle(id);
        //根据图书对象创建购物项对象
        Item item = new Item();
        item.setId(book.getId());
        item.setTitle(book.getTitle());
        item.setUnitPrice(book.getUnitPrice());
        item.setMarketPrice(book.getMarketPrice());
        item.setQty(1);
        //将购物项item添加到购物车
        itemService.add(item);
        //返回之前访问视图，并提示添加成功
        //String js = "<script>alert('购买成功');history.go(-1);</script>";
        //return Content(js);

        //下面是将 item 加入 Session 中
        session.setAttribute("car",itemService.getItems());

        response.setCharacterEncoding("utf-8");
        response.getWriter().write("{\"success\":0 }");
        response.getWriter().flush();
    }

    /**
     * 删除购物项
     * @param id  购物项编号
     */
    @RequestMapping(value = "/delete/{id}",method=RequestMethod.GET)
    public void delete(@PathVariable() int id,HttpServletResponse response) throws IOException {
        int success=0;
        try
        {
            itemService.delete(id);//删除
        }
        catch (Exception ex) {
            success=-1;
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("{\"success\":"+success+" }");
        response.getWriter().flush();
    }

    @RequestMapping(value = "/update/{id}/{qty}",method=RequestMethod.GET)
    public void update(@PathVariable(value = "id") int id,@PathVariable(value = "qty") int qty,HttpServletResponse response) throws IOException {
        int success=0;
        try
        {
            itemService.update(id, qty);
        }
        catch (Exception ex) {
            success=-1;
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("{\"success\":"+success+" }");
        response.getWriter().flush();
    }
}
