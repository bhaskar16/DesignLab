package com.Cerebro.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Cerebro.Entity.Agent;
import com.Cerebro.Entity.AgentRegisteredTutor;
import com.Cerebro.Entity.Contract;
import com.Cerebro.Entity.ContractList;
import com.Cerebro.Entity.IndependentTutor;
import com.Cerebro.Entity.Login;
import com.Cerebro.Entity.Message;
import com.Cerebro.Entity.RateAndReview;
import com.Cerebro.Entity.Review;
import com.Cerebro.Entity.Student;
import com.Cerebro.Entity.Tutor;
/** Author : Bhaskar Ghosh Dastidar  **/
public class MainController {
	
	public static boolean registerStudent(String name, String address, String email, String pass, String contact)
	{
		Student s = new Student(name,address,email,pass,contact);
		return s.createStudent(s);
	}

	public boolean registerIndependantTutor(String name,String dob,String email,String contact,String address,String gender,String discipline,
			String subdiscipline,String dayslot,String timeslot,int experience,double remuneration,String location,String bs,String description,String pass) throws SQLException {
		// TODO Auto-generated method stub
		IndependentTutor t = new IndependentTutor(name, dob, email, contact, address, gender, discipline, subdiscipline, experience, remuneration, dayslot, timeslot, location, bs, description, pass);
		return t.createIndependentTutor(t);
	}

	public boolean registerAgent(String agencyName, String address, String contactPerson, String contactNumber,
			String email, String pass) {
		// TODO Auto-generated method stub
		
		Agent a = new Agent(agencyName,address,contactPerson,contactNumber,email,pass);
		return a.createAgent(a);
		
	}
	public boolean registerAgentTutor(String name,String dob,String email,String contact,String address,String gender,String discipline,
			String subdiscipline,String dayslot,String timeslot,int experience,double remuneration,String location,String bs,String description,Long aid) throws SQLException {
		// TODO Auto-generated method stub
		AgentRegisteredTutor at = new AgentRegisteredTutor(name,dob,email,contact,address,gender,discipline,subdiscipline,experience,remuneration,dayslot,timeslot,location,bs,description,aid);
		return at.createAgentRegisteredTutor();
	}
	

	public void login(String email,String pass,HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Login l = new Login ();
		l.login(email, pass,request,response);
	}

	public Student updateStudent(String name, String address, String email, String pass, String contact) {
		// TODO Auto-generated method stub
		System.out.println(email);
		Student s = new Student(name,address,email,pass,contact);
		boolean flag = s.updateStudent(s);
		return s;
	}

	public IndependentTutor updateIndependantTutor(String name,String dob,String email,String contact,String address,String gender,String discipline,
			String subdiscipline,String dayslot,String timeslot,int experience,double remuneration,String location,String bs,String description,String pass) throws SQLException  {
		// TODO Auto-generated method stub
		IndependentTutor t = new IndependentTutor(name, dob, email, contact, address, gender, discipline, subdiscipline, experience, remuneration, dayslot, timeslot, location, bs, description, pass);
		boolean flag = t.updateIndependent(t);
		return t;
		
		
		
		
		
	}

	public Agent updateAgent(String agencyName, String address, String contactPerson, String contactNumber, String email,
			String pass) {
		// TODO Auto-generated method stub

		Agent a = new Agent(agencyName,address,contactPerson,contactNumber,email,pass);
		boolean flag = a.updateAgent(a);
		return a;
	}

	public void rateAndReview(String sEmail, String tEmail, String reviewBody, int rating,boolean flag) {
		// TODO Auto-generated method stub
		
		RateAndReview r = new RateAndReview();
		r.setTutor(tEmail);
		r.setStudent(sEmail);
		r.setRating(rating);
		r.setReviewbody(reviewBody);
		r.setisPos(flag);
		r.setReview();
		
	}
	
	public Review[] seeReview(String TEmail) {
		// TODO Auto-generated method stub
		
		RateAndReview r = new RateAndReview();
		int rate = r.getRating(TEmail);
		Review[] VRev = r.getVerifiedReviews(TEmail);
		
		return VRev;
	}
	
	public Review[] seeAllReview(String TEmail) {
		// TODO Auto-generated method stub
		
		RateAndReview r = new RateAndReview();
		
		Review[] All = r.getReviews(TEmail);
		
		return All;
	}
	public int seeRating(String TEmail) {
		// TODO Auto-generated method stub
		RateAndReview r = new RateAndReview();
		int rate = r.getRating(TEmail);
		return rate;
	}

	public void SearchTutor() {
		// TODO Auto-generated method stub
		
	}

	public Tutor[] listTutors(String agencyName) {
		// TODO Auto-generated method stub
		return new Agent().listMyTutors(agencyName);
		//System.out.println(tutor.length);
		
	}

	public boolean removeTutor(String email,Long id) {
		// TODO Auto-generated method stub
		//new AgentRegisteredTutor().removeMe(email);
		return new Agent().removeTutor(email, id);
		
	}


	
	
	public Student viewStudent(String email,HttpServletRequest request,
			HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		Student s = new Student().getPublicProfile(email);
		ProfileHandler pr = new ProfileHandler();
		pr.viewStudent(s,request,response);
		return s;
		
	}
	
	
	public Agent viewAgent(String email,HttpServletRequest request,
			HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		Agent s = new Agent().getPublicProfile(email);
		ProfileHandler pr = new ProfileHandler();
		pr.viewAgent(s,request,response);
		return s;
		
	}
	
