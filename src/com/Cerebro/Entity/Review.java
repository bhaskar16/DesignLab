package com.Cerebro.Entity;
/** Author : Bhaskar Ghosh Dastidar  **/
public class Review {

	private String body;
	private String student_name;
	private String student_email;
	private boolean is_positive;
	
	public Review(String b, String st_name, String st_email, String pos) {
	
		body = b;student_name = st_name;student_email = st_email;
		if(pos.equals("true")) is_positive = true;
		else is_positive = false;
	
	}
	public String getBody()
	{
		return body;
	}
	public String getStudent_name()
	{
		return student_name;
	}
	public String getStudentEmail()
	{
		return student_email;
	}

}

