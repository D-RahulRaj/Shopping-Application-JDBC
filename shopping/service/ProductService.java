package com.shopping.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shopping.dao.ProductDAO;
import com.shopping.dto.Product_Details;

public class ProductService 
{
	ProductDAO productDAO = new ProductDAO();
	Product_Details product_Details=new Product_Details();
	Scanner scan=new Scanner(System.in);
	public void storeProductDetails()
	{
		System.out.println("Enter ProductName: ");
		String pName=scan.next();
		System.out.println("Enter productBrand: ");
		String pBrand=scan.next();
		System.out.println("Enter Product price: ");
		double pPrice=scan.nextDouble();
		System.out.println("Enter Mf_Date");
		String pMfDate=scan.next();
		System.out.println("Enter Exp_Date");
		String pExpDate=scan.next();
		System.out.println("Enter Product Quantity");
		int pQuantity=scan.nextInt();
		System.out.println("Enter Product Category");
		String pCategory=scan.next();
		System.out.println("Enter Product Discount");
		double pDiscount=scan.nextDouble();
		
		Product_Details product_Details=new Product_Details();
		product_Details.setProduct_Name(pName);
		product_Details.setProduct_Brand(pBrand);
		product_Details.setProduct_Price(pPrice);
		// valueOf()
		// date,argument String
		// it is one of the return type method returning the datatype is String
		product_Details.setProduct_MF_Date(Date.valueOf(pMfDate));
		product_Details.setProduct_Exp_Date(Date.valueOf(pExpDate));
		product_Details.setProduct_Quantity(pQuantity);
		product_Details.setProduct_Category(pCategory);
		product_Details.setProduct_Discount(pDiscount);
		if(productDAO.insertProductDetails(product_Details))
		{
			System.out.println("Product Added Successfully");
		}
		else {
			System.out.println("Product Not Added");
		}
	}
	
	public void storeProductsByUsingBrand()
	{
		List<Product_Details> list = new ArrayList<Product_Details>();
		System.out.println("Enter Product Brand : ");
		String pBrand = scan.next();
		System.out.println("Number Of Products Under "+pBrand+" Brand : ");
		int number = scan.nextInt();
		String num[] = {"First","Second","Third","Fourth","Fifth", "Sixth", "Seventh", "Eighth", "Ninth"
				,"Tenth", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen","Twenty"};
		for(int i=0;i<number;i++)
		{
			if((i+1)<=number)
			{
				System.out.println("Enter "+num[i]+" Product Details");
				System.out.println("Enter Product Name : ");
				String pName = scan.next();
				System.out.println("Enter Product Price : ");
				double pPrice = scan.nextDouble();
				System.out.println("Enter Mf_Date : ");
				String pMfDate=scan.next();
				System.out.println("Enter Exp_Date : ");
				String pExpDate=scan.next();
				System.out.println("Enter Product Quantity : ");
				int pQuantity=scan.nextInt();
				System.out.println("Enter Product Category : ");
				String pCategory=scan.next();
				System.out.println("Enter Product Discount : ");
				double pDiscount=scan.nextDouble();
				Product_Details product_Details=new Product_Details();
				product_Details.setProduct_Name(pName);
				product_Details.setProduct_Brand(pBrand);
				product_Details.setProduct_Price(pPrice);
				product_Details.setProduct_MF_Date(Date.valueOf(pMfDate));
				product_Details.setProduct_Exp_Date(Date.valueOf(pExpDate));
				product_Details.setProduct_Quantity(pQuantity);
				product_Details.setProduct_Category(pCategory);
				product_Details.setProduct_Discount(pDiscount);	
				list.add(product_Details);
			}
		}
		if(productDAO.insertMoreThanOneProduct(list))
		{
			System.out.println("All Products Added Successfully");
		}
		else
		{
			System.out.println("No Products Added Yet");
		}
	}
	
	public List<Product_Details> allProductDetails()
	{
		return productDAO.getAllProductDetails();
	}
}
