package com.Cerebro.Controller;
/** Author : Bhaskar Ghosh Dastidar  **/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Cerebro.Entity.*;
import com.Cerebro.View.*;

public class NegotiationHandler extends HttpServlet{
	private String type;
	private MainController control;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();  
	if (request.getParameter("type").equals("openContracts"))
	{
		control = new MainController();
		System.out.println(session.getAttribute("TID").toString());
		Contract[] c = control.listOpenContracts("tutor",Long.parseLong(session.getAttribute("TID").toString()));
		
		int len = c.length;int k =0;
		session.setAttribute("length", len);
		
		for (Contract ct : c)
		{
			session.setAttribute("CID"+k, ct.getId());
			session.setAttribute("SID"+k, ct.getStudentId());
			session.setAttribute("TID"+k, ct.getProfileId());
			session.setAttribute("Location"+k, ct.getLocation());
			session.setAttribute("Remuneration"+k, ct.getRem());
			session.setAttribute("Batch"+k, ct.getBatchSize());
			session.setAttribute("Days"+k, ct.getDS());
			session.setAttribute("Time"+k, ct.getTS());
			//session.setAttribute("Messages"+k, ct.getAllMessages());
			session.setAttribute("Status"+k, ct.getStatus());
			if(k<len)
				k++;
			else break;
		}
		System.out.println(session.getAttribute("Status0"));
		
		RequestDispatcher rd=request.getRequestDispatcher("OpenContracts.jsp");  
		rd.include(request, response);
		
		// response.sendRedirect("OpenContracts.jsp");
		
	}
	else if (request.getParameter("type").equals("createContract"))
	{
		String utype=session.getAttribute("UserType").toString();
		String ID = request.getParameter("count");
		String SID = session.getAttribute("SID").toString();
		String TEmail = session.getAttribute("TEmail"+ID).toString();
		
		
		
	
		control = new MainController();
		boolean flag = control.createContract(TEmail,SID);
		if(flag)
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"A new Contract has been created\");</script>");
			
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
				 rd.include(request, response);
				 
