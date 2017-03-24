package com.gt.bookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ���� ������ȡ session
 * Created by GongTao on 2017/2/10/010.
 */
public class BaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		//����ʹ�� getCurrentSession() ����
		return this.sessionFactory.getCurrentSession();
		
//		return this.sessionFactory.openSession();
	}
	
}
