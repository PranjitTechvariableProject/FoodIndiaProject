package com.techVariable.FoodIndia.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.util.JdbcConnectionUtil;
import com.techVariable.FoodIndia.vo.PaymentVO;

@Service
public class PaymentService implements IPaymentService {

	public String createPayment(PaymentVO payment) {
		String sql = "INSERT INTO mobgrocerydb.payment_type(PAYMENT_TYPE) VALUES('" + payment.getPaymentType() + "')";

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "saved successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "save failed";
		}
	}

	public List<PaymentVO> getPaymentType() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM mobgrocerydb.payment_type";

		try {
			ResultSet result = JdbcConnectionUtil.getMySqlData(sql);
			List<PaymentVO> paymentList = new ArrayList<>();
			while (result.next()) {
				int id = result.getInt("PAYMENT_TYPE_ID");
				String type = result.getString("PAYMENT_TYPE");
				PaymentVO payment = new PaymentVO();
				payment.setId(id);
				payment.setPaymentType(type);
				paymentList.add(payment);

			}
			return paymentList;

		} catch (SQLException e) {
			throw e;
		} finally {
			JdbcConnectionUtil.closeConnection();
		}

	}

	public String editPayment(PaymentVO payment, int id) {
		String sql = "UPDATE  mobgrocerydb.payment_type SET PAYMENT_TYPE= '" + payment.getPaymentType()
				+ "' WHERE PAYMENT_TYPE_ID=" + id;

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "update successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "update failed";
		}
	}

	public String deletePayment(int id) {
		String sql = "DELETE FROM  mobgrocerydb.payment_type WHERE PAYMENT_TYPE_ID=" + id;

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "deleted successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "delete failed";
		}

	}

}
