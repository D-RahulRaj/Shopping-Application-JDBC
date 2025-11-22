package com.shopping.dto;

import java.time.LocalDate;

public class Payment_Details 
{
	private int Payment_Id;
	private int Customer_Id; 
	private int Product_Id;
	private String Payment_Type; 
	private String Payment_Status; 
	private double Amount_Paid; 
	private LocalDate Payment_Date;
	
	
	public Payment_Details() {
		super();
	}
	public Payment_Details(int payment_Id, int customer_Id, int product_Id, String payment_Type, String payment_Status,
			double amount_Paid, LocalDate payment_Date) 
	{
		super();
		Payment_Id = payment_Id;
		Customer_Id = customer_Id;
		Product_Id = product_Id;
		Payment_Type = payment_Type;
		Payment_Status = payment_Status;
		Amount_Paid = amount_Paid;
		Payment_Date = payment_Date;
	}
	
	public void displayPaymentDetails() 
	{
		System.out.println("********** Payment Details ***********");
		System.out.println("Payment Id : "+getPayment_Id());
		System.out.println("Customer Id : "+getCustomer_Id());
		System.out.println("Product Id : "+getProduct_Id());
		System.out.println("Payment Type : "+getPayment_Type());
		System.out.println("Amount Paid : "+getAmount_Paid());
		System.out.println("Payment Date : "+getPayment_Date());
		System.out.println();
	}
	
	public String getPayment_Type() {
		return Payment_Type;
	}
	public void setPayment_Type(String payment_Type) {
		Payment_Type = payment_Type;
	}
	public String getPayment_Status() {
		return Payment_Status;
	}
	public void setPayment_Id(int payment_Id) {
		Payment_Id = payment_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}
	public void setPayment_Status(String payment_Status) {
		Payment_Status = payment_Status;
	}
	public double getAmount_Paid() {
		return Amount_Paid;
	}
	public void setAmount_Paid(double amount_Paid) {
		Amount_Paid = amount_Paid;
	}
	public LocalDate getPayment_Date() {
		return Payment_Date;
	}
	public void setPayment_Date(LocalDate payment_Date) {
		Payment_Date = payment_Date;
	}
	public int getPayment_Id() {
		return Payment_Id;
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public int getProduct_Id() {
		return Product_Id;
	}
	
	
}
