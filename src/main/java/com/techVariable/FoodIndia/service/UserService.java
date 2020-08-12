package com.techVariable.FoodIndia.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.util.JdbcConnectionUtil;
import com.techVariable.FoodIndia.vo.UserVO;

@Service
public class UserService implements IUserService {
	public String createUser(UserVO user) {
		String sql = "INSERT INTO mobgrocerydb.customers(CUSTOMER_NAME,CUSTOMER_PHONE_NUMBER,EMAIL_ADDRESS,ZIP_CODE,STATE ,CONTRY,ADDRESS_LINE1, ADDRESS_LINE2) VALUES('"
				+ user.getName() + "','" + user.getPhoneNumber() + "','" + user.getEmail() + "'," + user.getZipCode()
				+ ",'" + user.getState() + "','" + user.getCountry() + "','" + user.getAddressLine1() + "','"
				+ user.getAddressLine2() + "')";

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);

			return "saved successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "save failed";
		}
	}

	public List<UserVO> getUserDetails() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM mobgrocerydb.customers";

		try {
			ResultSet result = JdbcConnectionUtil.getMySqlData(sql);
			List<UserVO> userList = new ArrayList<>();
			while (result.next()) {
				int id = result.getInt("CUSTOMER_ID");
				String name = result.getString("CUSTOMER_NAME");
				String phoneNumber = result.getString("CUSTOMER_PHONE_NUMBER");
				String email = result.getString("EMAIL_ADDRESS");
				int zipCode = result.getInt("ZIP_CODE");
				String state = result.getString("STATE");
				String country = result.getString("CONTRY");
				String addressLine1 = result.getString("ADDRESS_LINE1");
				String addressLine2 = result.getString("ADDRESS_LINE2");

				UserVO user = new UserVO();
				user.setId(id);
				user.setName(name);
				user.setPhoneNumber(phoneNumber);
				user.setEmail(email);
				user.setZipCode(zipCode);
				user.setState(state);
				user.setCountry(country);
				user.setAddressLine1(addressLine1);
				user.setAddressLine2(addressLine2);

				userList.add(user);

			}
			return userList;

		} catch (SQLException e) {
			throw e;
		} finally {
			JdbcConnectionUtil.closeConnection();

		}
	}

	public String editUser(UserVO user, int id) {
		String sql = "UPDATE  mobgrocerydb.customers SET CUSTOMER_NAME='" + user.getName() + "',CUSTOMER_PHONE_NUMBER='"
				+ user.getPhoneNumber() + "',EMAIL_ADDRESS='" + user.getEmail() + "',ZIP_CODE=" + user.getZipCode()
				+ ",STATE='" + user.getState() + "',CONTRY='" + user.getCountry() + "',ADDRESS_LINE1 ='"
				+ user.getAddressLine1() + "',ADDRESS_LINE2='" + user.getAddressLine2() + "' WHERE CUSTOMER_ID=" + id;

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "update successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "update failed";
		}

	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
