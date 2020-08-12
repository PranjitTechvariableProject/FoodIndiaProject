package com.techVariable.FoodIndia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static void openConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// jdbc connection and execute
	public static void executeMySqlQuery(String sql) throws SQLException, ClassNotFoundException {

		openConnection();
		try {
			if (con != null) {
				stmt = con.createStatement();

				stmt.executeUpdate(sql);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConnection();
		}
	}

	public static void closeConnection() throws SQLException
	{
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {

			con.close();
		}

	}
	public static ResultSet getMySqlData(String sql) throws SQLException, ClassNotFoundException {
			openConnection();
		
		try {
			if(con!=null)
			{
			stmt = con.createStatement();

			ResultSet result = stmt.executeQuery(sql);
			return result;
			}
			else
			{
				return null;
			}

		} catch (SQLException e) {
			throw e;
		} 
		
		
	}

}
