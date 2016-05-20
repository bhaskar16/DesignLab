package com.Cerebro.TestCases;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Cerebro.Entity.Login;
import com.Cerebro.View.LogInForm;

public class LogInFormTest {
	
	protected boolean value;

	@Before
	public void setUp() throws Exception {
		
		String e="df@gh.com",pass="dfsdf";
		
		value=new Login().validate(e,pass);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateInput() {  
		
		assertTrue(value==true);
	}

}
