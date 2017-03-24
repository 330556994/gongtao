package com.gt.bookshop.service;

import com.gt.bookshop.entities.Book;
import com.gt.bookshop.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongTao on 2017/2/10/010.
 * 功能描述： 图书的业务类
 */
@Service
public class BookService {

    // 此处的 bookMap 是一个接口 MyBatis
    @Autowired
    private BookDao bookDao;

    /**
     * 得到某个图书类别下，图书总数
     * @param categoryid 类别编号
     * @return     图书总数
     */
    public int getRecordCount(int categoryid) {
        return bookDao.getRecordCount(categoryid);
    }

    /**
     * 首页显示新书排行榜，根据出版日期倒序，只返回id,title列
     * @param top  要取多少本书
     * @return   图书集合，只有id，title有内容
     */
    public List<Book> getNewBooks(int top) {

        return bookDao.getNewBooks(top);
    }

    //

    /**
     * 首页显示热门排行榜，根据clicks倒序取数据，只返回id.title
     * @param top  取多少本书
     * @return     图书集合
     */
    public List<Book> getHotBooks(int top)
    {
        return bookDao.getHotBooks(11);
    }

    /**
     * 得到首页里的图书内容，首页调用
     * @param top  取多少条
     * @return     图书集合
     */
    public List<Book> getHomeBooks(int top)
    {
        return bookDao.getHomeBooks(top);
    }

    /**
     * 获取全部图书信息
     * @return  图书集合
     */
    public List<Book> getList() {
        return bookDao.getList();
    }

    /**
     * 根据图书类别编号，获得该类别下图书信息
     * @param categoryid  图书类别编号
     * @return  图书集合
     */
    public List<Book> getListByCategoryId(int categoryid) {
          return bookDao.getListByCategoryId(categoryid);
    }

    /**
     * 带分页和排序功能的查询图书，用在图书列表页中
     * sql已经创建了该功能的存储过程
     * @param start  从第几条
     * @param end    到第几条
     * @param sort   排序条件如 a.id desc
     * @param categoryid   图书类别编号
     * @return       返回图书泛型集合
     */
    public List<Book> getList(int start, int end, String sort, int categoryid) {
        return null;
    }

    /**
     * 根据图书编号，获得单个图书对象
     * @param id  类别编号
     * @return   图书对象
     */
    public Book getSingle(int id) {
        return bookDao.getSingle(id);
    }

    /**
     * 得到一本书的评分
     * 一本书的评分 >2.0  <2.5  2星， >2.5- <3 2星半
     * @param bookid  图书编号
     * @return  图书评分
     */
    private double getBookRating(int bookid) {
        return 0;
    }

}
