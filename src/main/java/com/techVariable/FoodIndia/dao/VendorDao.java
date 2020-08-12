package com.techVariable.FoodIndia.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.techVariable.FoodIndia.vo.VendorVO;

@Repository
public class VendorDao {
	public void createVendor(VendorVO vendor)
	{
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		vendor.setJoiningDate(date);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(vendor);
		transaction.commit();
		factory.close();
		session.close();
	}
	public List<VendorVO> getVendorDetails() throws SQLException, ClassNotFoundException 
	{
		List<VendorVO> vendorList = new ArrayList();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		vendorList = session.createQuery("FROM "+VendorVO.class.getName()).list();
		transaction.commit();
		factory.close();
		session.close();
		return vendorList;
	}
	public void editVendor(VendorVO vendor, int id) 
	{
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		vendor.setJoiningDate(date);
		
		vendor.setId(id);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(vendor);
		transaction.commit();
		factory.close();
		session.close();
		
	}
	public void deleteVendor(int id) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		VendorVO del = session.get(VendorVO.class,id);//get complete obj from db to be deleted
		
		session.delete(del);
		transaction.commit();
		factory.close();
		session.close();

	}
	
}
