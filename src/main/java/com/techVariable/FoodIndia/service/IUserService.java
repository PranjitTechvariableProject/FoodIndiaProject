package com.techVariable.FoodIndia.service;

import java.sql.SQLException;
import java.util.List;

import com.techVariable.FoodIndia.vo.UserVO;

public interface IUserService {
	String createUser(UserVO user);
	public List<UserVO> getUserDetails() throws SQLException, ClassNotFoundException;
	String editUser(UserVO user,int id);
	String deleteUser(int id);

}

