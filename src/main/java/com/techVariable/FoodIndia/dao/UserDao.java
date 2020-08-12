package com.techVariable.FoodIndia.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.techVariable.FoodIndia.vo.UserVO;

@Repository
public class UserDao {
	public void createUser(UserVO user) 
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		factory.close();
		session.close();

	}
	public List<UserVO> getUserDetails() throws SQLException, ClassNotFoundException 
	{
		List<UserVO> userList = new ArrayList();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		userList = session.createQuery("FROM "+UserVO.class.getName()).list();
		transaction.commit();
		factory.close();
		session.close();
		return userList;
	}
	public void editUser(UserVO user, int id)
	{
		user.setId(id);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		factory.close();
		session.close();
	}
	public void deleteUser(int id) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		UserVO del = session.get(UserVO.class,id);//get complete obj from db to be deleted
		
		session.delete(del);
		transaction.commit();
		factory.close();
		session.close();

	}

}
