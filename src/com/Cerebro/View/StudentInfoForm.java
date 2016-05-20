package com.Cerebro.View;

public class StudentInfoForm {
	
	private String name;
	private String address;
	private String email;
	private String contact;
	private String password;
	
	public StudentInfoForm(String n,String add,String e,String c,String p)
	{
		name= n;
		address= add;
		email = e;
		contact = c;
		password = p;
	}
	
	public String getName() {
		return name;
	}
	
	public String getaddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getContact() {
		return contact;
	}
	
	public String getPassword() {
		return password;
	}
}
