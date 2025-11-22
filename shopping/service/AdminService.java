package com.shopping.service;

import java.util.Scanner;
import com.shopping.dao.AdminDAO;
import com.shopping.dto.Admin_Details;

public class AdminService 
{
	Scanner scan = new Scanner(System.in);
	ProductService productService = new ProductService();
	Admin_Details admin_Details = new Admin_Details();
	AdminDAO adminDAO = new AdminDAO();
	public void adminLogin()
	{
		System.out.println("Enter Admin Email Id : ");
		String emailid = scan.next();
		System.out.println("Enter Admin Password : ");
		String password = scan.next();
		if(adminDAO.selectAllAdminDetails(emailid, password)!=null)
		{	
			Admin_Details admin_Details =adminDAO.selectAllAdminDetails(emailid, password);
			System.out.println("Admin Login Successfull");
			
			boolean exit = true;
			while(exit)
			{
				System.out.println("\nSelect A Option From Below \n 1. To Insert Product Details \n 2. To Insert Products Based On Brand \n 3. To Exit Admin Operations");
				switch(scan.nextInt())
				{
				case 1:
					System.out.println("* Insert Product Details *");
					productService.storeProductDetails();
					break;
				case 2:
					System.out.println("* Insert Products Based On Brand *");
					productService.storeProductsByUsingBrand();
					break;
				case 3:
					System.out.println("* Exited From Admin Interface *");
					exit = false;
					break;
				default:
					System.out.println("Invalid");
					break;
				}
			}
		}
		else
		{
			System.out.println("Invalid Admin Credentials");
		}
	}
}
