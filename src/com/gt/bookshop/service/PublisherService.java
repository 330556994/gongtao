package com.gt.bookshop.service;

import com.gt.bookshop.entities.Publisher;
import com.gt.bookshop.dao.PublisherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongTao on 2017/2/11/011.
 * ���������� �������ҵ����
 */
@Service
public class PublisherService {

    @Autowired
    private PublisherDao publisherDao;

    /**
     * �õ�������������Ϣ
     * @return �����缯��
     */
    public List<Publisher> getList() {
        return publisherDao.getList();
    }

    /**
     * ��ҳ�汾
     * @param start
     * @param end
     * @return
     */
    public List<Publisher> getList(int start, int end) {
        return null;
    }

    /**
     * �õ��������ܼ�¼��
     * @return
     */
    public int getRecordCount() {
        return 0;
    }

    /**
     * ���ݳ������Ż�ó��������
     * @param id ��������
     * @return �����������������ڣ���null
     */
    public Publisher getSingle(int id) {
        return null;
    }

    /**
     * ���ݳ�������ɾ��������
     * @param id ��������
     */
    public void delete(int id) {

    }
}
