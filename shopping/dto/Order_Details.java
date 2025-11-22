package com.shopping.dto;

import java.time.LocalDate;

public class Order_Details 
{
	private int Order_Id; 
	private int Customer_Id; 
	private int Product_Id;
	private int Product_Quantity; 
	private String Order_Address;
	private LocalDate Order_Date;
	
	public Order_Details() {}
	public Order_Details(int order_Id, int customer_Id, int product_Id, int product_Quantity, String order_Address,
			LocalDate order_Date) 
	{
		Order_Id = order_Id;
		Customer_Id = customer_Id;
		Product_Id = product_Id;
		Product_Quantity = product_Quantity;
		Order_Address = order_Address;
		Order_Date = order_Date;
	}
	
	public void setOrder_Id(int order_Id) {
		Order_Id = order_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}
	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}
	public void displayOrderDetails() 
	{
		System.out.println("********** Order Details ***********");
		System.out.println("Order Id : "+getOrder_Id());
		System.out.println("Customer Id : "+getCustomer_Id());
		System.out.println("Product Id : "+getProduct_Id());
		System.out.println("Product Quantity : "+getProduct_Quantity());
		System.out.println("Order Address : "+getOrder_Address());
		System.out.println("Order Date : "+getOrder_Date());
		System.out.println();
	}
	
	public String getOrder_Address() {
		return Order_Address;
	}
	public void setOrder_Address(String order_Address) {
		Order_Address = order_Address;
	}
	public LocalDate getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(LocalDate localDate) {
		Order_Date = localDate;
	}
	public int getOrder_Id() {
		return Order_Id;
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public int getProduct_Id() {
		return Product_Id;
	}
	public int getProduct_Quantity() {
		return Product_Quantity;
	}
}
