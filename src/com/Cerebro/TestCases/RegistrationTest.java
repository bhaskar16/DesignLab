package com.Cerebro.TestCases;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Cerebro.Entity.Agent;
import com.Cerebro.Entity.IndependentTutor;
import com.Cerebro.Entity.Student;
import com.Cerebro.Entity.Tutor;
import com.Cerebro.Entity.Tutor2;
import com.Cerebro.View.AgentInfoForm;
import com.Cerebro.View.StudentInfoForm;
import com.Cerebro.View.TutorInfoForm;

public class RegistrationTest {
	
	
	protected boolean value1,value2,value3;	

	@Before  
	public void setUp() throws Exception {
		
		
		String sn="sherlock",sa="221B",se="sh@gmail.com",sp="xvxv",sc="9999949999";
		String an="john",aa="222B",ae="jw@gmail.com",acp="sherlock",acn="8888888888",ap="456";
		String n="ram",db="10/1/1999",eid="fg@gg.com",c="7777777777",add="kol",dis="arts",subdis="history",ds="1000001",ts="timeslot"; int ex=5; double rem=1000.0; String loc="location",des="home",gen="male",bs="Single";
		
		
		
		value1=new Student(sn,sa,se,sp,sc).validate();
		value2=new Agent(an,aa,acp,acn,ae,ap).validate();
		value3=new Tutor(n, db, eid, c, add,gen, dis, subdis,  ex, rem,ds, ts, loc,bs, des).validate();
		
		
		
		
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStudentRegistration() {
		assertTrue(value1==true);
	}

	@Test
	public void testTutorRegistration() {
		assertTrue(value3==true);
	}

	@Test
	public void testAgentRegistration() {
		assertTrue(value2==true);
	}

}
