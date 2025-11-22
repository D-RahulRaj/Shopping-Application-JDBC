package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.OrderDAO;
import com.shopping.dto.Customer_Details;
import com.shopping.dto.Order_Details;
import com.shopping.dto.Payment_Details;

public class OrderService 
{	
	Scanner scan = new Scanner(System.in);
	OrderDAO orderDAO = new OrderDAO();
	public Order_Details orderDetails(Payment_Details payment_Details, int quantity,String tableAddress)
	{
		Order_Details order_Details = new Order_Details();
		System.out.println("--> Select Delivery Address : \n 1. "+tableAddress+" \n 2. Change Address");
		int address = scan.nextInt();
		switch (address) {
		case 1:
			order_Details.setOrder_Address(tableAddress);
			break;
		case 2:
			System.out.print("--> Enter The New Address : ");
			String newAddress = scan.next();
			order_Details.setOrder_Address(newAddress);
			break;
		default:
			 System.out.println("You Entered Invalid So default address: " + tableAddress);
			 order_Details.setOrder_Address(tableAddress);
			break;
		}
		order_Details.setCustomer_Id(payment_Details.getCustomer_Id());
		order_Details.setProduct_Id(payment_Details.getProduct_Id());
		order_Details.setProduct_Quantity(quantity);
		order_Details.setOrder_Date(LocalDate.now());
		if(orderDAO.insertOrderDetails(order_Details))
		{
			System.out.println("Order Placed Successfully");
		}
		else
		{
			System.err.println("Server Error 500");
		}
		return order_Details;
	}
}
