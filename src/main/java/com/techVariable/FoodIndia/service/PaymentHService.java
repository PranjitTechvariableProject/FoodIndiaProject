package com.techVariable.FoodIndia.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.dao.PaymentDao;
import com.techVariable.FoodIndia.vo.PaymentVO;
@Service
@Qualifier(value = "hib")

public class PaymentHService implements IPaymentService {
	@Autowired
	PaymentDao paymentDao;

	public String createPayment(PaymentVO payment) {
		paymentDao.createPayment(payment);
		return "saved successfully";
	}

	public List<PaymentVO> getPaymentType() throws SQLException, ClassNotFoundException {
		return paymentDao.getPaymentType();
	}

	public String editPayment(PaymentVO payment, int id) {

		paymentDao.editPayment(payment, id);
		return "saved successfully";
	}

	public String deletePayment(int id) {
		paymentDao.deletePayment(id);
		return "deleted successfully";

	}

}
