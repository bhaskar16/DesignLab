package com.Cerebro.Entity;
/** Author : Bhaskar Ghosh Dastidar  **/
import java.sql.*;
import java.util.LinkedList;

//import com.mysql.jdbc.ResultSet;

public class RateAndReview {
	
	
	String TutorEmail;
	String StudentEmail;
	int rate;
	String body;
	boolean isPositive;
	
	
	
	public void setTutor(String TEmail)
	{
		TutorEmail = TEmail;
	}
	public void setisPos(boolean flag)
	{
		isPositive = flag;
	}
	
	public void setStudent(String SEmail)
	{
		StudentEmail = SEmail;
	}
	
	public void setReviewbody(String b)
	{
		body=b;
	}
	
	public void setRating(int r)
	{
		rate = r;
	}
	
	public void rate()
	{
		System.out.println("Submitting rating to DB");
		
	}
	
	
	
	public void setReview()
	{
		Connection con = null;Statement stmt = null;ResultSet rs = null;String sql = null;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			sql = "SELECT id,ratings,rate_count FROM profiles WHERE email = '" + TutorEmail + "'";
			rs = stmt.executeQuery(sql);long tutId = -1;int ratings = 0, rating_count = 0;
			while(rs.next()) {
				tutId = rs.getLong("id");
				ratings = rs.getInt("ratings");
				rating_count = rs.getInt("rate_count");
			} sql = "SELECT id FROM students WHERE email = '" + StudentEmail + "'";
			
			rs = stmt.executeQuery(sql);long studId = -1;
			while(rs.next()) {
				studId = rs.getLong("id");
			} if(tutId != -1 && studId != -1) {
				sql = "INSERT INTO reviews(profile_id,student_id,body,is_positive) VALUES("
				+ tutId + "," + studId + ",'" + body + "','"+isPositive+"')";
				stmt.executeUpdate(sql);
				int newRate = (((ratings * rating_count) + rate)/(rating_count + 1));
				sql = "UPDATE profiles SET ratings = " + newRate + ",rate_count = " + (rating_count + 1)
				+ " WHERE id = " + tutId;
				System.out.println(sql);stmt.executeUpdate(sql);
				
			} else {
				System.out.println("Invalid Id's detected");
			}
		} catch(Exception e){e.printStackTrace();}
		finally {
			System.out.println("Reviewed! Thanks");
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();}
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){se.printStackTrace();}
		}
	}

	public Review[] getVerifiedReviews(String TEmail) {

		Review[] reviews = null;LinkedList<Review> list = null;boolean flag = false;
		Connection con = null;Statement stmt = null;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String subtable = "(SELECT a.*,b.email as tutmail FROM reviews as a, profiles as b"
					+ " WHERE a.profile_id = b.id) as c";
			String table = "(SELECT c.*, d.name as student_name, d.email as student_email"
						+ " FROM " + subtable + ", students as d WHERE c.student_id = d.id"
						+ " AND c.tutmail = '" + TEmail + "') as e";
			String sql = "SELECT e.* FROM " + table + ", contracts as f WHERE e.profile_id = f.profile_id "
						+ "AND e.student_id = f.student_id AND f.status = 4 ORDER BY e.date DESC";
			System.out.println("Q: "+sql);
			ResultSet rs = stmt.executeQuery(sql);
			list = new LinkedList<Review>();
			while(rs.next()) {
				Review r = new Review(rs.getString("body"), rs.getString("student_name"),
									rs.getString("student_email"), rs.getString("is_positive"));
				list.add(r);
			} if(list.size() > 0) {
				reviews = list.toArray(new Review[list.size()]);flag = true;
			}
		} catch(Exception e){e.printStackTrace();flag = false;}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();}
			try{
				if(con!=null)
					con.close();
			} catch(SQLException se){se.printStackTrace();}
			if(!flag) {
				return null;
			} else {
				return reviews;
			}
		}

	}
	
	public Review[] getReviews(String TEmail) {

		Review[] reviews = null;LinkedList<Review> list = null;boolean flag = false;
		Connection con = null;Statement stmt = null;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String table = "(SELECT a.*,b.email as tutmail FROM reviews as a, profiles as b"
					+ " WHERE a.profile_id = b.id) as c";
	String sql = "SELECT c.*, d.name as student_name, d.email as student_email"
				+ " FROM " + table + ", students as d WHERE c.student_id = d.id"
				+ " AND c.tutmail = '" + TEmail + "' ORDER BY c.date DESC";
			System.out.println("Q: "+sql);
			ResultSet rs = stmt.executeQuery(sql);
			list = new LinkedList<Review>();
			while(rs.next()) {
				Review r = new Review(rs.getString("body"), rs.getString("student_name"),
									rs.getString("student_email"), rs.getString("is_positive"));
				list.add(r);
			} if(list.size() > 0) {
				reviews = list.toArray(new Review[list.size()]);flag = true;
			}
		} catch(Exception e){e.printStackTrace();flag = false;}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();}
			try{
				if(con!=null)
					con.close();
			} catch(SQLException se){se.printStackTrace();}
			if(!flag) {
				return null;
			} else {
				return reviews;
			}
		}

	}
	
	public Review[] getUnverifiedReviews(String TEmail) {

		Review[] reviews = null;LinkedList<Review> list = null;boolean flag = false;
		Connection con = null;Statement stmt = null;
		try {
			String s1 = "(SELECT a.*,b.email as tutmail FROM reviews as a, profiles as b"
					+ " WHERE a.profile_id = b.id) as c";
			String t1 = "(SELECT c.*, d.name as student_name, d.email as student_email"
						+ " FROM " + s1 + ", students as d WHERE c.student_id = d.id"
						+ " AND c.tutmail = '" + TEmail + "') as e";
			String subsql = "(SELECT e.id FROM " + t1 + ", contracts as f WHERE e.profile_id = f.profile_id "
						+ "AND e.student_id = f.student_id AND f.status = 4)";
			String subtable = "(SELECT h.*,i.email as tutmail FROM reviews as h, profiles as i"
					+ " WHERE a.profile_id = b.id) as j";
			String table = "(SELECT j.*, k.name as student_name, k.email as student_email"
						+ " FROM " + subtable + ", students as k WHERE j.student_id = k.id"
						+ " AND j.tutmail = '" + TEmail + "') as l";
			String sql = "SELECT l.* FROM " + table + " WHERE l.id NOT IN " + subsql;
			System.out.println("Q: "+sql);
			ResultSet rs = stmt.executeQuery(sql);
			list = new LinkedList<Review>();
			while(rs.next()) {
				Review r = new Review(rs.getString("body"), rs.getString("student_name"),
									rs.getString("student_email"), rs.getString("is_positive"));
				list.add(r);
			} if(list.size() > 0) {
				reviews = list.toArray(new Review[list.size()]);flag = true;
			}
		} catch(Exception e){e.printStackTrace();flag = false;}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();}
			try{
				if(con!=null)
					con.close();
			} catch(SQLException se){se.printStackTrace();}
			if(!flag) {
				return null;
			} else {
				return reviews;
			}
		}

	}

	public int getRating(String TEmail) {

		int rate = 0;Connection con = null;Statement stmt = null;boolean flag=false;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			String sql = "SELECT ratings FROM profiles WHERE email = '" + TEmail+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				rate = rs.getInt("ratings");
			}
		} catch(Exception e){e.printStackTrace();flag = false;}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){se2.printStackTrace();}
			try{
				if(con!=null)
					con.close();
			} catch(SQLException se){se.printStackTrace();}
			return rate;
		}
	}
}
