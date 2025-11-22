package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.shopping.dao.CustomerDAO;
import com.shopping.dto.Cart_Details;
import com.shopping.dto.Customer_Details;
import com.shopping.dto.Product_Details;
import com.shopping.exception.CustomerDataInValidException;

public class CustomerService
{
	CustomerDAO customerDAO = new CustomerDAO();
	Customer_Details customer_Details;
	Product_Details product_Details = new Product_Details();
	ProductService productService = new ProductService();
	CartService cartService = new CartService();
	PaymentService paymentService = new PaymentService();
	Scanner scan=new Scanner(System.in);
	
	public void customerRegistration() 
	{
		customer_Details = new Customer_Details();
		List<Customer_Details> listOfCustomers = customerDAO.selectAllCustomerDetails();
		System.out.print("Enter CustomerName : ");
		String cName=scan.next();
		
		System.out.println("Enter Customer EmailId : ");
		while (true) {
			String cEmailId=scan.next();
			long emailIdCount = listOfCustomers.stream().filter((customer)-> customer.getCustomer_Email_Id().equals(cEmailId)).count();
			try {
				if(emailIdCount>0)
				{
					throw new CustomerDataInValidException("Email Id Already Exists");
				}
				if((cEmailId == null) || !(cEmailId.contains("@gmail.com")))
					throw new CustomerDataInValidException("Mail Should Have '@gmail.com'");
				else
				{
					customer_Details.setCustomer_Email_Id(cEmailId);
					break;
				}
			} catch (CustomerDataInValidException e) {
				System.out.println(e.getException());
				System.out.println("Enter A Valid Email Id");
			}
		}
		
		System.out.print("Enter Customer Mobile Number :");
		while(true)
		{	
			long cMobileNumber=scan.nextLong();
			long phNoCount = listOfCustomers.stream().filter((customer) -> customer.getCustomer_PhNo()==cMobileNumber).count();
			try {
				if(phNoCount>0)
				{
					throw new CustomerDataInValidException("Phone Number Already Exists");
				}
				if(cMobileNumber==0 || !(cMobileNumber>=6000000000l && cMobileNumber<=9999999999l))
					throw new CustomerDataInValidException("Mobile Number Cannot Be Null And Can Only Contain Numbers And Should Be 10 Digits");
				else
				{
					customer_Details.setCustomer_PhNo(cMobileNumber);
					break;
				}
			} catch (CustomerDataInValidException e) {
				System.out.println(e.getException());
				System.out.println("Enter A Valid Mobile Number");
			}
		}
		
		System.out.print("Enter Customer Address : ");
		String cAddress=scan.next();
		
		System.out.println("Enter Customer Gender: ");
		String cGender=scan.next();
		while(true)
		{
			try {
				if(!(cGender.equalsIgnoreCase("male") || cGender.equalsIgnoreCase("Female") || cGender.equalsIgnoreCase("Others")))
				{	
					throw new CustomerDataInValidException("Gender Cannot Be Null Or More Than 1 Character And Should Be Either M : Male Or F : Female");
				}
				else
					break;
			} catch (CustomerDataInValidException e) {
				System.out.println(e.getException());
				System.out.println("Enter A Valid Mobile Number");
				cGender=scan.next();
			}
		}
		
		System.out.println("Enter Customer Password: ");
		String cPassword=scan.next();
		String customerPassword = cPassword;
		long passwordCount = listOfCustomers.stream().filter((customer) -> customer.getCustomer_Password().equals(customerPassword)).count();
		
		while(true)
		{
			try {
				if(passwordCount>0)
				{
					throw new CustomerDataInValidException("Password Already Taken");
				}
				if(!(cPassword.length()>8))
				{
					throw new CustomerDataInValidException("Invalid Password");
				}
				else
				{
					customer_Details.setCustomer_Password(customerPassword);
					break;
				}
			} catch (CustomerDataInValidException e) {
				System.out.println(e.getException());
				System.out.println("Enter Valid Password");
				cPassword=scan.next();
			}
		}
	
		customer_Details.setCustomer_Name(cName);
		customer_Details.setCustomer_Address(cAddress);
		customer_Details.setCustomer_Gender(cGender);
		
		if(customerDAO.insertCustomerDetails(customer_Details))
			System.out.println(cName+" Your Registration Is Successfull");
		else
			System.out.println("Server 500");
	}
	
