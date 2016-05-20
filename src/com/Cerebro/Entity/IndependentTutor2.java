package com.Cerebro.Entity;

import com.Cerebro.View.TutorInfoForm;

public class IndependentTutor2 extends Tutor2 {

	public IndependentTutor2(String n, String db, String eid, String c, String add, String dis, String subdis, String ds,
			String ts, int ex, double rem, String loc, String des) {
		super(n, db, eid, c, add, dis, subdis, ds, ts, ex, rem, loc, des);
		// TODO Auto-generated constructor stub
	}



	public IndependentTutor2(TutorInfoForm stf) {
		// TODO Auto-generated constructor stub
		super(stf.getName(), stf.getDOB(), stf.getEmail(), stf.getContact(), stf.getAddress(), stf.getDis(),"", stf.getDS(), stf.getTS(), stf.getExp(), stf.getRem(), stf.getLoc(), stf.getDesc());
		
	}



	public void getPublicProfile()
	{
		
	}
	
	
	
	public boolean createIndependentTutor(IndependentTutor a1)
	{
		System.out.println("Db queries. Created Turor");
		return true;
		
	}
	
	public boolean updateIndependent(IndependentTutor a2)
	{
		return true;
		
	}
	public void negotiate()
	{
		
	}
	public String getName()
	{
		return super.getName();
	}
	public String getdob()
	{
		return super.getdob();
	}

	public String getEmail()
	{
		return super.getEmail();
	}

	public String getContact()
	{
		return super.getContact();
	}

	public String getAddress()
	{
		return super.getAddress();
	}

	public String getDis()
	{
		return super.getDis();
	}


	public String getSubDis()
	{
		return super.getSubDis();
	}
	public String getDS()
	{
		return super.getDS();
	}


	public String getTS()
	{
		return super.getTS();
	}


	public int getExp()
	{
		return super.getExp();
	}


	public long getRem()
	{
		return (long) super.getRem();
	}


	public String getLocation()
	{
		return super.getLocation();
	}


	public String getDesc()
	{
		return super.getDesc();
	}


	public String[] getAchievements()
	{
		return super.getAchievements();
	}



}
