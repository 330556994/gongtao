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
 * ���ﳵ������
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
        /*1. ����id�õ�ͼ�����
         * 2.����ͼ����󴴽����������
         * 3.���ù��ﳵ������������
         * 4. ���ص�ǰ��ͼ������ʾ��ӳɹ�
         */

        Book book = bookService.getSingle(id);
        //����ͼ����󴴽����������
        Item item = new Item();
        item.setId(book.getId());
        item.setTitle(book.getTitle());
        item.setUnitPrice(book.getUnitPrice());
        item.setMarketPrice(book.getMarketPrice());
        item.setQty(1);
        //��������item��ӵ����ﳵ
        itemService.add(item);
        //����֮ǰ������ͼ������ʾ��ӳɹ�
        //String js = "<script>alert('����ɹ�');history.go(-1);</script>";
        //return Content(js);

        //�����ǽ� item ���� Session ��
        session.setAttribute("car",itemService.getItems());

        response.setCharacterEncoding("utf-8");
        response.getWriter().write("{\"success\":0 }");
        response.getWriter().flush();
    }

    /**
     * ɾ��������
     * @param id  ��������
     */
    @RequestMapping(value = "/delete/{id}",method=RequestMethod.GET)
    public void delete(@PathVariable() int id,HttpServletResponse response) throws IOException {
        int success=0;
        try
        {
            itemService.delete(id);//ɾ��
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
