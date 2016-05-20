package com.Cerebro.Controller;
/** Author : Bhaskar Ghosh Dastidar  **/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Cerebro.Entity.*;
import com.Cerebro.View.*;
public class Registration extends HttpServlet {
	
	
	private String type;
	private String name;
	private String dob;
	private String email;
	private String pass;
	private String contact;
	private String address;
	private String discipline;
	private String subdiscipline;
	private String dayslot;
	private String timeslot;
	private int experience;
	private double remuneration;
	private double remuneration1;
	private double remuneration2;
	private String location;
	private String description;
	private String achievements[];
	private String agencyName;
	private String contactPerson;	
	private String contactNumber;
	private String gender;
	private String bs;
	private long aID;

	private MainController control;
	PrintWriter out ;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	type = request.getParameter("type");
	if (type.equals("Student"))
	{
		name = request.getParameter("name"); 
		address= request.getParameter("address");
		email = request.getParameter("email");
		pass = request.getParameter("pass");
		contact = request.getParameter("contact");
		
		boolean done = control.registerStudent(name,address,email,pass,contact);
		if(done) {
			out = response.getWriter();
			out.println("<script>alert(\"Student Registered Successfully\");</script>");
			//response.sendRedirect("login.html");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			 rd.include(request, response);
			 
			
		} else {
			out = response.getWriter();
			out.println("<script>alert(\"Registration Failed\");</script>");
			
			  //response.sendRedirect("login.html");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("login.html");  
			 rd.include(request, response);
			 
		}
		  
	}
	else if (type.equals("Tutor"))
	{
		
		HttpSession session=request.getSession();long aID = 0;
		try {
			aID = Long.parseLong(session.getAttribute("AgentID").toString());
		} catch(Exception e) {}
		name=request.getParameter("name");
		gender = request.getParameter("gender");
		System.out.println("gender "+gender);
		dob=request.getParameter("db");
		email=request.getParameter("email");
		contact=request.getParameter("contact");
		address=request.getParameter("address");
		discipline=request.getParameter("discipline");
		subdiscipline=request.getParameter("subdiscipline");
		dayslot=request.getParameter("DS");
		timeslot=request.getParameter("TS");
		experience=Integer.parseInt(request.getParameter("exp"));
		remuneration1=Long.parseLong(request.getParameter("remunerationl"));
		remuneration2=Long.parseLong(request.getParameter("remunerationh"));
		remuneration = (remuneration1+remuneration2)/2;
		System.out.println("Final value "+remuneration);
		location=request.getParameter("location");
		description=request.getParameter("desc");
		pass = request.getParameter("pass");
		bs =request.getParameter("bs");		
		control = new MainController();
		System.out.println(bs);
		if(aID==0){
			boolean done = false;
			try {
				done = control.registerIndependantTutor(name,dob,email, contact,address, gender,discipline,subdiscipline,dayslot,timeslot, experience,remuneration,location,bs,description,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();done = false;
			} if(done) {
				out = response.getWriter();
				out.println("<script>alert(\"Tutor Registered Successfully\");</script>");
				//response.sendRedirect("login.html");
				 
				 RequestDispatcher rd=request.getRequestDispatcher("login.html");  
				 rd.include(request, response);
				 
			} else {
				out = response.getWriter();
				out.println("<script>alert(\"Registration Failed\");</script>");
				
				  //response.sendRedirect("login.html");
				 
				 RequestDispatcher rd=request.getRequestDispatcher("login.html");  
				 rd.include(request, response);
				 
			}
		} 
		else
		{
			boolean done = false;
			try {
				done = control.registerAgentTutor(name,dob,email, contact,address, gender,discipline,subdiscipline,dayslot,timeslot, experience,remuneration,location,bs,description,aID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();done = false;
			} if(done) {
				out = response.getWriter();
				out.println("<script>alert(\"Tutor Registered Successfully\");</script>");
				
				  //response.sendRedirect("AgencyDashboard.jsp");
				 
				 RequestDispatcher rd=request.getRequestDispatcher("AgencyDashboard.jsp");  
				 rd.include(request, response);
				 
			} else {
				out = response.getWriter();
				out.println("<script>alert(\"Registration Failed\");</script>");
				//response.sendRedirect("AgencyDashboard.jsp");
				 
				 RequestDispatcher rd=request.getRequestDispatcher("AgencyDashboard.jsp");  
				 rd.include(request, response);
				 
			}
		}
	}
	else if (type.equals("Agent"))
	{
		
		agencyName=request.getParameter("agencyName");
		address=request.getParameter("address");
		contactPerson = request.getParameter("contactPerson");
		contactNumber = request.getParameter("contactNumber");
		email = request.getParameter("email");
		pass = request.getParameter("pass");
		
		
		control = new MainController();
		boolean done = control.registerAgent(agencyName,address,contactPerson,contactNumber,email,pass);
		if(done) {
			out = response.getWriter();
			out.println("<script>alert(\"Agent Registered Successfully\");</script>");
			//response.sendRedirect("login.html");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("login.html");  
			 rd.include(request, response);
			 
		} else {
			out = response.getWriter();
			out.println("<script>alert(\"Registration Failed\");</script>");
			response.sendRedirect("login.html");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("login.html");  
			 rd.include(request, response);
			 
		} 
	}
	
	else if(type.equals("login"))
	{
		control = new MainController();
		control.login(request.getParameter("email"),request.getParameter("pass"),request,response);
	}
	
	}
		
	}


