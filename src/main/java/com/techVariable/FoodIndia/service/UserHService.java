package com.techVariable.FoodIndia.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.dao.UserDao;
import com.techVariable.FoodIndia.vo.UserVO;
@Service
@Qualifier(value = "hib")

public class UserHService implements IUserService {
	@Autowired
	UserDao userDao;

	public String createUser(UserVO user) 
	{
		userDao.createUser(user);
		return "saved successfully";
		
		}

	public List<UserVO> getUserDetails() throws SQLException, ClassNotFoundException 
	{
		return userDao.getUserDetails();
		
		
	}

		public String editUser(UserVO user, int id)
		{
			userDao.editUser(user, id);
			return "updated successfully";
		}
		public String deleteUser(int id) {
			userDao.deleteUser(id);
			return "deleted successfully";

		}

}
