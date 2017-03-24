package com.gt.bookshop.dao;

import com.gt.bookshop.entities.Publisher;

import java.util.List;

/**
 * 功能描述： 出版社的dao类
 * Created by GongTao on 2017/2/11/011.
 */
public interface PublisherDao {

    /**
     * 得到出版社所有信息
     * @return 出版社集合
     */
    public List<Publisher> getList();

    /**
     * 分页版本
     * @param start
     * @param end
     * @return
     */
    public List<Publisher> getList(int start, int end);

    /**
     * 得到出版社总记录数
     * @return
     */
    public int getRecordCount();

    /**
     * 根据出版社编号获得出版社对象
     * @param id 出版社编号
     * @return 出版社对象，如果不存在，则null
     */
    public Publisher getSingle(int id);

    /**
     * 根据出版社编号删除出版社
     * @param id 出版社编号
     */
    public void gelete(int id);
}
