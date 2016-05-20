package com.Cerebro.TestCases;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Cerebro.Entity.Contract;

public class NegotiationHandlerTest {
	
	
	private boolean value1=false;
	private boolean value2=false;
	private boolean value3=false;	
	@Before
	public void setUp() throws Exception {
		
		String email="samirsen@gmail.com";long id=7;
		double rem=500; String ds="0010000";String ts="18:00-19:00";String loc="25, Kudghat Road";String bs="Single";long tut_id=19;long cID=33;
		long did=33,sid=7;int st=2;
		Contract c=new Contract(did,tut_id,sid,rem,ds,ts,loc,bs,st);
		value3=c.updateContract(rem, ds, ts, loc, bs, tut_id, cID);
		System.out.println("this value 3 "+value3);

	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testContactUpdated() {
		assertTrue(value3!=true);	
	}

}
