package com.techVariable.FoodIndia.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techVariable.FoodIndia.service.IUserService;
import com.techVariable.FoodIndia.vo.UserVO;
@RestController
@RequestMapping("/h/")
public class UserHController {
	@Qualifier("hib")
	@Autowired
	private IUserService userService;

	@PostMapping(path = "user/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody UserVO user) {
		String message = userService.createUser(user);
		return message;
	}

	@GetMapping(path = "user/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserVO> getUserDetails() throws SQLException, ClassNotFoundException {
		List<UserVO> userDetailsList = userService.getUserDetails();
		return userDetailsList;
	}
		@PutMapping(path = "user/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public String editUser(@RequestBody UserVO user,@RequestParam int id)
		{
			String message = userService.editUser(user,id);
			return message;

			
		}
		@DeleteMapping(path = "user/delete", produces = MediaType.APPLICATION_JSON_VALUE)
		public String deleteUser(@RequestParam int id)
		{
			String type = userService.deleteUser(id);
			return type;

			
		}
		




}
