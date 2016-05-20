package com.Cerebro.Entity.Test;
import java.sql.*;
import java.util.LinkedList;

import com.mysql.jdbc.ResultSet;
public class Tutor {
	
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
	private String bs;
	//private Review reviews[];
	//private Contract records[];
	private long profile_id;
	
	public Tutor(long id){
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "SELECT * FROM profiles WHERE id = " + id;
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			while(rs.next()) {
				name = rs.getString("name");dob = rs.getString("dob");email = rs.getString("email");
				contact = rs.getString("contact_number");address = rs.getString("address");
				gender = rs.getString("gender");discipline = rs.getString("discipline");
				subdiscipline = rs.getString("disc_sub");dayslot = rs.getString("day_slots");
				timeslot = rs.getString("time_slots");experience = rs.getInt("experience");
				remuneration = rs.getDouble("remuneration");location = rs.getString("location");
				batch_size = rs.getString("batch_strength");description = rs.getString("description");
				rating = rs.getInt("ratings");profile_id = id;flag = true;
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
		}
	}
	
	public Tutor(Tutor t) {
		
		name=t.name;dob=t.dob;email=t.email;contact=t.contact;address=t.address;
		gender=t.gender;discipline=t.discipline;subdiscipline=t.subdiscipline;
		dayslot=t.dayslot;timeslot=t.timeslot;experience=t.experience;
		remuneration=t.remuneration;location=t.location;batch_size=t.batch_size;
		description=t.description;rating=t.rating;profile_id=t.profile_id;
		if(t.achievements == null) achievements = null;
		else System.arraycopy(t.achievements,0,achievements,0,t.achievements.length);
		//reviews=null;records=null;
	
	}
	