	public IndependentTutor viewTutor(String email,HttpServletRequest request,
			HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		IndependentTutor s = new IndependentTutor().getPublicProfile(email);
		ProfileHandler pr = new ProfileHandler();
		pr.viewTutor(s,request,response);
		return s;
		
	}

	public AgentRegisteredTutor updateAgentTutor(String name, String dob, String email, String contact, String address, String gender,
			String discipline, String subdiscipline, String dayslot, String timeslot, int experience,
			double remuneration, String location, String bs, String description, String pass,Long aid) throws SQLException {
		// TODO Auto-generated method stub
		AgentRegisteredTutor at = new AgentRegisteredTutor(name, dob, email, contact, address, gender, discipline, subdiscipline, experience, remuneration, dayslot, timeslot, location, bs, description, aid);
		
		
			boolean flag = at.updateAgent(at);
			return at;
	}

	public void addAchievements(String body, long id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag = new Tutor().addAchievement(body, id);
		HttpSession session = request.getSession();
		String homepage = session.getAttribute("Homepage").toString();
		if (flag)
		{
			 PrintWriter out = response.getWriter();
			 out.println("<script>alert('Added achievement');</script>");
			/* 
			 RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			 rd.include(request, response);  
			 */
			 response.sendRedirect(homepage);
		}
		else
		{
			 PrintWriter out = response.getWriter();
			 out.println("<script>alert('Could not Add Achievement');</script>");
			/* 
			 RequestDispatcher rd=request.getRequestDispatcher(homepage);  
			 rd.include(request, response);  
			 */
			 response.sendRedirect(homepage);
		}
		
	}

	public String[] listAchievements(long id) {
		// TODO Auto-generated method stub
		return new Tutor().listAchievements(id);
	}

	public Student[] listStudents(long id) {
		// TODO Auto-generated method stub
		return new Tutor().listMyStudents(id);
	}

	public boolean deleteStudentRecord(String sEmail, String tEmail) {
		// TODO Auto-generated method stub
		return new Tutor().removeStudent(sEmail, tEmail);
	}

	public Contract[] listOpenContracts(String type, Long Id) {
		System.out.println(type+Id);
		ContractList cl = new ContractList(type,Id);
		return cl.getActive();
		
	}

	public boolean proposeClosure(long dId, long pId, long sId, double rem, String ds,
			String ts, String loc, String bs, int st,String utype) {
		// TODO Auto-generated method stub
		System.out.println("here");
		Contract c = new Contract(dId,pId,sId,rem,ds,ts,loc,bs,st);
		if(utype.equals("Tutor"))
			return c.proposeClosure(pId);
		else
			return c.proposeClosure(sId);
		
	}

	public boolean cancelContract(long dId, long pId, long sId, double rem, String ds, String ts,
			String loc, String bs, int st) {
		// TODO Auto-generated method stub
		Contract c = new Contract(dId,pId,sId,rem,ds,ts,loc,bs,st);
		return c.cancel();
		
		
	}

	public Contract[] listPendingContracts(String type, long Id) {
		System.out.println(type+Id);
		ContractList cl = new ContractList(type,Id);
		return cl.getPending();
	}

	public Contract[] listFinalContracts(String type, long Id) {
		//System.out.println(type+Id);
		ContractList cl = new ContractList(type,Id);
		return cl.getClosed();
	}

	public boolean updateContract(double rem, String day, String time, String location, String batch, long tID,long cID) {
		// TODO Auto-generated method stub
		return new Contract().updateContract(rem, day, time, location, batch, tID,cID);
	}

	public boolean acceptDeal(String dBID, String tID, String sID, double rem, String day, String time, String location,
			String batch, int status,String user) {
		// TODO Auto-generated method stub
		Contract c = new Contract(Long.parseLong(dBID),Long.parseLong(tID),Long.parseLong(sID),rem,day,time,location,batch,status);
		if(user.equals("Tutor"))
			return c.acceptClosure(Long.parseLong(tID));
		else
			return c.acceptClosure(Long.parseLong(sID));
	}

	public boolean rejectDeal(String dBID, String tID, String sID, double rem, String day, String time, String location,
			String batch, int status) {
		// TODO Auto-generated method stub
		Contract c = new Contract(Long.parseLong(dBID),Long.parseLong(tID),Long.parseLong(sID),rem,day,time,location,batch,status);
		return c.rejectClosure(Long.parseLong(tID));
	}

	public void sendMessage(long CID, String mbody, String dir) {
		// TODO Auto-generated method stub
		Message m = new Message(CID,mbody,dir);
		
	}

	public Message[] showMessages(String dBID) {
		// TODO Auto-generated method stub
		//Contract c = new Contract(Long.parseLong(dBID),Long.parseLong(tID),Long.parseLong(sID),rem,day,time,location,batch,status);
		return new Contract().getAllMessages(Long.parseLong(dBID));
		
	}

	public boolean createContract(String tEmail, String sID) {
		// TODO Auto-generated method stub
		Contract c = new Contract (tEmail,Long.parseLong(sID));
		return true;
	}
	
	

	

}
