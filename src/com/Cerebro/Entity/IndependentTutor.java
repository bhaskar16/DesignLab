package com.Cerebro.Entity;
/** Author : Abhirup Mukherjee,Bhaskar Ghosh Dastidar  **/
import java.sql.*;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.Statement;
public class IndependentTutor extends Tutor {

	private String name;
	private String dob;
	private String email;
	private String contact;
	private String address;
	private String gender;
	private String discipline;
	private String subdiscipline;
	private String dayslot;
	private String timeslot;
	private int experience;
	private double remuneration;
	private String location;
	private String batch_size;
	private String description;
	private String achievements[];
	private int rating;
	private String password;
	//private Review reviews[];
	//private Contract records[];
	private long profile_id;
	private long db_id;
	private String bs;
	private String ratings;
	
	public IndependentTutor(String n,String db,String eid,String c,String add,String gen,String dis,
			String subdis,int ex,double rem,String ds,String ts,String loc,String bs,String des,String pass) throws SQLException {
		super(n,db,eid,c,add,gen,dis,subdis,ex,rem,ds,ts,loc,bs,des);
		name = n;
		dob=db;
		email=eid;
		contact =c;
		address=add;
		gender = gen;
		discipline = dis;
		subdiscipline = subdis;
		experience = ex;
		remuneration = rem;
		dayslot = ds;
		timeslot = ts;
		location = loc;
		description =des;
		password = pass;
		batch_size = bs;
	}

	
	
	public IndependentTutor() {
		// TODO Auto-generated constructor stub
		super();
	}



	public boolean createIndependentTutor(IndependentTutor a1)
	{
		if (createTutor()) {
			Connection con = null;Statement stmt = null;boolean flag = false;
			try {
				long p_id = getProfileId();
				con = /*(Statement)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
				String sql; try {
					sql = "INSERT INTO users VALUES('" + email + "','" + password + "','t')";
					stmt.executeUpdate(sql);
					sql = "INSERT INTO itutors(profile_id,email) VALUES(" + p_id + ",'" + email + "')";
					stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
					ResultSet generatedKeys = /*(Statement)*/ stmt.getGeneratedKeys();
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
	
	public boolean updateIndependent(IndependentTutor a2)
	{
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			System.out.println(a2.getEmail());
			con = /*/*(Statement)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql = "UPDATE profiles set name='"+a2.getName()+"',dob='"+a2.getdob()
			+"',contact_number='"+a2.getContact()+"',address='"+a2.getAddress()+"',discipline='"
			+a2.getDis()+"',disc_sub='"+a2.getSubDis()+"',experience="+a2.getExp()+",remuneration="
			+a2.getRem()+",day_slots='"+a2.getDS()+"',time_slots='"+a2.getTS()+"',location='"+a2.getLocation()
			+"', description='"+a2.getDesc()+"',batch_strength = '" + a2.batchSize() + "' WHERE email = '"+a2.getEmail()+"'";
			System.out.println(sql);stmt.executeUpdate(sql);
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
			} catch(SQLException se){se.printStackTrace();flag = false;}
			return flag;
		}
		
		
		
	}
	public void negotiate()
	{
		
	}
	
	public long getTutId() {
		return db_id;
	}
	
	public String getPass() {
		return password;
	}

	public IndependentTutor getPublicProfile(String email2) {
		IndependentTutor s = new IndependentTutor();
		Connection con = null;Statement stmt = null;
	 
		try {
			con = /*/*(Statement)*/ DB_SERVER.getConnection();stmt = /*(Statement)*/ con.createStatement();
			String sql; 
			try {
				sql = "select * from profiles where email='"+email2+"'";
				
				ResultSet rs = /*(Statement)*/ stmt.executeQuery(sql);
				try {
					if(rs!=null) {
					while(rs.next()) {
						name = rs.getString(2);
						dob = rs.getString(3);
						gender = rs.getString(4);
						email= email2;
						contact = rs.getString(6);
						address = rs.getString(7);
						discipline = rs.getString(8);
						subdiscipline = rs.getString(9);
						experience = Integer.parseInt(rs.getString(10));
						remuneration = Long.parseLong(rs.getString(11));
						dayslot = rs.getString(12);
						timeslot = rs.getString(13);
						location = rs.getString(14);
						bs = rs.getString(15);
						description = rs.getString(16);
						ratings = rs.getString(17);
						System.out.println(name+dob+gender);
						s = new IndependentTutor(name,dob,email,contact,address,gender,discipline,subdiscipline,experience,remuneration,dayslot,timeslot,location,bs,description,password);
						
						
						
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


}
