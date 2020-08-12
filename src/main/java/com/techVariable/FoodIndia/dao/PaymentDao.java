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

import com.techVariable.FoodIndia.vo.PaymentVO;

@Repository
public class PaymentDao {
	public void createPayment(PaymentVO payment) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(payment);
		transaction.commit();
		factory.close();
		session.close();
	}
	public List<PaymentVO> getPaymentType() throws SQLException, ClassNotFoundException {
		List<PaymentVO> paymentList = new ArrayList();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		paymentList = session.createQuery("FROM "+PaymentVO.class.getName()).list();
		transaction.commit();
		factory.close();
		session.close();
		return paymentList;
	}
	public void editPayment(PaymentVO payment, int id) {
		payment.setId(id);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(payment);
		transaction.commit();
		factory.close();
		session.close();
	}
	public void deletePayment(int id) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cnfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		PaymentVO del = session.get(PaymentVO.class,id);//get complete obj from db to be deleted
		
		session.delete(del);
		transaction.commit();
		factory.close();
		session.close();

		
	}
}
