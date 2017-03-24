package com.gt.bookshop.dao;


import com.gt.bookshop.entities.Book;

import java.util.List;

/**
 * ͼ��ӿ���
 * Created by GongTao on 2017/2/10/010.
 */
public interface BookDao {
    /**
     * �õ�ĳ��ͼ������£�ͼ������
     * @param categoryid �����
     * @return     ͼ������
     */
    int getRecordCount(int categoryid);

    /**
     * ��ҳ��ʾ�������а񣬸��ݳ������ڵ���ֻ����id,title��
     * @param top  Ҫȡ���ٱ���
     * @return   ͼ�鼯�ϣ�ֻ��id��title������
     */
    List<Book> getNewBooks(int top);

    /**
     * ��ҳ��ʾ�������а񣬸���clicks����ȡ���ݣ�ֻ����id.title
     * @param top  ȡ���ٱ���
     * @return     ͼ�鼯��
     */
    List<Book> getHotBooks(int top);

    /**
     * �õ���ҳ���ͼ�����ݣ���ҳ����
     * @param top  ȡ������
     * @return     ͼ�鼯��
     */
    List<Book> getHomeBooks(int top);

    /**
     * ��ȡȫ��ͼ����Ϣ
     * @return  ͼ�鼯��
     */
    List<Book> getList();

    /**
     * ����ͼ������ţ���ø������ͼ����Ϣ
     * @param categoryid  ͼ�������
     * @return  ͼ�鼯��
     */
    List<Book> getListByCategoryId(int categoryid);

    /**
     * ����ҳ�������ܵĲ�ѯͼ�飬����ͼ���б�ҳ��
     * sql�Ѿ������˸ù��ܵĴ洢����
     * @param start  �ӵڼ���
     * @param end    ���ڼ���
     * @param sort   ���������� a.id desc
     * @param categoryid   ͼ�������
     * @return       ����ͼ�鷺�ͼ���
     */
    public List<Book> getList(int start, int end, String sort, int categoryid);

    /**
     * ����ͼ���ţ���õ���ͼ�����
     * @param id  �����
     * @return   ͼ�����
     */
    public Book getSingle(int id);
    /**
     * �õ�һ���������
     * һ��������� >2.0  <2.5  2�ǣ� >2.5- <3 2�ǰ�
     * @param bookid  ͼ����
     * @return  ͼ������
     */
    public double getBookRating(int bookid);

}
