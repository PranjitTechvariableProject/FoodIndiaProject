package com.techVariable.FoodIndia.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techVariable.FoodIndia.service.ICategoryService;
import com.techVariable.FoodIndia.vo.CategoryVO;

@RestController
@RequestMapping("/")
public class CategoryController {
	@Autowired
	
	private ICategoryService categoryService;

	@PostMapping(path = "category/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCategory(@RequestBody CategoryVO category) {
		String message = categoryService.createCategory(category);
		return message;
	}

	@GetMapping(path = "category/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryVO> getCategoryType() throws SQLException, ClassNotFoundException {
		List<CategoryVO> categoryTypeList = categoryService.getCategoryType();
		return categoryTypeList;

	}
	@PutMapping(path = "category/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String editCategory(@RequestBody CategoryVO category,@RequestParam int id)
	{
		String message = categoryService.editCategory(category,id);
		return message;

		
	}
	@DeleteMapping(path = "category/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCategory(@RequestParam int id)
	{
		String message = categoryService.deleteCategory(id);
		return message;

		
	}
	
	
}
