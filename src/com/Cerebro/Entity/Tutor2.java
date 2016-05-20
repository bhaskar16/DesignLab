package com.Cerebro.Entity;

public class Tutor2 {
	
private String name;
private String dob;
private String email;
private String contact;
private String address;
private String discipline;
private String subdiscipline;
private String dayslot;
private String timeslot;
private int experience;
private double remuneration;
private String location;
private String description;
private String achievements[];
private int rating;
private Review reviews[];
private Contract records[];
private long db_id;

public Tutor2(String n,String db,String eid,String c,String add,String dis,String subdis,String ds,String ts,int ex,double rem,String loc,String des)
{
	name=n;
	dob=db;
	email=eid;
	contact=c;
	address=add;
	discipline=dis;
	subdiscipline=subdis;
	dayslot=ds;
	timeslot=ts;
	experience=ex;
	remuneration=rem;
	location=loc;
	description=des;
}

public Tutor2() {
	// TODO Auto-generated constructor stub
}

public long getId() 
{
    return db_id;
}

public String getName()
{
	return name;
}
public String getdob()
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


public String getSubDis()
{
	return subdiscipline;
}
public String getDS()
{
	return dayslot;
}


public String getTS()
{
	return timeslot;
}


public int getExp()
{
	return experience;
}


public long getRem()
{
	return (long) remuneration;
}


public String getLocation()
{
	return location;
}


public String getDesc()
{
	return description;
}


public String[] getAchievements()
{
	return achievements;
}






}
