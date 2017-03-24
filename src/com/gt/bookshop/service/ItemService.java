package com.gt.bookshop.service;

import com.gt.bookshop.entities.Item;
import com.sun.net.httpserver.HttpContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GongTao on 2017/2/12/012.
 * 功能描述： 购物车的业务类
 */
@Service
public class ItemService {

    /**
     * 只读属性，从session中 car 获得购物车集合 Items
     */
    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * 在购物车里 查询编号为id的购物项
     * @param id  编号为id的购物项
     * @return  存在，返回索引，不存在返回-1
     */
    private int search(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加购物项到购物车里
     * 如果购物车中没有购物项则添加，如果存在，则购买数量累加
     * @param item  购物项
     */
    public void add(Item item) {
        int ret = search(item.getId());//先查
        if (ret == -1)
        {
            items.add(item);
        }
        else {
            items.get(ret).setQty(items.get(ret).getQty()+1);
        }
    }

    /**
     * 在购物车里修改编号为id的购物项，只修改数量qty
     * @param id  待修改的购物项编号
     * @param qty 要修改的购买数量
     */
    public void update(int id, int qty) {
        int ret = search(id);//先查
        if (ret != -1) {
            //如果存在，则修改对应的数量
            items.get(ret).setQty(qty);
        }
    }

    /**
     * 在购物车里删除编号为id的购物项
     * @param id  要删除的编号
     */
    public void delete(int id) {
        int ret = search(id);//先查
        if (ret != -1)
        {
            //如果存在，则删除指定索引位置的对象
            items.remove(ret);
        }
    }

    /**
     * 清除购物车
     */
    public void removeAll() {
        items.clear();//清除集合内容

    }

    /**
     * 这个方法是将当前购物车的数据保存在cookie里
     * cookie应当使用多值
     * key存放id，value存放数量
     */
    public void saveCarToCookie() {

    }

    /**
     * 从cookie里取出购物车信息，并重建session
     * 本方法应该在什么时候调用？session_start里调用
     */
    public void loadCarFromCookie() {

    }
}
