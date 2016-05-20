package com.Cerebro.View;

public class LogInForm {
	
	private String email;
	private String password;
	private String type;
	
	public LogInForm(String e,String pass,String t)
	{
		email= e;
		password = pass;
		type = t;
	}
	
	public boolean validateInput()
	{
		return false;
		
		
	}

}
