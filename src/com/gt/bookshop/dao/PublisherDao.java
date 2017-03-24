package com.gt.bookshop.dao;

import com.gt.bookshop.entities.Publisher;

import java.util.List;

/**
 * ���������� �������dao��
 * Created by GongTao on 2017/2/11/011.
 */
public interface PublisherDao {

    /**
     * �õ�������������Ϣ
     * @return �����缯��
     */
    public List<Publisher> getList();

    /**
     * ��ҳ�汾
     * @param start
     * @param end
     * @return
     */
    public List<Publisher> getList(int start, int end);

    /**
     * �õ��������ܼ�¼��
     * @return
     */
    public int getRecordCount();

    /**
     * ���ݳ������Ż�ó��������
     * @param id ��������
     * @return �����������������ڣ���null
     */
    public Publisher getSingle(int id);

    /**
     * ���ݳ�������ɾ��������
     * @param id ��������
     */
    public void gelete(int id);
}
