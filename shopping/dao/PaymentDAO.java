package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.dto.Payment_Details;
import com.shopping.util.JDBCConnection;

public class PaymentDAO 
{
	private static final String insert = "insert into payment_details(Customer_Id, Product_Id, Payment_Type,"
			+ "Payment_Status, Amount_Paid, Payment_Date) values(?,?,?,?,?,?)";
	public boolean insertPaymentDetails(Payment_Details payment_Details)
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, payment_Details.getCustomer_Id());
			preparedStatement.setInt(2, payment_Details.getProduct_Id());
			preparedStatement.setString(3, payment_Details.getPayment_Type());
			preparedStatement.setString(4, payment_Details.getPayment_Status());
			preparedStatement.setDouble(5, payment_Details.getAmount_Paid());
			preparedStatement.setDate(6, Date.valueOf(payment_Details.getPayment_Date()));
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
