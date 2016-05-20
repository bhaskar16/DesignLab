package com.Cerebro.Controller;

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

public class ManageTutors extends HttpServlet {
	private String gender;
	private String type ;
	private Long aid;
	private String bs;
	private String email;
	private String name;
	private String dob;
	private MainController control;
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		type = request.getParameter("type");
		if (type.equals("listtutors"))
		{
			HttpSession session=request.getSession();  
			String AgencyName = session.getAttribute("Name").toString();
			System.out.println("Name Agent "+AgencyName);
			control = new MainController();
			Tutor[] tutors= control.listTutors(AgencyName);
			int tutCount = tutors.length;
			session.setAttribute("Count",tutCount);
			int k = 0;
			for (Tutor t : tutors)
			{
				 session.setAttribute("TName"+k,t.getName());
				 session.setAttribute("TGender"+k,t.getGender());
				 session.setAttribute("TAddress"+k,t.getAddress());
				 session.setAttribute("TEmail"+k,t.getEmail());
				 session.setAttribute("TDis"+k,t.getDis());
				 session.setAttribute("TSubDis"+k,t.getSubDis());
				 session.setAttribute("TDS"+k,t.getDS());
				 session.setAttribute("TTS"+k,t.getTS());
				 session.setAttribute("TExp"+k,t.getExp());
				 session.setAttribute("TRem"+k,t.getRem());
				 session.setAttribute("Tlocation"+k,t.getLocation());
				 session.setAttribute("TDescription"+k,t.getDesc());
				 session.setAttribute("TContact"+k,t.getContact());
				 session.setAttribute("TBS"+k,t.batchSize());
				 session.setAttribute("Tdob"+k,t.getdob());
				 if(k<tutCount)
					 k++;
				 else break;
			}
			
		
			
		}
		
		else if (type.equals("removeTutor"))
		{
			HttpSession session=request.getSession();  
			String TEmail = session.getAttribute("TEmail").toString();
			Long aid = Long.parseLong(session.getAttribute("AgentID").toString());
			
			control = new MainController();
			boolean flag = control.removeTutor(TEmail, aid);
			if (flag)
			{
				PrintWriter out =response.getWriter();
				out.println("<script>alert(\"Deleted Successfully\");</script>");
				
				RequestDispatcher rd=request.getRequestDispatcher("AgencyDashboard.jsp");  
			    rd.include(request, response);  
			    
				// response.sendRedirect("AgencyDashboard.jsp");
			} else 
			{
				PrintWriter out =response.getWriter();
				out.println("<script>alert(\"Unsuccessful Remove\");</script>");
				
				RequestDispatcher rd=request.getRequestDispatcher("AgencyDashboard.jsp");  
			    rd.include(request, response);  
			    
				// response.sendRedirect("AgencyDashboard.jsp");
			}
		}
		
		else if (type.equals("updateAgentTutor"))
		{
			
			HttpSession session=request.getSession();  
			name=request.getParameter("name");
			gender = request.getParameter("gender");
			dob=request.getParameter("db");
			email=(String) session.getAttribute("TEmail");
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
			location=request.getParameter("location");
			description=request.getParameter("desc");
			pass = request.getParameter("pass");
			bs =request.getParameter("bs");	
			aid = Long.parseLong(session.getAttribute("AgentID").toString());
			
			
			control = new MainController();
			try {
				control.updateAgentTutor(name,dob,email, contact,address, gender,discipline,subdiscipline,dayslot,timeslot, experience,remuneration,location,bs,description,pass,aid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("AgencyDashboard.jsp");  
			rd.include(request, response);
			
			//response.sendRedirect("AgencyDashboard.jsp");
			
		}
		else if (type.equals("deleteMyTutor"))
		{
			
		}
		
	}
	


	
	
	

}
