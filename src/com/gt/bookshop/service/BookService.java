package com.gt.bookshop.service;

import com.gt.bookshop.entities.Book;
import com.gt.bookshop.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongTao on 2017/2/10/010.
 * ���������� ͼ���ҵ����
 */
@Service
public class BookService {

    // �˴��� bookMap ��һ���ӿ� MyBatis
    @Autowired
    private BookDao bookDao;

    /**
     * �õ�ĳ��ͼ������£�ͼ������
     * @param categoryid �����
     * @return     ͼ������
     */
    public int getRecordCount(int categoryid) {
        return bookDao.getRecordCount(categoryid);
    }

    /**
     * ��ҳ��ʾ�������а񣬸��ݳ������ڵ���ֻ����id,title��
     * @param top  Ҫȡ���ٱ���
     * @return   ͼ�鼯�ϣ�ֻ��id��title������
     */
    public List<Book> getNewBooks(int top) {

        return bookDao.getNewBooks(top);
    }

    //

    /**
     * ��ҳ��ʾ�������а񣬸���clicks����ȡ���ݣ�ֻ����id.title
     * @param top  ȡ���ٱ���
     * @return     ͼ�鼯��
     */
    public List<Book> getHotBooks(int top)
    {
        return bookDao.getHotBooks(11);
    }

    /**
     * �õ���ҳ���ͼ�����ݣ���ҳ����
     * @param top  ȡ������
     * @return     ͼ�鼯��
     */
    public List<Book> getHomeBooks(int top)
    {
        return bookDao.getHomeBooks(top);
    }

    /**
     * ��ȡȫ��ͼ����Ϣ
     * @return  ͼ�鼯��
     */
    public List<Book> getList() {
        return bookDao.getList();
    }

    /**
     * ����ͼ������ţ���ø������ͼ����Ϣ
     * @param categoryid  ͼ�������
     * @return  ͼ�鼯��
     */
    public List<Book> getListByCategoryId(int categoryid) {
          return bookDao.getListByCategoryId(categoryid);
    }

    /**
     * ����ҳ�������ܵĲ�ѯͼ�飬����ͼ���б�ҳ��
     * sql�Ѿ������˸ù��ܵĴ洢����
     * @param start  �ӵڼ���
     * @param end    ���ڼ���
     * @param sort   ���������� a.id desc
     * @param categoryid   ͼ�������
     * @return       ����ͼ�鷺�ͼ���
     */
    public List<Book> getList(int start, int end, String sort, int categoryid) {
        return null;
    }

    /**
     * ����ͼ���ţ���õ���ͼ�����
     * @param id  �����
     * @return   ͼ�����
     */
    public Book getSingle(int id) {
        return bookDao.getSingle(id);
    }

    /**
     * �õ�һ���������
     * һ��������� >2.0  <2.5  2�ǣ� >2.5- <3 2�ǰ�
     * @param bookid  ͼ����
     * @return  ͼ������
     */
    private double getBookRating(int bookid) {
        return 0;
    }

}
