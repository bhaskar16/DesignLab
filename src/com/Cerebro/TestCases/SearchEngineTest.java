package com.Cerebro.TestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Cerebro.Controller.SearchEngine;

public class SearchEngineTest {

	
	
	private boolean value=false;  
	@Before
	public void setUp() throws Exception {
		
		String disc="arts"; String d_sub="history"; double rem_l=100.0; double rem_h=1000.0; String dsl="1001000";
		String[] ts={"15:00-16:00"};
		String loc="Home"; int exp=8; String agexp="18-25"; String gen="male"; String bsize="Single"; String ag_reg="true";
		
		value=new SearchEngine(disc,d_sub,rem_l,rem_h,dsl,ts,loc,exp,agexp,gen,bsize,ag_reg).isValid();
		
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testSearchTutor() {
		assertTrue(value==true);
	}

}
