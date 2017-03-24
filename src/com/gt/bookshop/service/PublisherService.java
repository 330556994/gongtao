package com.gt.bookshop.service;

import com.gt.bookshop.entities.Publisher;
import com.gt.bookshop.dao.PublisherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongTao on 2017/2/11/011.
 * 功能描述： 出版社的业务类
 */
@Service
public class PublisherService {

    @Autowired
    private PublisherDao publisherDao;

    /**
     * 得到出版社所有信息
     * @return 出版社集合
     */
    public List<Publisher> getList() {
        return publisherDao.getList();
    }

    /**
     * 分页版本
     * @param start
     * @param end
     * @return
     */
    public List<Publisher> getList(int start, int end) {
        return null;
    }

    /**
     * 得到出版社总记录数
     * @return
     */
    public int getRecordCount() {
        return 0;
    }

    /**
     * 根据出版社编号获得出版社对象
     * @param id 出版社编号
     * @return 出版社对象，如果不存在，则null
     */
    public Publisher getSingle(int id) {
        return null;
    }

    /**
     * 根据出版社编号删除出版社
     * @param id 出版社编号
     */
    public void delete(int id) {

    }
}
