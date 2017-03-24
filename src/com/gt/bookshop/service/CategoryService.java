package com.gt.bookshop.service;

import com.gt.bookshop.entities.Category;
import com.gt.bookshop.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongTao on 2017/2/11/011.
 * 功能描述： 图书类别的业务类
 */
@Service
public class CategoryService {

    // 此处的 bookMap 是一个接口 MyBatis
    @Autowired
    private CategoryDao categoryDao;

    /**
     * 获取所有分类信息
     * @return  所有分类集合
     */
    public List<Category> getList() {
        return categoryDao.getList();
    }

    /**
     * 返回图书类别集合带类别下图书总数，本方法在books/index中会调用
     * @return
     */
    public List<Category> getListWithBooCount() {
        return null;
    }

    /**
     * 根据类别编号获得单个类别对象
     * @param id 类别编号
     * @return  存在id则返回对象，不存在返回null
     */
    public Category getSingle(int id) {
        return null;
    }

}
