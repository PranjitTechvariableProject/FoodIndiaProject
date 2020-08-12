package com.techVariable.FoodIndia.service;

import java.sql.SQLException;
import java.util.List;

import com.techVariable.FoodIndia.vo.CategoryVO;

public interface ICategoryService {
	String createCategory(CategoryVO category);
	public List<CategoryVO> getCategoryType() throws SQLException, ClassNotFoundException;
	String editCategory(CategoryVO category,int id);

	String deleteCategory(int id);
}
