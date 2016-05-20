package com.Cerebro.Entity;
/** Author : Abhirup Mukherjee,Bhaskar Ghosh Dastidar  **/
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import com.Cerebro.Controller.MainController;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.Statement;

public class Login {

	private String password;
	private String type;
	public  void login(String eid,String pass,HttpServletRequest request,
			HttpServletResponse response)
	{
		Connection con = null;Statement stmt = null;
		 
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql;
			sql ="select password,type from users where email='"+eid+"'";
		
			
			ResultSet rs = stmt.executeQuery(sql);
			try {
				int cnt = 0;
				while(rs.next()) {
					password=rs.getString(1);
					type = rs.getString(2);
					System.out.println(type);
					cnt++;
					if(password.equals(pass))
					{
						if(type.equals("s"))
						{
							MainController control = new MainController();
							control.viewStudent(eid,request,response);
						}
						
						else if(type.equals("a"))
						{
							MainController control = new MainController();
							control.viewAgent(eid,request,response);
							}
						else if(type.equals("t"))
						{
							MainController control = new MainController();
							control.viewTutor(eid,request,response);
						}
					}
					else
					{
						System.out.println("Not authorised");
						try {
							PrintWriter out = response.getWriter();
							out.println("<script>alert(\"Invalid Password\");</script>");
							
							RequestDispatcher rd=request.getRequestDispatcher("login.html");  
							rd.include(request, response);
						} catch(IOException e) {}
					}
				}
				if(cnt != 0){
				}else {
					try {
						PrintWriter out = response.getWriter();
						out.println("<script>alert(\"Invalid Email\");</script>");
							
						RequestDispatcher rd=request.getRequestDispatcher("login.html");  
						rd.include(request, response);	
					} catch(IOException e) {}
				}
			}catch(SQLException e){}
			
	} catch(Exception e){e.printStackTrace();}
	finally {
		try{
			if(stmt!=null)
				stmt.close();
		} catch(SQLException se2){se2.printStackTrace();}
		try{
			if(con!=null)
				con.close();
		} catch(SQLException se){se.printStackTrace();}
	}
		

	}
	public boolean validate(String email, String password)
	{
		boolean valid=false;
		int p=email.lastIndexOf("@");
		int d=email.lastIndexOf(".");
		//int len=contact.length();
	    String pattern1= "^.*[a-zA-Z0-9]+.*$";
	  //  String pattern2="^[a-zA-Z]+[a-zA-Z]*$";
	  //  String pattern3="^[9,8,7]([0-9]{9})$";
	    
		if(email!="" && password!="")
		{
			 if(p>0 && d>0 && d>p)
			 {
				 if(password.matches(pattern1))
				 {
					 valid=true;
				 }
			}
			
		}
		
		return valid;
		  
	}
}
