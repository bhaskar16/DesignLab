package com.Cerebro.TestCases;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Cerebro.Controller.*;
import com.Cerebro.Entity.*;
import com.Cerebro.View.*;;


public class ManageTutorsTest {

	protected boolean value1,value2;
	@Before
	public void setUp() throws Exception {
		String email="ag007@gmail.com";
		long id=4;
		
		MainController o=new MainController();
		value1 = o.removeTutor(email, id);
	}

	@After
	public void tearDown() throws Exception {
	}


	
//	public void testListTutors() {
		
		//check whether size of array > 0
	
//	}
	
	@Test	
	public void testRemoveTutor() {
		
		assertTrue(value1!=true);
	
	}




}
