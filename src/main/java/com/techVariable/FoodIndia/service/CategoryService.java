package com.techVariable.FoodIndia.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.util.JdbcConnectionUtil;
import com.techVariable.FoodIndia.vo.CategoryVO;

@Service
public class CategoryService implements ICategoryService {
	public List<CategoryVO> getCategoryType() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM mobgrocerydb.category";

		try {
			ResultSet result = JdbcConnectionUtil.getMySqlData(sql);
			List<CategoryVO> categoryList = new ArrayList<>();
			while (result.next()) {
				int id = result.getInt("CATEGORY_ID");
				String name = result.getString("CATEGORY_NAME");
				CategoryVO category = new CategoryVO();
				category.setId(id);
				category.setName(name);
				categoryList.add(category);

			}
			return categoryList;

		} catch (SQLException e) {
			throw e;
		} finally {
			JdbcConnectionUtil.closeConnection();

		}

	}

	public String createCategory(CategoryVO category) {
		String sql = "INSERT INTO mobgrocerydb.category(CATEGORY_NAME) VALUES('" + category.getName() + "')";

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "saved successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "save failed";
		}

	}

	public String editCategory(CategoryVO category, int id) {
		String sql = "UPDATE  mobgrocerydb.category SET CATEGORY_NAME= '" + category.getName() + "' WHERE CATEGORY_ID="
				+ id;

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "update successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "update failed";
		}

	}

	public String deleteCategory(int id) {
		String sql = "DELETE FROM  mobgrocerydb.category WHERE CATEGORY_ID=" + id;

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
