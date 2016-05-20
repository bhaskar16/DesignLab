package com.Cerebro.Entity;

import java.sql.*;



/** Author : Abhirup Mukherjee,Bhaskar Ghosh Dastidar  **/


public class AgentRegisteredTutor extends Tutor {
	private long a_id;
	private long db_id;
	private long agent_id;
	
	public AgentRegisteredTutor(String n,String db,String eid,String c,String add,String gen,String dis,
			String subdis,int ex,double rem,String ds,String ts,String loc,String bs,String des,long a_id) throws SQLException {

		super(n,db,eid,c,add,gen,dis,subdis,ex,rem,ds,ts,loc,bs,des);
		this.a_id = a_id; 
	}
	
	public AgentRegisteredTutor() {
		// TODO Auto-generated constructor stub
	}

	public void getPublicProfile()
	{
		
	}
	
	
	public boolean createAgentRegisteredTutor()
	{
		if(createTutor()) {
			Connection con = null;Statement stmt = null;boolean flag = false;
			try {
				
				long p_id = getProfileId();agent_id = a_id;
				con = /*(Statement)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
				String sql; try {
					sql = "INSERT INTO atutors(profile_id,agent_id) VALUES(" + p_id + "," + a_id + ")";
					stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
					ResultSet generatedKeys = stmt.getGeneratedKeys();
					System.out.println("Here");
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
		} else return false;
		
	}
	
	public boolean removeMe(String email)
	{
		System.out.println("Running Db queries for "+email+" .. Removed.");
		return true;
		
	}
	
	public boolean updateAgent(AgentRegisteredTutor a2)
	{
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			System.out.println(a2.getEmail());
			con = /*(Statement)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql = "UPDATE profiles set name='"+a2.getName()+"',dob='"+a2.getdob()
			+"',contact_number='"+a2.getContact()+"',address='"+a2.getAddress()+"',discipline='"
			+a2.getDis()+"',disc_sub='"+a2.getSubDis()+"',experience="+a2.getExp()+",remuneration="
			+a2.getRem()+",day_slots='"+a2.getDS()+"',time_slots='"+a2.getTS()+"',location='"+a2.getLocation()
						+"', description='"+a2.getDesc()+"' WHERE email = '"+a2.getEmail()+"'";
			System.out.println(sql);
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
			} catch(SQLException se){se.printStackTrace();flag = false;}
			return flag;
		}
		
	}

}
