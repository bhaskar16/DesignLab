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
public class ProfileHandler  extends HttpServlet {
	private Student s;
	private String type;
	private String email;
	private String pass;
	private MainController control;
	private long aid;
	private String gender;
	private String bs;
	private String name;
	private String dob;
	
	private String SEmail;
	private String TEmail;
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
	private String reviewBody;
	private int rating;
	HttpServletRequest request;
	HttpServletResponse response;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		type = request.getParameter("type");// Type is the Jsp page that redirects to here
		if(type.equals("updateStudent"))
		{
			HttpSession session=request.getSession();  
			name = request.getParameter("name");
			address= request.getParameter("address");
			email = (String) session.getAttribute("Email");
			pass = request.getParameter("pass");
			contact = request.getParameter("contact");
			
			control = new MainController();
			Student newStudent = control.updateStudent(name,address,email,pass,contact);
			PrintWriter out =response.getWriter();
			out.println("<script>alert(\"Updated Successfully\");</script>");
			
			viewStudent(newStudent, request, response);
			
		}
		else if (type.equals("updateTutor"))
		{
			
			HttpSession session=request.getSession();  
			name=request.getParameter("name");
			gender = (String) session.getAttribute("Gender");
			dob=request.getParameter("db");
			email=(String) session.getAttribute("Email");
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
			IndependentTutor newTutor = new IndependentTutor() ;
			
			control = new MainController();
			try {
				newTutor = control.updateIndependantTutor(name,dob,email, contact,address, gender,discipline,subdiscipline,dayslot,timeslot, experience,remuneration,location,bs,description,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter out =response.getWriter();
			out.println("<script>alert(\"Updated Successfully\");</script>");
			viewTutor(newTutor,request,response);
			
		
			
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
			AgentRegisteredTutor atnew = new AgentRegisteredTutor();
			try {
				atnew = control.updateAgentTutor(name,dob,email, contact,address, gender,discipline,subdiscipline,dayslot,timeslot, experience,remuneration,location,bs,description,pass,aid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 //response.sendRedirect("AgencyDashboard.jsp");
			PrintWriter out =response.getWriter();
			out.println("<script>alert(\"Updated Successfully\");</script>");
			RequestDispatcher rd=request.getRequestDispatcher("AgencyDashboard.jsp");  
			rd.include(request, response); 
			
			
			
		}
		else if (type.equals("updateAgent"))
		{
			HttpSession session=request.getSession();  
			agencyName=request.getParameter("agencyName");
			address=request.getParameter("address");
			contactPerson = request.getParameter("contactPerson");
			contactNumber = request.getParameter("contactNumber");
			email = (String) session.getAttribute("Email");
			pass = request.getParameter("pass");
			System.out.println(agencyName+contactPerson+contactNumber+email+pass);
			control = new MainController();
			Agent agentNew = control.updateAgent(agencyName,address,contactPerson,contactNumber,email,pass);
			
			PrintWriter out =response.getWriter();
			out.println("<script>alert(\"Updated Successfully\");</script>");
			viewAgent(agentNew,request,response); 
			
		}
		else  if (type.equals("rate"))
		{
			boolean flag ;
			System.out.println("Rating");
			String isPos = request.getParameter("isPositive");
			System.out.println(isPos);
			if(isPos == null)
				flag=false;
			else 
				flag=true;
			
			HttpSession session=request.getSession();  
			String i = session.getAttribute("ID").toString();
			SEmail = session.getAttribute("Email").toString();
			TEmail = session.getAttribute("TEmail").toString();
			reviewBody = request.getParameter("reviewBody");
			rating = Integer.parseInt(request.getParameter("rate"));
			System.out.println("Important"+session.getAttribute("Email")+" rates "+session.getAttribute("TEmail"));
			control = new MainController();
			control.rateAndReview(SEmail,TEmail,reviewBody,rating,flag);
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Your review has been registered into our system. Please go back.\");</script>");
			
			
			RequestDispatcher rd=request.getRequestDispatcher("TutorDashboard.jsp?ID="+i);  
			rd.include(request, response); 
		}
		else  if (type.equals("viewReviews"))
		{
			HttpSession session=request.getSession();  
			
			TEmail = session.getAttribute("TEmail").toString();
			control = new MainController();
			Review[] review = control.seeReview(TEmail);
			Review[] ureview = control.seeAllReview(TEmail);
			int rating = control.seeRating(TEmail);
			int count = (review==null)?0:review.length;
			int ucount = (ureview==null)?0:ureview.length;
			 session.setAttribute("Count", count);
			 session.setAttribute("UCount", ucount);
			 session.setAttribute("Rating", rating);
			 session.setAttribute("TName", TEmail);
			 int k=0;if(count > 0) {
				 for(Review r : review){
					 session.setAttribute("SName"+k, r.getStudent_name());
					 
					 session.setAttribute("Body"+k,r.getBody());
					 if(k<count)
						 k++;
					 else break;
				 } 
			 } 
			 
			k=0;if(ucount > 0) {
				 for(Review r : ureview){
					 session.setAttribute("USName"+k, r.getStudent_name());
					 
					 session.setAttribute("UBody"+k,r.getBody());
					 if(k<ucount)
						 k++;
					 else break;
				 } 
			 } 
			// response.sendRedirect("Reviews.jsp");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("Reviews.jsp");  
			 rd.include(request, response); 
			 
		}
		else if (type.equals("listtutors"))
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
				
				 session.setAttribute("TID"+k,t.getProfileId());
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
			 
			//response.sendRedirect("Tutorslist.jsp");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("Tutorslist.jsp");  
			 rd.include(request, response); 
		     
			
		}
		
		else  if (type.equals("achievements"))
		{
			HttpSession session=request.getSession();  
			String Tid;
			Tid = session.getAttribute("TID").toString();
			long id = Long.parseLong(Tid);
			String body = request.getParameter("achievement");
			control = new MainController();
			System.out.println(body);
			control.addAchievements(body,id,request,response);
			 
		     
		}
		else  if (type.equals("listAchievements"))
		{
			HttpSession session=request.getSession();  
			String Tid;
			Tid = request.getParameter("id").toString();
			long id = Long.parseLong(Tid);
			System.out.println("here");
			control = new MainController();
			String[] ach = control.listAchievements(id);
			int length = ach.length;int k =0;
			session.setAttribute("count", length);
			if(ach == null) {
				System.out.println("Null Achievements");
			} else {
				for (String a : ach)
				{
					session.setAttribute("Achievements"+k,a );
					
					if(k<length)
						k++;
					else break;
				}
			}
			 //response.sendRedirect("Achievements.jsp");
		     RequestDispatcher rd=request.getRequestDispatcher("Achievements.jsp");  
			 rd.include(request, response);  
		}
		else  if (type.equals("viewAchievements"))
		{
			HttpSession session=request.getSession();  
			String Tid;
			Tid = request.getParameter("id").toString();
			long id = Long.parseLong(Tid);
			System.out.println("here");
			control = new MainController();
			String[] ach = control.listAchievements(id);
			int length = ach.length;int k =0;
			session.setAttribute("count", length);
			if(ach == null) {
				System.out.println("Null Achievements");
			} else {
				for (String a : ach)
				{
					session.setAttribute("Achievements"+k,a );
					
					if(k<length)
						k++;
					else break;
				}
			}
			//response.sendRedirect("ViewAchievements.jsp");
		     RequestDispatcher rd=request.getRequestDispatcher("ViewAchievements.jsp");  
			 rd.include(request, response);  
			 
		}
		else  if (type.equals("studentlist"))
		{
			HttpSession session=request.getSession();  
			String Tid;
			Tid = session.getAttribute("TID").toString();
			long id = Long.parseLong(Tid);
			System.out.println("here");
			control = new MainController();
			
			
			Student[] student = control.listStudents(id);
			int length = (student == null) ? 0 : student.length;
			session.setAttribute("Count", length);
			if(length!=0){
				int k =0;
				String TEmail = session.getAttribute("TEmail").toString();
				System.out.println("Email "+TEmail);
				if(student == null) {
					System.out.println("Null students");
				} else {
					for (Student s : student)
					{
						
						 session.setAttribute("Name"+k,s.getName());
						 session.setAttribute("Address"+k,s.getAdd());
						 session.setAttribute("Contact"+k,s.getContact());
						 session.setAttribute("Email"+k,s.getEmail());
						
						if(k<length)
							k++;
						else break;
					}
				}
			}
			//response.sendRedirect("StudentList.jsp");
			
			RequestDispatcher rd=request.getRequestDispatcher("StudentList.jsp");  
			 rd.include(request, response);  
			 
		}
		
		else  if (type.equals("removestudent"))
		{
			HttpSession session=request.getSession();  
			String SEmail = session.getAttribute("SEmail").toString();
			String TEmail = session.getAttribute("TEmail").toString();
			
			control = new MainController();
			String homepage = session.getAttribute("Homepage").toString();
			boolean flag = control.deleteStudentRecord(SEmail,TEmail);
			if (flag)
			{
				 PrintWriter out = response.getWriter();
				 out.println("<script>alert('Successfully Removed');</script>");
				// response.sendRedirect(homepage);
				 
				 RequestDispatcher rd=request.getRequestDispatcher(homepage);  
				 rd.include(request, response);  
				 
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Removal Failed');</script>");
				//response.sendRedirect(homepage);
				 
				 RequestDispatcher rd=request.getRequestDispatcher(homepage);  
				 rd.include(request, response);  
				 
			}
			
		}
		
		else if(type.equals("logout")) 
		{
			HttpSession session=request.getSession(); 
			 if (session != null) {
				session.invalidate();
				session = request.getSession();
			 }
			 //response.sendRedirect("index.html");
			 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			 rd.include(request, response);
			 
		}
		
	}
	
	public void viewStudent(Student s,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		 try{
			 HttpSession session=request.getSession(); 
			 if (session != null) {
				session.invalidate();
				session = request.getSession();
			 } request.setAttribute("Name", s.getName());
			 session.setAttribute("Homepage", "StudentDashboard.jsp");
			 session.setAttribute("SID", s.getId());
			 session.setAttribute("Name",s.getName());
			 session.setAttribute("Address",s.getAdd());
			 session.setAttribute("Contact",s.getContact());
			 session.setAttribute("pass",s.getPass());
			 session.setAttribute("Email",s.getEmail());
			// response.sendRedirect("StudentDashboard.jsp");
			 RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
			 rd.include(request, response);
		 } catch(Exception e) {
			 //response.sendRedirect("index.html");
			 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			 rd.include(request, response);
		 }
	}
	
	public void viewAgent(Agent s,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		 try{
			 HttpSession session=request.getSession();  
			 if (session != null) {
				session.invalidate();
				session = request.getSession();
			 } session.setAttribute("Name",s.getAgentName());
			 session.setAttribute("Homepage", "AgencyDashboard.jsp");
			 session.setAttribute("ContactPerson",s.getContactPerson());
			 session.setAttribute("Contact",s.getContact());
			 session.setAttribute("Address",s.getAddress());
			 session.setAttribute("Email",s.getEmail());
			 session.setAttribute("AgentID", s.getID());
			 session.setAttribute("pass", s.getPass());
			 System.out.println("Agent Id is "+s.getID());
			 
			// response.sendRedirect("AgencyDashboard.jsp");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("AgencyDashboard.jsp");  
			 rd.include(request, response);
			 
		 } catch(Exception e) {
			 e.printStackTrace();
			// response.sendRedirect("index.html");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			 rd.include(request, response);
			 
		 }
	}

	public void viewTutor(IndependentTutor s2, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 try{
			 HttpSession session=request.getSession();  
			 if (session != null) {
				session.invalidate();
				session = request.getSession();
			 } session.setAttribute("Name",s2.getName());
			 session.setAttribute("Homepage", "ITutorDashboard.jsp");
			 session.setAttribute("Gender",s2.getGender());
			 session.setAttribute("Address",s2.getAddress());
			 session.setAttribute("pass",s2.getPass());
			 session.setAttribute("Email",s2.getEmail());
			 session.setAttribute("Dis",s2.getDis());
			 session.setAttribute("SubDis",s2.getSubDis());
			 session.setAttribute("DS",s2.getDS());
			 session.setAttribute("TS",s2.getTS());
			 session.setAttribute("Exp",s2.getExp());
			 session.setAttribute("Rem",s2.getRem());
			 session.setAttribute("location",s2.getLocation());
			 session.setAttribute("Description",s2.getDesc());
			 session.setAttribute("Contact",s2.getContact());
			 session.setAttribute("BS",s2.batchSize());
			 session.setAttribute("dob",s2.getdob());
			 session.setAttribute("TID", s2.getProfileId());
			 System.out.println(s2.getProfileId());
			// response.sendRedirect("ITutorDashboard.jsp");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
			 rd.include(request, response);
		 } catch(Exception e) {
			 e.printStackTrace();
			// response.sendRedirect("index.html");
			 
			 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			 rd.include(request, response);
			 
		 }
	}
	
	
	
	

	
	

}
