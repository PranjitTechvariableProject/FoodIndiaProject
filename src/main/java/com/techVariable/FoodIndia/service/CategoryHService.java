package com.techVariable.FoodIndia.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.dao.CategoryDao;
import com.techVariable.FoodIndia.vo.CategoryVO;

@Service
@Qualifier(value = "hib")

public class CategoryHService implements ICategoryService {
	@Autowired
	CategoryDao categoryDao;

	public String createCategory(CategoryVO category) {

		categoryDao.saveCategory(category);
		return "save successfully";
	}

	public List<CategoryVO> getCategoryType() throws SQLException, ClassNotFoundException {

		return categoryDao.getCategoryType();

	}

	public String editCategory(CategoryVO category, int id) {
		categoryDao.editCategory(category, id);
		return "updated successfully";
	}

	
	public String deleteCategory(int id) {
		categoryDao.deleteCategory(id);
		return "deleted successfully"; 
		
	}

}
