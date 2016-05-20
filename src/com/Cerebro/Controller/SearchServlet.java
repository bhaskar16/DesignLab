package com.Cerebro.Controller;
/** Author : Bhaskar Ghosh Dastidar  **/
import java.io.IOException;


import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Cerebro.Entity.*;
import com.Cerebro.View.*;
public class SearchServlet extends HttpServlet {
	
	private MainController control;
	private String discipline;
	private String disc_sub;
	private double remuneration_low;
	private double remuneration_high;
	private String day_slots;
	private String[] time_slots;
	private String location;
	private int experience;
	private String age;
	private String gender;
	private String batch_size;
	private boolean agent_registered;
	private String priority;
	private boolean valid;
	private String[] errorMsg;
	private int errCount;
	private String ag_reg;
	private String type;
	private String email;
	private String pass;
	
	private String bs;
	private String name;
	private String dob;
	
	private String SEmail;
	private String TEmail;
	private String contact;
	private String address;
	
	private String subdiscipline;
	private String dayslot;
	private String timeslot;
	
	private double remuneration;
	
	private String description;
	private String achievements[];
	private String agencyName;
	private String contactPerson;	
	private String contactNumber;
	private String reviewBody;
	private int rating;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//String parameters = request.getParameter("search");
		
		discipline = request.getParameter("discipline");
		disc_sub = request.getParameter("subdiscipline");
		remuneration_low = Double.parseDouble(request.getParameter("remunerationl"));
		remuneration_high = Double.parseDouble(request.getParameter("remunerationh"));
		day_slots = request.getParameter("DS");
		String temp = request.getParameter("TS");
		time_slots = temp.split(",");
		location = request.getParameter("location");
		experience = Integer.parseInt(request.getParameter("exp"));
		age = request.getParameter("agepref");
		batch_size = request.getParameter("bs");
		gender = request.getParameter("gender");
		ag_reg = request.getParameter("ag_reg");
		
		System.out.println(experience);
		SearchEngine se = new SearchEngine(discipline,disc_sub,remuneration_low,remuneration_high,day_slots,time_slots,location,experience,age,
				gender,batch_size,ag_reg);
		Tutor[] t =se.search();
		if(t==null || t.length == 0)
		{
			 
			HttpSession session=request.getSession();  
			session.setAttribute("Results", 0);
			//response.sendRedirect("SearchResults.jsp");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("SearchResults.jsp");  
			 rd.include(request, response);
			 
		}
		else{
		//System.out.println(discipline + disc_sub + remuneration_low + time_slots+ag_reg);
		displayResults(request,response,t);
		}
	}

	

	public void displayResults (HttpServletRequest request,
			HttpServletResponse response,Tutor[] tutors) throws ServletException, IOException
	{
		int k = 0;
		 HttpSession session=request.getSession();  
		  session.setAttribute("Results", tutors.length);
			
		  for(Tutor t : tutors){
		
			
			 session.setAttribute("T_ID"+k,t.getProfileId());
			 session.setAttribute("Name"+k,t.getName());
			 session.setAttribute("Gender"+k,t.getGender());
			 session.setAttribute("Address"+k,t.getAddress());
			 session.setAttribute("TEmail"+k,t.getEmail());
			 session.setAttribute("Dis"+k,t.getDis());
			 session.setAttribute("SubDis"+k,t.getSubDis());
			 session.setAttribute("DS"+k,t.getDS());
			 session.setAttribute("TS"+k,t.getTS());
			 session.setAttribute("Exp"+k,t.getExp());
			 session.setAttribute("Rem"+k,t.getRem());
			 session.setAttribute("location"+k,t.getLocation());
			 session.setAttribute("Description"+k,t.getDesc());
			 session.setAttribute("Contact"+k,t.getContact());
			 session.setAttribute("BS"+k,t.batchSize());
			 session.setAttribute("dob"+k,t.getdob());
			 if(k<tutors.length)
			 k++;
			 else break;
			 
			}
		   // response.sendRedirect("SearchResults.jsp");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("SearchResults.jsp");  
			 rd.include(request, response);
			 
		
	}
	
}
