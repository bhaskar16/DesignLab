package com.Cerebro.Entity;
/** Author : Abhirup Mukherjee,Bhaskar Ghosh Dastidar  **/
import java.sql.*;

public class DB_SERVER {
	
	// JDBC driver name and database URL
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private static final String DB_URL = "jdbc:mysql://127.0.0.1/tutandstud";

	
	//private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	//private static final String DB_URL = "jdbc:mysql://127.10.90.130/tutandstud";
	
	
   //  Database credentials
   private static final String USER = "root";
   private static final String PASS = "";
   
   // Static block to Register Driver
   static {
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		} catch(Exception e){
			e.printStackTrace();
		}
   }

   public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch(Exception e) {e.printStackTrace();return null;}
   }
	
}