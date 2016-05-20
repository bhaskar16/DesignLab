package com.Cerebro.Entity;
/** Author : Abhirup Mukherjee,Devanjan Banerjee **/
import java.sql.*;

import com.Cerebro.View.StudentInfoForm;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.Statement;

public class Student {
	
	private String name;
	private String address;
	private String email;
	private String contact;
	private String pass;
	private long db_id;
	
	public Student(String n,String add,String e,String p,String c)
	{
		name = n;
		address= add;
		email = e;
		pass = p;
		contact = c;
	}
	public Student(Long id,String n,String add,String e,String p,String c)
	{
		db_id=id;
		name = n;
		address= add;
		email = e;
		pass = p;
		contact = c;
	}
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}



	public long getId() 
	{
	    return db_id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAdd()
	{
		return address;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getContact()
	{
		return contact;
	}
	
	public String getPass()
	{
		return pass;
	}
	
	public Student getPublicProfile(String eid)
	{	
		Student s = new Student();;
		Connection con = null;Statement stmt = null;
	 
		try {
			con = /*(Connection)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql; 
			try {
				sql = "select * from students where email='"+eid+"'";
				
				ResultSet rs = /*(ResultSet)*/ stmt.executeQuery(sql);
				try {
					if(rs!=null) {
					while(rs.next()) {
						name = rs.getString(2);
						email = rs.getString(3);
						address = rs.getString(4);
						contact = rs.getString(5);
						db_id = rs.getLong(1);
						s = new Student(db_id,name, address, email, pass, contact);
						System.out.println("--------------");
						System.out.println(s.address+s.name);
						
					}
					}
				}catch(SQLException e){}
				
			} catch(SQLException e) {
				e.printStackTrace();System.out.println();
				System.out.println("Failed to run query");System.out.println();
			
		} 
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
		return s;
		
	}
	
	public boolean createStudent(Student s1)
	{
		
		Connection con = null;Statement stmt = null;boolean flag = false;
		 
			try {
				con = /*(Connection)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
				String sql = "SELECT * FROM users WHERE email = '" + email + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) throw new Exception();
				try {
					sql = "INSERT INTO users VALUES('" + email + "','" + pass + "','s')";
					stmt.executeUpdate(sql);
					sql = "INSERT INTO students(name,email,address,contact_number) VALUES('"
					+ name + "','" + email + "','" + address + "','" + contact + "')";
					stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
					ResultSet generatedKeys = /*(ResultSet)*/ stmt.getGeneratedKeys();
					if (generatedKeys.next()) {db_id = generatedKeys.getLong(1);flag = true;}
					else {throw new SQLException();}
				} catch(SQLException e) {
					e.printStackTrace();System.out.println();flag = false;
					System.out.println("Failed to insert");System.out.println();
				
			} 
		} catch(Exception e){e.printStackTrace();flag = false;}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();flag = false;}
			try{
				if(con!=null)
					con.close();
			} catch(SQLException se){se.printStackTrace();flag = false;}
			return flag;
		}
	}
		
	
	
	public boolean updateStudent(Student s2)
	{
		
System.out.println(s2.getEmail());
		Connection con = null;Statement stmt = null;boolean flag = false;
		String n = s2.getName(), cn = s2.getContact(), add = s2.getAdd(), p = s2.getPass();
		try {
			con = /*(Connection)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql = "UPDATE students SET name = '" + n + "',contact_number = '"
			+ cn + "',address = '" + add + "' WHERE email = '" + s2.getEmail() + "'";
			stmt.executeUpdate(sql);
			sql = "UPDATE users SET password = '" + p + "' WHERE email = '" + s2.getEmail() + "'";
			stmt.executeUpdate(sql);flag = true;
		} catch(Exception e){e.printStackTrace();flag = false;}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();flag = false;}
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){se.printStackTrace();flag = false;}
			return flag;
		}		
	}
	
	public void authenticateMe()
	{
		
		System.out.println("Running Login DB quesries. Success");
		
	}
	public void negotiate()
	{
		
	}
	
	public boolean validate()
	{
		boolean valid=false;
		int p=email.lastIndexOf("@");
		int d=email.lastIndexOf(".");
		int len=contact.length();
	    String pattern1= "^.*[a-zA-Z0-9]+.*$";
	    String pattern2="^[a-zA-Z]+[a-zA-Z]*$";
	    String pattern3="^[9,8,7]([0-9]{9})$";
	    
		if(name!="" && address!="" &&  email!="" && pass!="" && contact!="")
		{
			 if(p>0 && d>0 && d>p)
			 {
				 if(pass.matches(pattern1) && name.matches(pattern2) && contact.matches(pattern3))
				 {
					 valid=true;
				 }
			}
			
		}
		
		return valid;  
	}
	
}
