package com.Cerebro.Entity;

/** Author : Abhirup Mukherjee,Devanjan Banerjee  **/
import java.sql.*;
import java.util.LinkedList;

import com.Cerebro.Entity.DB_SERVER;

public class ContractList {
	
	private String userType;
	private long userId;
	private Contract[] contracts;
	
	public ContractList(String uType, long uId) {
		userType = uType;userId = uId;

	}
	
	public Contract[] getOpen() {
		boolean proceed = false;String sql = null;Contract[] contracts = null;
		if(userType.equals("Tutor")) {
			sql = "SELECT * FROM contracts WHERE profile_id = " + userId
			+ " AND status IN (1,2,3) ORDER BY last_modified";
		} else if(userType.equals("student")) {
			sql = "SELECT * FROM contracts WHERE student_id = " + userId
			+ " AND status IN (1,2,3) ORDER BY last_modified";
		} else proceed = false;
		if(proceed) {
			
			System.out.println("This is important");
			LinkedList<Contract> list = null;boolean flag = false;
			Connection con = null;Statement stmt = null;
			try {
				con = DB_SERVER.getConnection();stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);list = new LinkedList<Contract>();
				while(rs.next()) {
					Contract c = new Contract(rs.getLong("id"), rs.getLong("profile_id"),
					rs.getLong("student_id"), rs.getDouble("remuneration"), rs.getString("day_slot"),
					rs.getString("time_slot"), rs.getString("location"), rs.getString("batch_size"),
					rs.getInt("status"));
					
					list.add(c);
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
				if(!flag || list == null) {
					contracts = null;
				} else {
					contracts = list.toArray(new Contract[list.size()]);
				}
			}	
		} else contracts = null;
		System.out.println("Here");
		return contracts;
	}
	
	public Contract[] getActive() {
		System.out.println("Here Active");
		boolean proceed = false;String sql = null;Contract[] contracts = null;
		if(userType.equals("Tutor")) {
			sql = "SELECT * FROM contracts WHERE profile_id = " + userId
			+ " AND status = 1 ORDER BY last_modified";
			System.out.println(sql);proceed=true;
		} else if(userType.equals("student")) {
			sql = "SELECT * FROM contracts WHERE student_id = " + userId
			+ " AND status = 1 ORDER BY last_modified";proceed= true;
		} else proceed = false;
		if(proceed) {
			System.out.println("1234");
			LinkedList<Contract> list = null;boolean flag = false;
			Connection con = null;Statement stmt = null;
			try {
				con = DB_SERVER.getConnection();stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);list = new LinkedList<Contract>();
				while(rs.next()) {
					System.out.println("Hello1234");
					Contract c = new Contract(rs.getLong("id"), rs.getLong("profile_id"),
					rs.getLong("student_id"), rs.getDouble("remuneration"), rs.getString("day_slot"),
					rs.getString("time_slot"), rs.getString("location"), rs.getString("batch_size"),
					rs.getInt("status"));
					
					
					list.add(c);
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
				if(!flag || list == null) {
					contracts = null;
				} else {
					
					contracts = list.toArray(new Contract[list.size()]);
					
				}
			}	
		} else contracts = null;
		return contracts;
	}
	
	public Contract[] getPending() {
		System.out.println("Pending starts");
		boolean proceed = false;String sql = null;Contract[] contracts = null;
		if(userType.equals("Tutor")) {
			sql = "SELECT * FROM contracts WHERE profile_id = " + userId
			+ " AND status IN (2,3) ORDER BY last_modified";
			proceed=true;
		} else if(userType.equals("student")) {
			sql = "SELECT * FROM contracts WHERE student_id = " + userId
			+ " AND status IN (2,3) ORDER BY last_modified";proceed=true;
		} else proceed = false;
		if(proceed) {
			LinkedList<Contract> list = null;boolean flag = false;
			Connection con = null;Statement stmt = null;
			try {
				con = DB_SERVER.getConnection();stmt = con.createStatement();
				System.out.println(sql);
				ResultSet rs = stmt.executeQuery(sql);list = new LinkedList<Contract>();
				while(rs.next()) {
					Contract c = new Contract(rs.getLong("id"), rs.getLong("profile_id"),
					rs.getLong("student_id"), rs.getDouble("remuneration"), rs.getString("day_slot"),
					rs.getString("time_slot"), rs.getString("location"), rs.getString("batch_size"),
					rs.getInt("status"));list.add(c);
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
				if(!flag || list == null) {
					contracts = null;
				} else {
					contracts = list.toArray(new Contract[list.size()]);
				}
			}	
		} else contracts = null;
		return contracts;
	}
	
	public Contract[] getClosed() {
		boolean proceed = true;String sql = null;Contract[] contracts = null;
		if(userType.equals("Tutor")) {
			sql = "SELECT * FROM contracts WHERE profile_id = " + userId
			+ " AND status = 4 ORDER BY last_modified";
		} else if(userType.equals("student")) {
			sql = "SELECT * FROM contracts WHERE student_id = " + userId
			+ " AND status = 4 ORDER BY last_modified";
		} else proceed = false;
		if(proceed) {
			LinkedList<Contract> list = null;boolean flag = false;
			Connection con = null;Statement stmt = null;
			try {
				con = DB_SERVER.getConnection();stmt = con.createStatement();
				System.out.println(sql);
				ResultSet rs = stmt.executeQuery(sql);list = new LinkedList<Contract>();
				while(rs.next()) {
					Contract c = new Contract(rs.getLong("id"), rs.getLong("profile_id"),
					rs.getLong("student_id"), rs.getDouble("remuneration"), rs.getString("day_slot"),
					rs.getString("time_slot"), rs.getString("location"), rs.getString("batch_size"),
					rs.getInt("status"));list.add(c);
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
				if(!flag || list == null) {
					contracts = null;
				} else {
					contracts = list.toArray(new Contract[list.size()]);
				}
			}	
		} else contracts = null;
		return contracts;
	}
	
}