package com.gt.bookshop.service;

import com.gt.bookshop.entities.Category;
import com.gt.bookshop.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongTao on 2017/2/11/011.
 * ���������� ͼ������ҵ����
 */
@Service
public class CategoryService {

    // �˴��� bookMap ��һ���ӿ� MyBatis
    @Autowired
    private CategoryDao categoryDao;

    /**
     * ��ȡ���з�����Ϣ
     * @return  ���з��༯��
     */
    public List<Category> getList() {
        return categoryDao.getList();
    }

    /**
     * ����ͼ����𼯺ϴ������ͼ����������������books/index�л����
     * @return
     */
    public List<Category> getListWithBooCount() {
        return null;
    }

    /**
     * ��������Ż�õ���������
     * @param id �����
     * @return  ����id�򷵻ض��󣬲����ڷ���null
     */
    public Category getSingle(int id) {
        return null;
    }

}
