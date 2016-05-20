package com.Cerebro.Entity.Test;

import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Message {
	
	private long db_id;
	private long contract_id;
	private String message;
	private Date date;
	private String direction;
	
	public Message(long dId, long cId, String msg, Date d, String dir) {
		db_id = dId;contract_id = cId;message = msg;
		direction = dir;date = new Date(d.getTime());
	}
		
	public Message(long cId, String msg, String dir) {
		
		boolean flag = false;Connection con = null;Statement stmt = null;
		String sql = "SELECT * FROM contracts WHERE id = " + cId;
		try {
			con = DB_SERVER.getConnection();stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);int cnt = 0;
			while(rs.next()) {cnt++;}
			if(cnt == 1) {
				contract_id = cId;message = msg;direction = dir;
				sql = "INSERT INTO messages(contract_id,message,direction) VALUES("
				+ cId + ",'" + msg + "','" + dir + "')";
				try {
					stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
					ResultSet generatedKeys = stmt.getGeneratedKeys();
					if (generatedKeys.next()) {db_id = generatedKeys.getLong(1);}
					else {throw new SQLException();}
				} catch(SQLException e) {
					e.printStackTrace();System.out.println();flag = false;
					System.out.println("Failed to Create Contract");System.out.println();
				} sql = "SELECT date FROM messages WHERE id = " + db_id;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				rs = stmt.executeQuery(sql);String dt = null;
				while(rs.next()){dt = sdf.format(rs.getTimestamo("date"));}
				if(dt == null) flag = false;
				else {date = sdf.parse(dt);flag = true;}
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
				db_id = 0;contract_id = 0;message = null;date = null;direction = null;
			} 
		}
		
	}
	
	public Message(Message m) {
		db_id = m.getId();contract_id = m.getContractId;message = c.getMessage();
		direction = m.getDirection();date = new Date(m.getDate());
	}

	public long getId() {return db_id;}
	
	public long getContractId() {return contract_id;}
	
	public String getMessage() {return message;}
	
	public String getDirection() {return direction;}
	
	public Date getDate() {
		Date d = new Date(date.getTime());
		return d;
	}
	
}