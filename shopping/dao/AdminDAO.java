package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Admin_Details;
import com.shopping.util.JDBCConnection;

public class AdminDAO 
{
	private static final String select = "select * from admin_details where Admin_Email_Id = ? and Admin_Password = ? ";
	public Admin_Details selectAllAdminDetails(String email,String password)
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Admin_Details> listOfAdmin = new ArrayList<Admin_Details>();
			if(resultSet.next())
			{
				Admin_Details admin_Details = new Admin_Details();
				admin_Details.setAdmin_role(resultSet.getString("Admin_Role"));
				admin_Details.setAdmin_email_id(resultSet.getString("Admin_Email_Id"));
				admin_Details.setAdmin_password(resultSet.getString("Admin_Password"));
				return admin_Details;
			}
			else return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
