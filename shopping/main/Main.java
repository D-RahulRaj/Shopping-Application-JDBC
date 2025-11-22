package com.shopping.main;

import java.util.Scanner;

import com.shopping.service.AdminService;
import com.shopping.service.CustomerService;

public class Main 
{
	public static void main(String[] args) 
	{
		CustomerService customerService = new CustomerService();
		AdminService adminService = new AdminService();
		Scanner Scan = new Scanner(System.in);
		String Welcome = ">>>>>>>>>>>>>>> Welcome To Shopping Application <<<<<<<<<<<<<<";
		for(int i=0;i<=Welcome.length()-1;i++)
		{
			try {
				Thread.sleep(100);
				System.out.print(Welcome.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		boolean exit = true;
		while(exit) {
			System.out.println("\nEnter \n 1. For Admin Login \n 2. For Customer Registration \n 3. For Customer Login \n 4. To Exit");
			switch (Scan.nextInt()) {
			case 1:
				System.out.println("**Admin Login**");
				adminService.adminLogin();
				break;
			case 2:
				System.out.println("**Customer Registration**");
				customerService.customerRegistration();
				break;
			case 3:
				System.out.println("**Customer Login**");
				customerService.customerLogin();
				break;
			case 4:
				System.out.println("**Exited**");
				exit = false;
				break;
			default:
				System.err.println("Invalid Request");
				break;
			}
		} 
	}
}