	public void customerLogin() 
	{
		System.out.print("Enter Customer Email Or Mobile Number : ");
		String emailOrMobile = scan.next();
		System.out.print("Enter Customer Password : ");
		String password = scan.next();
		customer_Details = customerDAO.selectCustomerDetailsByUsingEmailOrMobileNumberAndPassword(emailOrMobile, password);
		if(customer_Details != null)
		{
			System.out.println("Customer Login Successfull");
			if(customer_Details.getCustomer_Gender().equalsIgnoreCase("Male"))
			{
				System.out.println("Hello Mr "+customer_Details.getCustomer_Name()+" Welcome To E-Shopping Application");
				System.out.println();
				customerOperations();
			}
			if(customer_Details.getCustomer_Gender().equalsIgnoreCase("Female"))
			{
				System.out.println("Hello Ms "+customer_Details.getCustomer_Name()+" Welcome To E-Shopping Application");
				System.out.println();
				customerOperations();
			}
		}
		else
		{
			System.out.println("Invalid Email Id Or Password");
		}
	}
	
	Cart_Details cart_Details = new Cart_Details();
	public void customerOperations() 
	{
		boolean exit = true;
		while(exit)
		{
			System.out.println("Select One Of The Options : \n 1. For All Product Details \n 2. For Cart Details \n 3. For Order Details \n 4. To Exit Customer Operations");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("*All Product Details*");
				allProductDetails();
				break;
			case 2:
				System.out.println("*Cart Details*");
				break;
			case 3:
				System.out.println("*Order Details*");
				break;
			case 4:
				System.out.println("* Exited Customer OOperations Interface *");
				exit = false;
			default: 
				break;
			}
		}
	}
	
	public void allProductDetails()
	{
		List<Product_Details> allProductDetails = productService.allProductDetails();
		int i=1;
		for(Product_Details product_Details : allProductDetails)
		{
			System.out.println("S.No : "+i++);
			System.out.println("Product Name  : "+product_Details.getProduct_Name());
			System.out.println("Product Brand : "+product_Details.getProduct_Brand());
			System.out.println("Product Price : "+product_Details.getProduct_Price());
			System.out.println("Product Category : "+product_Details.getProduct_Category());
			System.out.println("Product Mf Date : "+product_Details.getProduct_MF_Date());
			System.out.println("Product Exp Date : "+product_Details.getProduct_Exp_Date());
			System.out.println("Product Discount : "+product_Details.getProduct_Discount());
			System.out.println("*****-----*****-----*****-----*****-----*****");
		}
		System.out.println();
		System.out.print("--> Select Product S.No To Add Into Cart Or To Buy : ");
		int selectedProduct = scan.nextInt();
		Product_Details product_Details = allProductDetails.get(selectedProduct-1);
		System.out.println();
		System.out.println("S.No : "+selectedProduct);
		System.out.println("Product Name  : "+product_Details.getProduct_Name());
		System.out.println("Product Brand : "+product_Details.getProduct_Brand());
		System.out.println("Product Price : "+product_Details.getProduct_Price());
		System.out.println("Product Category : "+product_Details.getProduct_Category());
		System.out.println("Product Mf Date : "+product_Details.getProduct_MF_Date());
		System.out.println("Product Exp Date : "+product_Details.getProduct_Exp_Date());
		System.out.println("Product Discount : "+product_Details.getProduct_Discount());
		System.out.println("------------------------------------------------------------");
		System.out.println();
		System.out.println("--> Select One Option : \n 1. To Add Product Into Cart \n 2. To Buy Product");
		switch (scan.nextInt()) {
		case 1:
			System.out.println("* Add Product Into Cart *");
			System.out.println("--> Enter The Quantity You Want To Add : ");
			int quantity = scan.nextInt();
			cart_Details.setCustomer_Id(customer_Details.getCustomer_Id());
			cart_Details.setProduct_Id(product_Details.getProduct_Id());
			cart_Details.setProduct_Quantity(quantity);
			cartService.addCartDetails(cart_Details);
			break;
		case 2:
			System.out.println("* Buying The Product *");
			System.out.println("--> Enter The Quantity You Want To Buy : ");
			int quantity1 = scan.nextInt();
			System.out.println("Product Name  : "+product_Details.getProduct_Name());
			System.out.println("Product Brand : "+product_Details.getProduct_Brand());
			System.out.println("Product Price : "+product_Details.getProduct_Price());
			System.out.println("Product Category : "+product_Details.getProduct_Category());
			double totalPrice = product_Details.getProduct_Price()*quantity1;
			System.out.println("Total Price : "+totalPrice );
			double totalDiscount = totalPrice*(product_Details.getProduct_Discount()/100);
			System.out.println("Total Discount : "+totalDiscount);
			double totalAmountToPay = totalPrice-totalDiscount;
			System.out.println("Total Amount To Be Paid : "+(totalAmountToPay));
			System.out.println("------------------------------------------------------------");
			paymentService.paymentProcessDetails(customer_Details.getCustomer_Id(), totalAmountToPay,product_Details.getProduct_Id(),quantity1,customer_Details.getCustomer_Address());
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}
	}
	
	public void getCustomerCartDetails()
	{
		List<Cart_Details> listOfCart = cartService.customerCartDetails(customer_Details.getCustomer_Id());
		int i=1;
		for(Cart_Details cart_Details : listOfCart)
		{
			
		}
	}
}
