package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.dto.Order_Details;
import com.shopping.util.JDBCConnection;

public class OrderDAO 
{
	private static final String insert = "insert into order_details(Customer_Id, Product_Id, Product_Quantity, Order_Address, Order_Date) values(?,?,?,?,?)";
	
	public boolean insertOrderDetails(Order_Details order_Details) 
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1,order_Details.getCustomer_Id());
			preparedStatement.setInt(2,order_Details.getProduct_Id());
			preparedStatement.setInt(3,order_Details.getProduct_Quantity());
			preparedStatement.setString(4, order_Details.getOrder_Address());
			preparedStatement.setDate(5, Date.valueOf(order_Details.getOrder_Date()));
			int result = preparedStatement.executeUpdate();
			if(result!=0)
				return true;
			else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
