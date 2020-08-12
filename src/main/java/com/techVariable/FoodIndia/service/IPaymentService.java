package com.techVariable.FoodIndia.service;

import java.sql.SQLException;
import java.util.List;

import com.techVariable.FoodIndia.vo.PaymentVO;

public interface IPaymentService {
	String createPayment(PaymentVO payment);

	public List<PaymentVO> getPaymentType() throws SQLException, ClassNotFoundException;
	String editPayment(PaymentVO payment,int id);
	String deletePayment(int id);

}
