package com.shopping.service;

import java.util.List;

import com.shopping.dao.CartDAO;
import com.shopping.dto.Cart_Details;
import com.shopping.dto.Product_Details;

public class CartService 
{
	CartDAO cartDAO = new CartDAO();
	public void addCartDetails(Cart_Details cart_Details) 
	{
		if(cartDAO.insertCartDetails(cart_Details))
		{
			System.out.println("Product Added To The Cart");
			System.out.println();
		}
		else
			System.out.println("Server Error 500");
	}
	
	public List<Cart_Details> customerCartDetails(int c_id)
	{
		return cartDAO.selectCartDetailsUsingCustomerID(c_id);
	}

}
