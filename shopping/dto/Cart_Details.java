package com.shopping.dto;

public class Cart_Details 
{
	private int Cart_Id;
	private int Product_Id;
	private int Customer_Id; 
	private int Product_Quantity;
	
	public Cart_Details() {}
	public Cart_Details(int cart_Id, int product_Id, int customer_Id, int product_Quantity) 
	{
		Cart_Id = cart_Id;
		Product_Id = product_Id;
		Customer_Id = customer_Id;
		Product_Quantity = product_Quantity;
	}
	
	public void displayCartDetails() 
	{
		System.out.println("********** Cart Details ***********");
		System.out.println("Cart Id : "+getCart_Id());
		System.out.println("Product Id : "+getProduct_Id());
		System.out.println("Customer Id : "+getCustomer_Id());
		System.out.println("Product Quantity : "+getProduct_Quantity());
		System.out.println();
	}
	
	public void setCart_Id(int cart_Id) {
		Cart_Id = cart_Id;
	}
	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public int getCart_Id() {
		return Cart_Id;
	}
	public int getProduct_Id() {
		return Product_Id;
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public int getProduct_Quantity() {
		return Product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}
}