				// response.sendRedirect("StudentDashboard.jsp");
			}
			
		}
	}
	
	
	else if (request.getParameter("type").equals("proposeClosure"))
	{
		String utype=session.getAttribute("UserType").toString();
		String DBID = session.getAttribute("CID").toString();
		String Location = session.getAttribute("Location").toString();
		String SID = session.getAttribute("SID").toString();
		String TID = session.getAttribute("TID").toString();
		String Day = session.getAttribute("DS").toString();
		String Time = session.getAttribute("TS").toString();
		double Rem  = Double.parseDouble(session.getAttribute("Rem").toString());
		String batch = request.getParameter("Batch");
		
		
		System.out.println(Location+ DBID+SID+TID+Day+Time+Rem+batch);
		control = new MainController();
		boolean flag = control.proposeClosure(Long.parseLong(DBID),Long.parseLong(TID),Long.parseLong(SID),Rem,Day,Time,Location,batch,1,utype);
		if(flag)
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Contract Closure proposed\");</script>");
			String homepage = session.getAttribute("Homepage").toString();
			//response.sendRedirect(homepage);
			
			RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			rd.include(request, response);
			
			
			/*if(utype.equals("Tutor"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
				 rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
				 rd.include(request, response);
			}*/
			
		}
	}
	
	else if (request.getParameter("type").equals("acceptDeal"))
	{
		String utype=session.getAttribute("UserType").toString();
		String DBID = session.getAttribute("CID").toString();
		String TID = session.getAttribute("TID").toString();
		String SID = session.getAttribute("SID").toString();
		double Rem  = Double.parseDouble(session.getAttribute("Rem").toString());
		String Day = session.getAttribute("DS").toString();
		String Time = session.getAttribute("TS").toString();
		String Location = session.getAttribute("Location").toString();
		String batch =session.getAttribute("Batch").toString();
		int status = Integer.parseInt(session.getAttribute("Status").toString());
		
		control = new MainController();
		boolean flag= control.acceptDeal(DBID,TID,SID,Rem,Day,Time,Location,batch,status,utype);
		
		
		if(flag)
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Accepted\");</script>");
			String homepage = session.getAttribute("Homepage").toString();
			
			RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			rd.include(request, response);
			
			
			//response.sendRedirect(homepage);
			
			
			/*if(utype.equals("Tutor"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
				 rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
				 rd.include(request, response);
			}*/
			
		}
		else
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"You cannot accept a deal you made\");</script>");
			String homepage = session.getAttribute("Homepage").toString();
			
			RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			rd.include(request, response);
			
			
			//response.sendRedirect(homepage);
			
			
			/*if(utype.equals("Tutor"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
				 rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
				 rd.include(request, response);
			}*/
		}
	}
	else if (request.getParameter("type").equals("rejectDeal"))
	{
		String utype=session.getAttribute("UserType").toString();
		String DBID = session.getAttribute("CID").toString();
		String TID = session.getAttribute("TID").toString();
		String SID = session.getAttribute("SID").toString();
		double Rem  = Double.parseDouble(session.getAttribute("Rem").toString());
		String Day = session.getAttribute("DS").toString();
		String Time = session.getAttribute("TS").toString();
		String Location = session.getAttribute("Location").toString();
		String batch =session.getAttribute("Batch").toString();
		int status = Integer.parseInt(session.getAttribute("Status").toString());
		
		control = new MainController();
		boolean flag= control.rejectDeal(DBID,TID,SID,Rem,Day,Time,Location,batch,status);
		
		
		if(flag)
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Rejected Deal\");</script>");
			String homepage = session.getAttribute("Homepage").toString();
			
			RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			rd.include(request, response);
			
			
			//response.sendRedirect(homepage);
			
			
			/*if(utype.equals("Tutor"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
				 rd.include(request, response);
			}
			else 
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
				 rd.include(request, response);
			}*/
			
		}
	}
	
	else if (request.getParameter("type").equals("cancelNegotiation"))
	{
		String utype=session.getAttribute("UserType").toString();
		String DBID = session.getAttribute("CID").toString();
		String Location = session.getAttribute("Location").toString();
		String SID = session.getAttribute("SID").toString();
		String TID = session.getAttribute("TID").toString();
		String Day = session.getAttribute("DS").toString();
		String Time = session.getAttribute("TS").toString();
		double Rem  = Double.parseDouble(session.getAttribute("Rem").toString());
		String batch =session.getAttribute("Batch").toString();
		int status = Integer.parseInt(session.getAttribute("Status").toString());
		
		System.out.println("negotiation handler status "+status);
		control = new MainController();
		//control.proposeClosureByTutor(Long.parseLong(DBID),Long.parseLong(TID),Long.parseLong(SID),Rem,Day,Time,Location,batch,status);
		boolean flag = control.cancelContract(Long.parseLong(DBID),Long.parseLong(TID),Long.parseLong(SID),Rem,Day,Time,Location,batch,status);
		if(flag)
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Deleted Contract\");</script>");
			String homepage = session.getAttribute("Homepage").toString();
			
		//	response.sendRedirect(homepage);
			
			
			RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			rd.include(request, response);
			
			/*if(utype.equals("Tutor"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
				 rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
				 rd.include(request, response);
			}*/
			
			
		}
	}
	
	else if (request.getParameter("type").equals("updateContract"))
	{
		System.out.println("Updating");
		String utype=session.getAttribute("UserType").toString();
		System.out.println(utype);
		if(utype.equals("student"))
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Sorry you cannot update contract information\");</script>");
			//response.sendRedirect("StudentDashboard.jsp");
			
			RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
			rd.include(request, response);
			
		}
		else{
		String DBID = session.getAttribute("CID").toString();
		String Location = request.getParameter("Loc");
		String SID = session.getAttribute("SID").toString();
		String TID = session.getAttribute("TID").toString();
		String Day = request.getParameter("DS");
		String Time = request.getParameter("TS");
		double Rem  = Double.parseDouble(request.getParameter("Rem"));
		String batch = request.getParameter("Batch");
		int status = Integer.parseInt(session.getAttribute("Status").toString());
		
		System.out.println("negotiation handler status "+status+" update    "+Day+Time);
		control = new MainController();
		
		boolean flag = control.updateContract(Rem, Day, Time, Location, batch, Long.parseLong(TID),Long.parseLong(DBID));
		
		if(flag)
		{

			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Contract Updated\");</script>");
			String homepage = session.getAttribute("Homepage").toString();
			
			//response.sendRedirect(homepage);
			
			
			RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			rd.include(request, response);
			
			/*if(utype.equals("Tutor"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
				 rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
				 rd.include(request, response);
			} */
		}
	}
	}
	
	
	else if (request.getParameter("type").equals("showAllContracts"))
	{
		Contract[] c=null;
		String utype=session.getAttribute("UserType").toString();
		System.out.println(utype);
		control = new MainController();
		
		if(utype.equals("Tutor"))
			 c = control.listOpenContracts(utype,Long.parseLong(session.getAttribute("TID").toString()));
		else if(utype.equals("student"))
			c = control.listOpenContracts(utype,Long.parseLong(session.getAttribute("SID").toString()));
		int len = c.length;int k =0;
		session.setAttribute("Olength", len);
		
		for (Contract ct : c)
		{
		
			System.out.println("SHOW");
			session.setAttribute("OCID"+k, ct.getId());
			session.setAttribute("OSID"+k, ct.getStudentId());
			session.setAttribute("OSNAME"+k, ct.getStudentName());
			session.setAttribute("OTNAME"+k, ct.getTutorName());
			session.setAttribute("OTID"+k, ct.getProfileId());
			session.setAttribute("OLocation"+k, ct.getLocation());
			session.setAttribute("ORemuneration"+k, ct.getRem());
			session.setAttribute("OBatch"+k, ct.getBatchSize());
			session.setAttribute("ODays"+k, ct.getDS());
			System.out.println("Hello "+ct.getDS());
			session.setAttribute("OTime"+k, ct.getTS());
			//session.setAttribute("OMessages"+k, ct.getAllMessages());
			session.setAttribute("OStatus"+k, ct.getStatus());
			if(k<len)
				k++;
			else break;
		}
		
		if(utype.equals("Tutor"))
			c = control.listPendingContracts(utype,Long.parseLong(session.getAttribute("TID").toString()));
		else
			c = control.listPendingContracts(utype,Long.parseLong(session.getAttribute("SID").toString()));
		len = c.length;k =0;
		session.setAttribute("Plength", len);
		
		for (Contract ct : c)
		{
			session.setAttribute("PCID"+k, ct.getId());
			session.setAttribute("PSID"+k, ct.getStudentId());
			session.setAttribute("PSNAME"+k, ct.getStudentName());
			session.setAttribute("PTID"+k, ct.getProfileId());
			session.setAttribute("PTNAME"+k, ct.getTutorName());
			session.setAttribute("PLocation"+k, ct.getLocation());
			session.setAttribute("PRemuneration"+k, ct.getRem());
			session.setAttribute("PBatch"+k, ct.getBatchSize());
			session.setAttribute("PDays"+k, ct.getDS());
			session.setAttribute("PTime"+k, ct.getTS());
			//session.setAttribute("PMessages"+k, ct.getAllMessages());
			session.setAttribute("PStatus"+k, ct.getStatus());
			if(k<len)
				k++;
			else break;
		}
		
		if(utype.equals("Tutor"))
			c = control.listFinalContracts(utype,Long.parseLong(session.getAttribute("TID").toString()));
		else
			c = control.listFinalContracts(utype,Long.parseLong(session.getAttribute("SID").toString()));

		len = c.length;k =0;
		session.setAttribute("Flength", len);
		
		for (Contract ct : c)
		{
			session.setAttribute("FCID"+k, ct.getId());
			session.setAttribute("FSID"+k, ct.getStudentId());
			session.setAttribute("FSNAME"+k, ct.getStudentName());
			session.setAttribute("FTID"+k, ct.getProfileId());
			session.setAttribute("FTNAME"+k, ct.getTutorName());
			session.setAttribute("FLocation"+k, ct.getLocation());
			session.setAttribute("FRemuneration"+k, ct.getRem());
			session.setAttribute("FBatch"+k, ct.getBatchSize());
			session.setAttribute("FDays"+k, ct.getDS());
			session.setAttribute("FTime"+k, ct.getTS());
			//session.setAttribute("FMessages"+k, ct.getAllMessages());
			session.setAttribute("FStatus"+k, ct.getStatus());
			if(k<len)
				k++;
			else break;
		}
		 
		//response.sendRedirect("ListAllContracts.jsp");
		
		 
		 RequestDispatcher rd=request.getRequestDispatcher("ListAllContracts.jsp");  
		 rd.include(request, response);
		 
	}
	
	
	else if (request.getParameter("type").equals("sendMessage"))
	{
		
		String utype=session.getAttribute("UserType").toString();
		String cID = session.getAttribute("CID").toString();
		String mbody = request.getParameter("mBody");
		String sender = session.getAttribute("UserType").toString();
		String dir="";
		//String ID = session.getAttribute("ID").toString();
		
		
		System.out.println(cID+mbody+sender);
		control = new MainController();
		if (sender.equals("Tutor")|| sender.equals("agent"))
		{
			dir="t-s";
		}
		else
		{
			dir="s-t";
		}
		control.sendMessage(Long.parseLong(cID),mbody,dir);
		String homepage = session.getAttribute("Homepage").toString();
		
		//response.sendRedirect(homepage);
		
		RequestDispatcher rd=request.getRequestDispatcher(homepage);  
		rd.include(request, response);
		
		
		/*if(utype.equals("Tutor")){
			RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
			rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.jsp");  
			rd.include(request, response);
		}*/
		
		/*boolean flag = control.proposeClosureByTutor(Long.parseLong(DBID),Long.parseLong(TID),Long.parseLong(SID),Rem,Day,Time,Location,batch,1);
		if(flag)
		{
			PrintWriter out ;
			out  = response.getWriter();
			out.println("<script>alert(\"Contract Closure proposed\");</script>");
			RequestDispatcher rd=request.getRequestDispatcher("ITutorDashboard.jsp");  
			 rd.include(request, response);
		}*/
	}
	else if (request.getParameter("type").equals("showMessages") && request.getParameter("Ctype").equals("O"))
	{
		
		String ID = request.getParameter("count");
		String utype=session.getAttribute("UserType").toString();
		System.out.println("ID is"+ID);
		String DBID = session.getAttribute("OCID"+ID).toString();
		session.setAttribute("CID", DBID);
		control = new MainController();
		Message[] m = control.showMessages(DBID);
		int mLen = m.length;
		session.setAttribute("mlength", mLen);
		System.out.println(mLen);
		int k =0;
		for (Message msg : m )
		{
			session.setAttribute("Sender"+k,msg.getSender());
			session.setAttribute("Date"+k,msg.getDate());
			session.setAttribute("Body"+k,msg.getMessage());
			if(k<mLen)
				k++;
			else 
				break;
			
		}
		// response.sendRedirect("Messaging.jsp?ID="+ID);
		 
		 RequestDispatcher rd=request.getRequestDispatcher("Messaging.jsp?ID="+ID);  
		 rd.include(request, response);
		 
	}
	
	else if (request.getParameter("type").equals("showMessages") && request.getParameter("Ctype").equals("P"))
	{
		String utype=session.getAttribute("UserType").toString();
		
		String ID = request.getParameter("count");
		System.out.println("PID is"+ID);
		String DBID = session.getAttribute("PCID"+ID).toString();
		session.setAttribute("CID", DBID);
		System.out.println(DBID);
		control = new MainController();
		Message[] m = control.showMessages(DBID);
		int mLen = m.length;
		session.setAttribute("mlength", mLen);
		System.out.println(mLen);
		int k =0;
		for (Message msg : m )
		{
			session.setAttribute("Sender"+k,msg.getSender());
			session.setAttribute("Date"+k,msg.getDate());
			session.setAttribute("Body"+k,msg.getMessage());
			if(k<mLen)
				k++;
			else 
				break;
			
		}
		// response.sendRedirect("Messaging.jsp?ID="+ID);
		 RequestDispatcher rd=request.getRequestDispatcher("Messaging.jsp?ID="+ID);  
		 rd.include(request, response);
		
	}
	}

	
}
