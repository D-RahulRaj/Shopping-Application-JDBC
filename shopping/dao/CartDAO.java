package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Cart_Details;
import com.shopping.dto.Product_Details;
import com.shopping.util.JDBCConnection;

public class CartDAO 
{
	private static final String insert = "insert into cart_details(Product_Id, Customer_Id, Product_Quantity) values(?,?,?)";
	
	public boolean insertCartDetails(Cart_Details cart_Details)
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, cart_Details.getProduct_Id());
			preparedStatement.setInt(2, cart_Details.getCustomer_Id());
			preparedStatement.setInt(3, cart_Details.getProduct_Quantity());
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
	
	private static final String getcartDetailsOfCustomer = "select * from cart_details where Customer_Id = ?";
	public List<Cart_Details> selectCartDetailsUsingCustomerID(int customerID) 
	{
		try {
			List<Cart_Details> listOfCart = new ArrayList<Cart_Details>();
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(getcartDetailsOfCustomer);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					Cart_Details cart_Details = new Cart_Details();
					cart_Details.setCart_Id(resultSet.getInt("Cart_Id"));
					cart_Details.setProduct_Id(resultSet.getInt("Product_Id"));
					cart_Details.setCustomer_Id(resultSet.getInt("Customer_Id"));
					cart_Details.setProduct_Quantity(resultSet.getInt("Product_Quantity"));
					listOfCart.add(cart_Details);
				}
				return listOfCart;
			}
			else
				return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
