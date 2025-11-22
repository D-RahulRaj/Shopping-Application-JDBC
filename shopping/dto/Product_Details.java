package com.shopping.dto;

import java.sql.Date;

public class Product_Details 
{
	private int Product_Id;
	private String Product_Name; 
	private String Product_Brand; 
	private double Product_Price; 
	private Date Product_MF_Date; 
	private Date Product_Exp_Date; 
	private int Product_Quantity;
	private String Product_Category; 
	private double Product_Discount;
	
	public Product_Details() {
		super();
	}

	public Product_Details(int product_Id, String product_Name, String product_Brand, double product_Price,
			Date product_MF_Date, Date product_Exp_Date, int product_Quantity, String product_Category,
			double product_Discount) {
		super();
		Product_Id = product_Id;
		Product_Name = product_Name;
		Product_Brand = product_Brand;
		Product_Price = product_Price;
		Product_MF_Date = product_MF_Date;
		Product_Exp_Date = product_Exp_Date;
		Product_Quantity = product_Quantity;
		Product_Category = product_Category;
		Product_Discount = product_Discount;
	}

	public void displayProductDetails() 
	{
		System.out.println("********** Product Details ***********");
		System.out.println("Product Id : "+getProduct_Id());
		System.out.println("Product Name : "+getProduct_Name());
		System.out.println("Product Brand : "+getProduct_Brand());
		System.out.println("Product Price : "+getProduct_Price());
		System.out.println("Product MFD : "+getProduct_MF_Date());
		System.out.println("Product EXPD : "+getProduct_Exp_Date());
		System.out.println("Product Quantity : "+getProduct_Quantity());
		System.out.println("Product Catagory : "+getProduct_Category());
		System.out.println("Product Discount : "+getProduct_Discount());
		System.out.println();
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public String getProduct_Brand() {
		return Product_Brand;
	}

	public void setProduct_Brand(String product_Brand) {
		Product_Brand = product_Brand;
	}

	public double getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(double product_Price) {
		Product_Price = product_Price;
	}

	public Date getProduct_MF_Date() {
		return Product_MF_Date;
	}

	public void setProduct_MF_Date(Date product_MF_Date) {
		Product_MF_Date = product_MF_Date;
	}

	public Date getProduct_Exp_Date() {
		return Product_Exp_Date;
	}

	public void setProduct_Exp_Date(Date product_Exp_Date) {
		Product_Exp_Date = product_Exp_Date;
	}

	public int getProduct_Quantity() {
		return Product_Quantity;
	}

	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}

	public String getProduct_Category() {
		return Product_Category;
	}

	public void setProduct_Category(String product_Category) {
		Product_Category = product_Category;
	}

	public double getProduct_Discount() {
		return Product_Discount;
	}

	public void setProduct_Discount(double product_Discount) {
		Product_Discount = product_Discount;
	}

	public int getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}
}
