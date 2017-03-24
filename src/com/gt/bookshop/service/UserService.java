package com.gt.bookshop.service;

import com.gt.bookshop.entities.OrderAddress;
import com.gt.bookshop.entities.User;
import com.gt.bookshop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GongTao on 2017/2/12/012.
 * ���������� ��Ա��ҵ����
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * �ж��û����������Ƿ���ȷ
     * @param name �û���
     * @param pwd ����
     * @return ��ȷ�����棬�����
     */
    public Boolean login(User user) {
        return userDao.login(user)==1?true:false;
    }

    /**
     * �ж��û��Ƿ��Ѿ���¼��վ����δ��¼������ת����¼ҳ��
     */
    public void checkUser() {

    }

    /**
     * ���ݻ�Ա��ţ���øû�Ա�Ķ�����ַ��Ϣ
     * ҵ��Ҫ������û�Աû���¹����������ַ��Ϣ����Ա����ȡ
     * �¹����������ַ��Ϣ�Ǹû�Ա����µĶ�����ַ��Ϣ
     * @param userId ��Ա���,���ǻ�Ա�˺�
     * @return ��ַ��Ϣ
     */
    public OrderAddress getOrderAddressByUserId(int userId) {
        return null;
    }

    /**
     *  ���ݻ�Ա��¼�˺ţ���øû�Ա���
     *  ���ã����¶�����ʱ�򣬻�����������
     * @param loginid
     * @return
     */
    public int getUserId(String loginid) {
        return 0;
    }
}
