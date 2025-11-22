package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shopping.dto.Product_Details;
import com.shopping.util.JDBCConnection;

public class ProductDAO 
{
	private final static String insert = "insert into product_details(Product_Name, Product_Brand, Product_Price, Product_MF_Date, "
			+ "Product_Exp_Date, Product_Quantity, Product_Category, Product_Discount) values(?,?,?,?,?,?,?,?)";
	public boolean insertProductDetails(Product_Details product_Details)
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1,product_Details.getProduct_Name());
			preparedStatement.setString(2,product_Details.getProduct_Brand());
			preparedStatement.setDouble(3,product_Details.getProduct_Price());
			preparedStatement.setDate(4,product_Details.getProduct_MF_Date());
			preparedStatement.setDate(5,product_Details.getProduct_Exp_Date());
			preparedStatement.setInt(6,product_Details.getProduct_Quantity());
			preparedStatement.setString(7,product_Details.getProduct_Category());
			preparedStatement.setDouble(8,product_Details.getProduct_Discount());
			int result = preparedStatement.executeUpdate();
			if(result !=0)
				return true;
			else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean insertMoreThanOneProduct(List<Product_Details> listOfProducts)
	{
		Connection connection;
		try {
			connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			for (Product_Details product_Details : listOfProducts)
			{
				preparedStatement.setString(1, product_Details.getProduct_Name());
				preparedStatement.setString(2, product_Details.getProduct_Brand());
				preparedStatement.setDouble(3, product_Details.getProduct_Price());
				preparedStatement.setDate(4, product_Details.getProduct_MF_Date());
				preparedStatement.setDate(5, product_Details.getProduct_Exp_Date());
				preparedStatement.setInt(6, product_Details.getProduct_Quantity());
				preparedStatement.setString(7, product_Details.getProduct_Category());
				preparedStatement.setDouble(8, product_Details.getProduct_Discount());
				preparedStatement.addBatch();
			}
			int[] results = preparedStatement.executeBatch();
			if (results.length!=0) 
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	private final String getAllProducts = "select * from product_details"; 
	public List<Product_Details> getAllProductDetails() 
	{
		try {
			List<Product_Details> listOfProducts = new ArrayList<Product_Details>();
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(getAllProducts);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					Product_Details product_Details = new Product_Details();
					product_Details.setProduct_Id(resultSet.getInt("Product_Id"));
					product_Details.setProduct_Name(resultSet.getString("Product_Name"));
					product_Details.setProduct_Brand(resultSet.getString("Product_Brand"));
					product_Details.setProduct_Price(resultSet.getDouble("Product_Price"));
					product_Details.setProduct_MF_Date(resultSet.getDate("Product_MF_Date"));
					product_Details.setProduct_Exp_Date(resultSet.getDate("Product_Exp_Date"));
					product_Details.setProduct_Quantity(resultSet.getInt("Product_Quantity"));
					product_Details.setProduct_Category(resultSet.getString("Product_Category"));
					product_Details.setProduct_Discount(resultSet.getDouble("Product_Discount"));
					listOfProducts.add(product_Details);
				}
				return listOfProducts;
			}
			else
				return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
