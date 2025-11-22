package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.PaymentDAO;
import com.shopping.dto.Order_Details;
import com.shopping.dto.Payment_Details;

public class PaymentService 
{
	Scanner scan = new Scanner(System.in);
	PaymentDAO paymentDAO = new PaymentDAO();
	OrderService orderService = new OrderService();

	public Payment_Details paymentProcessDetails(int id,double AmtToPay,int productId,int quantity,String Address) 
	{
		Payment_Details payment_Details = new Payment_Details();
		System.out.println("--> Select Payment Method : \n 1. For UPI \n 2. Debit Card \n 3. Credit Card \n 4. Net Banking \n 5.EMI \n 6. Cash On Delivery");
		int paymentMethod = scan.nextInt();
		switch (paymentMethod) {
		case 1:
			payment_Details.setPayment_Type("UPI");
			payment_Details.setPayment_Status("Payment Success");
			break;
		case 2:
			payment_Details.setPayment_Type("Debit Card");
			payment_Details.setPayment_Status("Payment Success");
			break;
		case 3:
			payment_Details.setPayment_Type("Credit Card");
			payment_Details.setPayment_Status("Payment Success");
			break;
		case 4:
			payment_Details.setPayment_Type("Net-Banking");
			payment_Details.setPayment_Status("Payment Success");
			break;
		case 5:
			payment_Details.setPayment_Type("EMI");
			payment_Details.setPayment_Status("Payment Proccessing");
			break;
		case 6:
			payment_Details.setPayment_Type("Cash On Delivery");
			payment_Details.setPayment_Status("Payment Proccessing");
			break;
		default:
			break;
		}	
		System.out.print("Enter The Amount : ");
		double amount = scan.nextDouble();
		if(AmtToPay==amount)
		{
			payment_Details.setCustomer_Id(id);
			payment_Details.setPayment_Date(LocalDate.now());
			payment_Details.setProduct_Id(productId);
			payment_Details.setAmount_Paid(AmtToPay);
			if(paymentDAO.insertPaymentDetails(payment_Details))
			{
				orderService.orderDetails(payment_Details,quantity,Address);
			}
			return payment_Details;
		}
		else
		{
			System.out.println("Please Enter Above Dispalyed Amount");
		}
		return payment_Details;
	}
}

