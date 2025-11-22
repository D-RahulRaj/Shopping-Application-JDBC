package com.shopping.dto;

public class Admin_Details 
{
	private int admin_id;
	private String admin_email_id;
	private String admin_password;
	private String admin_role;
	
	public Admin_Details() {}
	public Admin_Details(int admin_id, String admin_email_id, String admin_password, String admin_role) 
	{
		this.admin_id = admin_id;
		this.admin_email_id = admin_email_id;
		this.admin_password = admin_password;
		this.admin_role = admin_role;
	}
	
	public void displayAdminDetails() 
	{
		System.out.println("********** Admin Details ***********");
		System.out.println("Admin Id : "+getAdmin_id());
		System.out.println("Admin Email : "+getAdmin_email_id());
		System.out.println("Admin Password : "+getAdmin_password());
		System.out.println("Admin Role : "+getAdmin_role());
		System.out.println();
	}
	
	public int getAdmin_id() {
		return admin_id;
	}
	public String getAdmin_email_id() {
		return admin_email_id;
	}
	public void setAdmin_email_id(String admin_email_id) {
		this.admin_email_id = admin_email_id;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}
	
	
}
