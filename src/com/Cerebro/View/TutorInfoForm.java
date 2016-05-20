package com.Cerebro.View;

public class TutorInfoForm {
	
	private String name;
	private String dob;
	private String email;
	private String contact;
	private String address;
	private String discipline;
	private String subdiscipline;
	private int experience;
	private double remuneration;
	private String timeslot;
	private String location;
	private String dayslot;
	private String batchstrength;
	private String description;
	private String password;
	
	public TutorInfoForm(String n,String db,String eid,String c,String add,String dis,String subdis,String ds,String ts,int ex,double rem,String loc,String des,String pass)
	{
		name=n;
		dob=db;
		email=eid;
		contact=c;
		address=add;
		discipline=dis;
		subdiscipline=subdis;
		experience = ex;
		remuneration = rem;
		timeslot = ts;
		dayslot = ds;
		location = loc;
		description = des;
		password = pass;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDOB()
	{
		return dob;
	}
	public String getEmail()
	{
		return email;
	}
	
	public String getContact()
	{
		return contact;
	}

	public String getAddress()
	{
		return address;
	}
	
	public String getDis()
	{
		return discipline;
	}
	
	public int getExp()
	{
		return experience;
	}
	
	public double getRem()
	{
		return remuneration;
	}
	
	public String getDS()
	{
		return dayslot;
	}
	
	public String getTS()
	{
		return timeslot;
	}
	
	public String getLoc()
	{
		return location;
	}
	
	public String getDesc()
	{
		return description;
	}
}
