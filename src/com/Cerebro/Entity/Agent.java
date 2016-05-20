package com.Cerebro.Entity;

import java.sql.*;
import java.util.LinkedList;

import com.Cerebro.View.AgentInfoForm;


/** Author : Devanjan banerjee, Abhirup Mukherjee  **/
public class Agent {
	
	
	private String agencyName;
	private String address;
	private String contactPerson;	
	private String contactNumber;
	private String email;
	private long db_id;
	private String password;
	
	public Agent (String an,String add,String cp,String cn,String e,String p)
	{
		agencyName=an;
		address=add;
		contactPerson = cp;
		contactNumber = cn;
		email = e;
		password = p;
	}
	public Agent (String an,String add,String cp,String cn,String e,String p,Long id)
	{
		agencyName=an;
		address=add;
		contactPerson = cp;
		contactNumber = cn;
		email = e;
		password = p;
		db_id=id;
	}
	
	public String getAgentName()
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
		return contactNumber;
	}
	
	public String getEmail()
	{
		return email;
			
	}
	
	public String getPass()
	{
		return password;		
	}
	
	
	private void setID(long id)
	{
		db_id = id;
		System.out.println(db_id);
	}
	
	public long getID()
	{
		return db_id;
	}
	
	public Agent() {
		// TODO Auto-generated constructor stub
	}

	public boolean createAgent(Agent a1)
	{
		Connection con = null;Statement stmt = null;boolean flag = false;
		 
		try {
			con = /*(ResultSet)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql = "SELECT * FROM users WHERE email = '" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) throw new Exception(); 
			try {
				sql = "INSERT INTO users VALUES('" + email + "','" + password + "','a')";
				stmt.executeUpdate(sql);
				sql = "INSERT INTO agents (agency_name, contact_person, contact_number, email) values ('"+ agencyName + "','" + contactPerson + "','" + contactNumber + "','" + email + "')";
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
	
	public boolean updateAgent(Agent a2)
	{
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = /*(ResultSet)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql = "UPDATE agents SET agency_name = '" + a2.getAgentName() + "',contact_person = '"
			+ a2.getContactPerson() + "',contact_number = '" + a2.getContact()
			+ "' WHERE email = '" + a2.getEmail() + "'";stmt.executeUpdate(sql);
			sql = "UPDATE users SET password = '" + a2.getPass() + "' WHERE email = '" + a2.getEmail() + "'";
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

public Tutor[] listMyTutors(String AgencyName) {
	Connection con = null;Statement stmt = null;
		Tutor[] list = null;
		LinkedList<Tutor> t_list = null;
		boolean flag = false;
		
		String t1 = "(SELECT b.* FROM agents as a,atutors as b WHERE a.id = b.agent_id AND a.agency_name = '"
					+ AgencyName + "') as t1";
		
		String table = t1 + ",profiles as t2 WHERE t1.profile_id=t2.id";
		String sql = "SELECT t2.* FROM " + table;
		try {
			con = /*(ResultSet)*/ DB_SERVER.getConnection();
			stmt = /*(Statement)*/ con.createStatement();
			ResultSet rs = /*(ResultSet)*/ stmt.executeQuery(sql);
			t_list = new LinkedList<Tutor>();
			while(rs.next()) {
				Tutor t = new Tutor(rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(4),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getDouble(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));			
				
				t_list.add(t);
			} flag = true;
		} catch(Exception e){e.printStackTrace();}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();}
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){se.printStackTrace();}
			if(!flag || t_list == null) {
				return null;
			} else {
				list = t_list.toArray(new Tutor[t_list.size()]);
				return list;
			}
		}
		
		
	}
		
		
		
	
	public Agent getPublicProfile(String eid)
	{	
		Agent s = new Agent();
		Connection con = null;Statement stmt = null;
	 
		try {
			con = /*(ResultSet)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql; 
			try {
				sql = "select * from agents where email='"+eid+"'";
				
				ResultSet rs = /*(ResultSet)*/ stmt.executeQuery(sql);
				try {
					if(rs!=null) {
					while(rs.next()) {
						agencyName = rs.getString(2);
						email = rs.getString(5);
						contactPerson = rs.getString(3);
						contactNumber = rs.getString(4);
						db_id = rs.getLong(1);
						setID(db_id);
						s = new Agent(agencyName, address, contactPerson,contactNumber, email, password,db_id);
						
						
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
	public boolean removeTutor(String email, long ag_id) {
	{
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = /*(ResultSet)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql = "SELECT a.agent_id as agent_id, b.* FROM atutors as a, profiles as b WHERE  a.profile_id = b.id AND b.email = '" + email + "'";
			ResultSet rs = /*(ResultSet)*/ stmt.executeQuery(sql);long a_id = -1, tut_id = -1;while(rs.next()){a_id = rs.getLong("agent_id");tut_id = rs.getLong("id");}
			if(a_id == ag_id) {
				sql = "DELETE FROM reviews WHERE profile_id = " + tut_id;System.out.println(sql);
				stmt.executeUpdate(sql);sql = "DELETE FROM achievements WHERE profile_id = " + tut_id;
				
				stmt.executeUpdate(sql);sql = "SELECT id FROM contracts WHERE profile_id = " + tut_id;
				ResultSet cont = /*(ResultSet)*/ stmt.executeQuery(sql);String contractString = "(";
				while(cont.next()) {
					contractString += cont.getLong("id") + ",";
				} contractString = contractString.substring(0,(contractString.length()-1)) + ")";
				if(!contractString.equals(")")) {
					sql = "DELETE FROM messages WHERE contract_id IN " + contractString;stmt.executeUpdate(sql);
					stmt.executeUpdate(sql);sql = "DELETE FROM contracts WHERE profile_id = " + tut_id;stmt.executeUpdate(sql);
				} sql = "DELETE FROM atutors WHERE profile_id = " + tut_id;stmt.executeUpdate(sql);
				sql = "DELETE FROM profiles WHERE id = " + tut_id;stmt.executeUpdate(sql);flag = true;
		//	System.out.println("Deleted");
			} else {
				flag = false;
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
			}catch(SQLException se){se.printStackTrace();flag = false;}
			return flag;
		}
	}

		
	
	
		

		
		
	}
	public boolean validate()
	{
		boolean valid=false;
		int p=email.lastIndexOf("@");
		int d=email.lastIndexOf(".");
		//int len=contactNumber.length();
	    String pattern1= "^.*[a-zA-Z0-9]+.*$";
	    String pattern2="^[a-zA-Z]+[a-zA-Z]*$";
	    String pattern3="^[9,8,7]([0-9]{9})$";
	    
		if(agencyName!="" && address!="" &&  email!="" && password!="" && contactNumber!="" && contactPerson!="")
		{
			 if(p>0 && d>0 && d>p)
			 {
				 if(password.matches(pattern1) && agencyName.matches(pattern2) && contactNumber.matches(pattern3))
				 {
					 valid=true;
				 }
			}
			
		}
		
		return valid;
	}
	
	
}