	public Tutor(String n,String db,String eid,String c,String add,String gen,String dis,
				String subdis,int ex,double rem,String ds,String ts,String loc,String bs,String des) throws SQLException {
		name=n;dob=db;email=eid;contact=c;address=add;gender=gen;discipline=dis;subdiscipline=subdis;
		dayslot=ds;timeslot=ts;experience=ex;remuneration=rem;location=loc;batch_size=bs;description=des;
		rating=0;achievements=null;//reviews=null;records=null;
		Connection con = null;Statement stmt = null;
		String sql = "select id from profiles where email='"+email+"'";
		System.out.println(sql);
		boolean flag = false;
		
	
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			try {
				if(rs!=null) {
				while(rs.next()) {
					profile_id = rs.getLong(1);
				}
				}
				System.out.println("ID receieved" +profile_id);
			}
			 catch(Exception e){e.printStackTrace();flag = false;}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();flag = false;}
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){se.printStackTrace();flag = false;}
		}
		
	
			
		
	}
	
	public Tutor() {
		// TODO Auto-generated constructor stub
	}

	public long getProfileId() 
	{
		return profile_id;
	}

	public String getName()
	{
		return name;
	}
	public String getdob()
	{
		return dob;
	}

	public String getEmail()
	{
		return email;
	}

	public String getContact()
	{
		return contact;
	}

	public String getAddress()
	{
		return address;
	}

	public String getGender()
	{
		return gender;
	}

	public String getDis()
	{
		return discipline;
	}


	public String getSubDis()
	{
		return subdiscipline;
	}
	public String getDS()
	{
		return dayslot;
	}


	public String getTS()
	{
		return timeslot;
	}


	public int getExp()
	{
		return experience;
	}


	public double getRem()
	{
		return  remuneration;
	}


	public String getLocation()
	{
		return location;
	}

	public String batchSize()
	{
		return batch_size;
	}


	public String getDesc()
	{
		return description;
	}


	public String[] getAchievements()
	{
		return achievements;
	}
	
	public void createTutor()
	{
		
		Connection con = null;Statement stmt = null;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "INSERT into profiles(name,dob,email,contact_number,address,gender,"
						+"discipline,disc_sub,experience,remuneration,day_slots,time_slots,location,"
						+"batch_strength,description) VALUES('"+name+"','"+dob+"','"+email+"','"+contact+"','"+address
						+"','"+gender+"','"+discipline+"','"+subdiscipline+"',"+experience+","+remuneration+",'"+dayslot+"','"+timeslot+"','"+location
						+"','"+bs+"','"+description+"')";
			try {
				stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet generatedKeys = (ResultSet) stmt.getGeneratedKeys();
				if (generatedKeys.next()) {profile_id = generatedKeys.getLong(1);}
				else {throw new SQLException();}
			} catch(SQLException e) {
				e.printStackTrace();System.out.println();
				System.out.println("Failed to insert");System.out.println();
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
		
	}
	public boolean addAchievement(String body,long Id) {
		Connection con = null;Statement stmt = null;
		String sql = "INSERT INTO achievements(profile_id,description) VALUES("
		+ Id+ ",'" + body + "')";
		System.out.println(sql);
		boolean flag = false;
		
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			stmt.executeUpdate(sql);flag = true;
			System.out.println("Done");
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
	
	public String[] listAchievements(long Id) {
		Connection con = null;Statement stmt = null;
		String sql = "SELECT * FROM achievements WHERE profile_id = " + Id;
		System.out.println(sql);String[] test = {"Test", "Test", "Test"};
		boolean flag = false;LinkedList<String> a_list = null;
		
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			a_list = new LinkedList<String>();
			while(rs.next()) {
				System.out.println("Description: " + rs.getString("description"));
				a_list.add(rs.getString("description"));System.out.println(rs.getString("description"));	
			} flag = true;
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
			if(!flag || a_list == null) {
				System.out.println("Null Because Here");
				return null;
			} else {
				System.out.println(a_list);
				//achievements = a_list.toArray(new String[a_list.size()]);
				String[] list = a_list.toArray(new String[a_list.size()]);
				System.out.println("Hi"+list[0]);
				return list;
			} 
		}/*return test;*/
	
	}
	
public Student[] listMyStudents(long id/*String email*/) {
		
		Student[] list = null;LinkedList<Student> st_list = null;
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			/* 
			
			// In case using email of tutor
			
			String t1 = "(SELECT b.email as tut_mail, a.student_id as stud_id"
			+" FROM contracts as a, profiles as b WHERE a.profile_id = b.id) as c";
			
			String sql = "SELECT d.* FROM " + t1 + ",students as d WHERE c.stud_id = d.id"
			+" AND c.tut_mail = '" + email + "'";

			*/
			
			String sql = "SELECT b.* FROM contracts as a,students as b"
			+" WHERE a.student_id = b.id AND status = 4 AND a.profile_id = " + id/*try profile_id*/;

			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			System.out.println(sql);
			st_list = new LinkedList<Student>();
			
			while(rs.next()) { 
				Student s = new Student(rs.getString("name"), rs.getString("address"), 
							rs.getString("email"), "", rs.getString("contact_number"));
				st_list.add(s); 
			}flag = true;
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
			if(!flag || st_list == null) {
				System.out.println("Null Because Here");
				return null;
			} else {
				System.out.println(st_list);
				//achievements = a_list.toArray(new String[a_list.size()]);
				Student[] list2 = st_list.toArray(new Student[st_list.size()]);
				System.out.println("Hi"+list2[0]);
				return list2;
			} 
		}/*return test;*/
		
	}

public boolean removeStudent(String studEmail, String tutEmail) {
	Connection con = null;Statement stmt = null;
	String sql = "SELECT c.id FROM (SELECT a.* FROM contracts as a, profiles as b "
	+"WHERE a.profile_id = b.id AND a.status=4 AND b.email = '" + tutEmail/*try email*/ + "') as c, "
	+"students as d WHERE c.student_id = d.id AND d.email = '" + studEmail + "'";
	boolean flag = false;
	
	try {
		con = DB_SERVER.getConnection();stmt = con.createStatement();
		System.out.println(sql);
		ResultSet rs = (ResultSet) stmt.executeQuery(sql);String ids = "(";
		while(rs.next()) {
			ids += rs.getLong("id") + ",";			
		} if(ids.equals("(")) {flag = false;}
		else { 
			String list = ids.substring(0, (ids.length() - 1)) + ")";
			sql = "DELETE FROM messages WHERE contract_id IN " + list;
			System.out.println(sql);stmt.executeUpdate(sql);			
			sql = "DELETE FROM contracts WHERE  id IN " + list;
			System.out.println(sql);stmt.executeUpdate(sql);flag = true;
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
		System.out.println("Done Deleting");
		return flag;
	}
	
}
}






