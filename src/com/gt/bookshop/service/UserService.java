package com.gt.bookshop.service;

import com.gt.bookshop.entities.OrderAddress;
import com.gt.bookshop.entities.User;
import com.gt.bookshop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GongTao on 2017/2/12/012.
 * 功能描述： 会员的业务类
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 判断用户名和密码是否正确
     * @param name 用户名
     * @param pwd 密码
     * @return 正确返回真，否则假
     */
    public Boolean login(User user) {
        return userDao.login(user)==1?true:false;
    }

    /**
     * 判断用户是否已经登录网站，如未登录，则跳转到登录页面
     */
    public void checkUser() {

    }

    /**
     * 根据会员编号，获得该会员的订单地址信息
     * 业务要求：如果该会员没有下过订单，则地址信息到会员表中取
     * 下过订单，则地址信息是该会员最近下的订单地址信息
     * @param userId 会员编号,不是会员账号
     * @return 地址信息
     */
    public OrderAddress getOrderAddressByUserId(int userId) {
        return null;
    }

    /**
     *  根据会员登录账号，获得该会员编号
     *  调用：在下订单的时候，会调用这个方法
     * @param loginid
     * @return
     */
    public int getUserId(String loginid) {
        return 0;
    }
}
