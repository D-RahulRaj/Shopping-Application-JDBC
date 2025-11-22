package com.shopping.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shopping.dto.Customer_Details;
import com.shopping.util.JDBCConnection;

public class CustomerDAO 
{
  	private static final String insert = "insert into customer_details(Customer_Name,"
			+ "Customer_Email_Id, Customer_PhNo, Customer_Address, Customer_Gender, Customer_Password) "
			+ "values(?,?,?,?,?,?)";
	
	public boolean insertCustomerDetails(Customer_Details customer_Details)
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, customer_Details.getCustomer_Name());
			preparedStatement.setString(2, customer_Details.getCustomer_Email_Id());
			preparedStatement.setLong(3, customer_Details.getCustomer_PhNo());
			preparedStatement.setString(4, customer_Details.getCustomer_Address());
			preparedStatement.setString(5, customer_Details.getCustomer_Gender());
			preparedStatement.setString(6, customer_Details.getCustomer_Password());
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
	
	
	private static final String select = "select * from customer_details";
	public List<Customer_Details> selectAllCustomerDetails()
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Customer_Details> listOfCustomers = new ArrayList<Customer_Details>();
			while(resultSet.next())
			{
				Customer_Details customer_Details = new Customer_Details();
				customer_Details.setCustomer_Email_Id(resultSet.getString("Customer_Email_Id"));
				customer_Details.setCustomer_PhNo(resultSet.getLong("Customer_PhNo"));
				customer_Details.setCustomer_Password(resultSet.getString("Customer_Password"));
				listOfCustomers.add(customer_Details);
			}
			return listOfCustomers;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static final String customer_Login = "select * from customer_details where  (Customer_Email_Id=? or Customer_PhNo=?) and Customer_Password=?";
	public Customer_Details selectCustomerDetailsByUsingEmailOrMobileNumberAndPassword(String emailOrMobile, String password)
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(customer_Login);
			preparedStatement.setString(1, emailOrMobile);
			preparedStatement.setString(2, emailOrMobile);
			preparedStatement.setString(3, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Customer_Details customer_Details = new Customer_Details();
				customer_Details.setCustomer_Id(resultSet.getInt("Customer_Id"));;
				customer_Details.setCustomer_Email_Id(resultSet.getString("Customer_Email_Id"));
				customer_Details.setCustomer_PhNo(resultSet.getLong("Customer_PhNo"));
				customer_Details.setCustomer_Password(resultSet.getString("Customer_Password"));
				customer_Details.setCustomer_Name(resultSet.getString("Customer_Name"));
				customer_Details.setCustomer_Gender(resultSet.getString("Customer_Gender"));
				customer_Details.setCustomer_Address(resultSet.getString("Customer_Address"));
				return customer_Details;
			}
			else {
				return null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
