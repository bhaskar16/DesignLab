package com.Cerebro.Entity;
/** Author : Abhirup Mukherjee,Devanjan Banerjee  **/
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.LinkedList;
import java.sql.*;
public class TutorList {
	
	public LinkedList<Tutor> searchTutors(String disc, String disc_sub, String gen, boolean ag_reg) {
		String table;if(ag_reg) { table = "(SELECT b.* from atutors as a,profiles as b"
									+" WHERE a.profile_id = b.id) as aprofiles";}
		else {table = "profiles";}String sql;if(disc == null || disc.equals("")) return null;
		else if (disc_sub == null || disc_sub.equals("")) {
			if(gen == null || gen.equals(""))
				sql = "SELECT id FROM " + table + " WHERE discipline = '" + disc + "'";
			else
				sql = "SELECT id FROM " + table + " WHERE discipline = '" + disc
					+ "' AND gender = '" + gen + "'";
		} else {
			if(gen == null || gen.equals(""))
				sql = "SELECT id FROM " + table + " WHERE discipline = '" + disc + "'"
					+ " AND disc_sub = '" + disc_sub + "'";
			else
				sql = "SELECT id FROM " + table + " WHERE discipline = '" + disc + "'"
					+ " AND disc_sub = '" + disc_sub + "' AND gender = '" + gen + "'";			
		} Connection con = null;Statement stmt = null;boolean flag = true;
		LinkedList<Tutor> t_list = new LinkedList<Tutor>();
		int count =0;
		try {
			con = DB_SERVER.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				count++;
				Tutor tut = new Tutor(rs.getLong("id")); // This constructor is Important.
				t_list.push(tut);				
			}
			System.out.println("c"+count);
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
				return null;
			} else {
				return t_list;
			}
		}	
		
	}
	
}