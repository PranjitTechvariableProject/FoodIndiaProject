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

import com.techVariable.FoodIndia.vo.CategoryVO;

@Repository
public class CategoryDao {
	public void saveCategory(CategoryVO category) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
		factory.close();
		session.close();
	}

	public List<CategoryVO> getCategoryType() throws SQLException, ClassNotFoundException {
		List<CategoryVO> categoryList = new ArrayList();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		categoryList = session.createQuery("FROM "+CategoryVO.class.getName()).list();
		transaction.commit();
		factory.close();
		session.close();
		return categoryList;

	}
	public void editCategory(CategoryVO category, int id) 
	{
		category.setId(id);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(category);
		transaction.commit();
		factory.close();
		session.close();
	}
	public void deleteCategory(int id) 
	{
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		CategoryVO del = session.get(CategoryVO.class,id);//get complete obj from db to be deleted
		
		session.delete(del);
		transaction.commit();
		factory.close();
		session.close();
		
	}

}
