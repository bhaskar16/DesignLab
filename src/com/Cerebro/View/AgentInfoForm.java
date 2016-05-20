package com.Cerebro.View;

public class AgentInfoForm {
	
	private String agencyName;
	private String address;
	private String contactPerson;	
	private String contact;
	private String email;
	private String password;
	
	public AgentInfoForm(String an,String add,String cp,String c,String e,String pass)
	{
		agencyName = an;
		address = add;
		contactPerson = cp;
		contact = c;
		email = e;
		password = pass;
	}
	
	public String getAgency()
	{
		return agencyName;
	
	}

	public String getAddress()
	{
		return address;
	
	}
	
	public String getContactPerson()
	{
		return contactPerson;
	
	}
	
	public String getContact()
	{
		return contact;
	
	}
	
	public String getEmail()
	{
		return email;
	
	}
	
	public String getPass()
	{
		return password;
	
	}
}
