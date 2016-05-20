package com.Cerebro.Entity;

/** Author : Abhirup Mukherjee,Bhaskar Ghosh Dastidar  **/
import java.sql.*;

import java.util.LinkedList;

import com.Cerebro.Entity.DB_SERVER;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Contract {
	
	private long db_id;
	private long profile_id;
	private long student_id;
	private String tutor_name;
	private String student_name;
	private double remuneration;
	private String dayslot;
	private String timeslot;
	private String location;
	private String batch_size;
	private int status;
		
	public Contract(long dId, long pId, long sId, double rem, String ds,
					String ts, String loc, String bs, int st) {
		
		System.out.println("Contract Constructor");
		boolean flag = true;
		db_id = dId;profile_id = pId;student_id = sId;remuneration = rem;
		dayslot = ds;timeslot = ts;location = loc;batch_size = bs;status = st;
		
		System.out.println("Dayslot" +dayslot);
		Connection con = null;Statement stmt = null;
		ResultSet rs = null;String sql = null;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			sql = "SELECT name FROM profiles WHERE id = " + profile_id;
			rs = stmt.executeQuery(sql);
			while(rs.next()) { tutor_name = rs.getString("name"); }
			sql = "SELECT name FROM students WHERE id = " + student_id;
			rs = stmt.executeQuery(sql);
			while(rs.next()) { student_name = rs.getString("name"); }			
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
			if(!flag) {
				profile_id = 0;remuneration = 0;dayslot = null;timeslot = null;
				location = null;batch_size = null;status = 0;db_id = 0;student_id = 0;
				student_name = null;tutor_name = null;
			} 
		}
		
		
		System.out.println("Created");
	}
	
	public Contract(Contract c) {
		db_id = c.getId();profile_id = c.getProfileId();student_id = c.getStudentId();
		tutor_name = c.getTutorName();student_name = c.getStudentName();
		remuneration = c.getRem();dayslot = c.getDS();timeslot = c.getTS();
		location = c.getLocation();batch_size = c.getBatchSize();
		if(c.isActive()) status = 1;
		else if(c.isProposedByTutor()) status = 2;
		else if(c.isProposedByStudent()) status = 3;
		else if(c.isFinal()) status = 3;
		else status = 0;
	}
	
	public Contract(String tut_email, long stud_id) {
		
		student_id = stud_id;status = 1;boolean flag = false;
		Connection con = null;Statement stmt = null;
		
		String sql = "SELECT * FROM profiles WHERE email = '" + tut_email + "'";
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);int cnt = 0;
			while(rs.next()) {
				profile_id = rs.getLong("id");remuneration = rs.getDouble("remuneration");
				dayslot = rs.getString("day_slots");timeslot = rs.getString("time_slots");
				location = rs.getString("location");batch_size = rs.getString("batch_strength");
				cnt++;
			} if(cnt == 1) {
				sql = "INSERT INTO contracts(profile_id,student_id,remuneration,day_slot,time_slot,"
				+ "location,batch_size,status) VALUES(" + profile_id + "," + student_id + "," 
				+ remuneration + ",'" + dayslot + "','" + timeslot + "','" + location + "','" 
				+ batch_size + "',1)";
				try {
					stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
					ResultSet generatedKeys = stmt.getGeneratedKeys();
					if (generatedKeys.next()) {db_id = generatedKeys.getLong(1);flag = true;}
					else {throw new SQLException();}
				} catch(SQLException e) {
					e.printStackTrace();System.out.println();flag = false;
					System.out.println("Failed to Create Contract");System.out.println();
				}
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
			if(!flag) {
				profile_id = 0;remuneration = 0;dayslot = null;timeslot = null;
				location = null;batch_size = null;status = 0;db_id = 0;student_id = 0;
			} 
		}
		
	}
	public Contract()
	{
		
	}

	public Message[] getAllMessages(long Cid) {
		Message[] messages = null;LinkedList<Message> list = null;
		boolean flag = false;Connection con = null;Statement stmt = null;
		String sql = "SELECT * FROM messages WHERE contract_id = " + Cid + " ORDER BY date";
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);list = new LinkedList<Message>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			while(rs.next()) {
				Date d = rs.getTimestamp("date");Date dt = sdf.parse(sdf.format(d));
				Message m = new Message(rs.getLong("id"),rs.getLong("contract_id"),
				rs.getString("message"),dt,rs.getString("direction"));list.add(m);
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
				return null;
			} else {
				messages = list.toArray(new Message[list.size()]);
				return messages;
			}
		}	
	}
	
	public boolean cancel() {
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "SELECT status FROM contracts WHERE id = " + db_id;
			ResultSet rs = stmt.executeQuery(sql);boolean proceed = true;
			while(rs.next()) {
				int st = rs.getInt("status");
				if(st != 1) proceed = false;
			} if(proceed) {
				sql = "DELETE FROM messages WHERE contract_id = " + db_id;stmt.executeUpdate(sql);
				sql = "DELETE FROM contracts WHERE id = " + db_id;stmt.executeUpdate(sql);flag = true;
			} else {flag = false;}
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
			System.out.println("Done");
			return flag;
		}
	}

	public boolean proposeClosure(long id) {
		System.out.println(id);
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "SELECT * FROM contracts WHERE id = " + db_id;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);boolean proceed = true;
			long pId =0, sId = 0;int st = 0, newSt = 0;
			while(rs.next()) {
				pId = rs.getLong("profile_id");sId = rs.getLong("student_id");
				st = rs.getInt("status");
			} if(pId == id && st == 1) {newSt = 2;}
			else if(sId == id && st == 1) {newSt = 3;}
			
			if(proceed) {
				
				System.out.println("Now");
				sql = "UPDATE contracts SET status = " + newSt + " WHERE id = " + db_id;
				stmt.executeUpdate(sql);flag = true;
				System.out.println(sql);
			} else {flag = false;}
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
	
	public boolean acceptClosure(long id) {
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "SELECT * FROM contracts WHERE id = " + db_id;
			ResultSet rs = stmt.executeQuery(sql);boolean proceed = true;
			long pId =0, sId = 0;int st = 0, newSt = 0;
			while(rs.next()) {
				pId = rs.getLong("profile_id");sId = rs.getLong("student_id");
				st = rs.getInt("status");
			} if(pId == id && st == 3) {newSt = 4;}
			else if(sId == id && st == 2) {newSt = 4;}
			else proceed = false;
			if(proceed) {
				sql = "UPDATE contracts SET status = " + newSt + " WHERE id = " + db_id;
				stmt.executeUpdate(sql);flag = true;
			} else {flag = false;}
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
	
	public boolean rejectClosure(long id) {
		Connection con = null;Statement stmt = null;boolean flag = false;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "SELECT * FROM contracts WHERE id = " + db_id;
			ResultSet rs = stmt.executeQuery(sql);boolean proceed = true;
			long pId =0, sId = 0;int st = 0, newSt = 0;
			while(rs.next()) {
				pId = rs.getLong("profile_id");sId = rs.getLong("student_id");
				st = rs.getInt("status");
			} if(st == 2 || st == 3) {newSt = 1;}
			else proceed = false;
			if(proceed) {
				sql = "UPDATE contracts SET status = " + newSt + " WHERE id = " + db_id;
				stmt.executeUpdate(sql);flag = true;
			} else {flag = false;}
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
	
	public boolean updateContract(double rem, String ds, String ts, String loc, String bs, long tut_id,long cID) {
		Connection con = null;Statement stmt = null;boolean flag = false;
		System.out.println("hey ");
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "SELECT * FROM contracts WHERE profile_id = " + tut_id;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);boolean proceed = false;long id = 0;int st = 0;
			while(rs.next()) {
				id = rs.getLong("id");st = rs.getInt("status");
				if(cID == id && st == 1) {
					proceed = true;
					System.out.println("hey "+proceed);
					break;
				}
			} if(proceed) {
				sql = "UPDATE contracts SET remuneration = " + rem + ",day_slot = '" + ds
				+ "',time_slot = '" + ts + "',location = '" + loc + "',batch_size = '" + bs
				+ "' WHERE id = " + cID;stmt.executeUpdate(sql);flag = true;
				System.out.println(sql);
			} else {flag = false;}
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
	
	public long getId() {return db_id;}
	
	public long getProfileId() {return profile_id;}
	
	public long getStudentId() {return student_id;}
	
	public String getTutorName() {return tutor_name;}
	
	public String getStudentName() {return student_name;}
	
	public double getRem() {return remuneration;}
	
	public String getDS() {return dayslot;}
	
	public String getTS() {return timeslot;}
	
	public String getLocation() {return location;}
	
	public String getBatchSize() {return batch_size;}
	
	public boolean isActive() {if(status == 1) return true; else return false;}
	
	public boolean isProposedByTutor() {if(status == 2) return true; else return false;}
	
	public boolean isProposedByStudent() {if(status == 3) return true; else return false;}
	
	public boolean isFinal() {if(status == 4) return true; else return false;}
	
	public int getStatus() {return status;}
	
}