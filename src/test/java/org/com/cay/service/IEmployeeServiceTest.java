package org.com.cay.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IEmployeeServiceTest {

	private ApplicationContext ctx = null;
	private IEmployeeService employeeService = null;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("beans-new.xml");
		employeeService = ctx.getBean(IEmployeeService.class);
	}

	@After
	public void tearDown() {
		ctx = null;
	}
	
	@Test
	public void testUpdate(){
		employeeService.update(1, 20);
	}
	
	@Test
	public void testDelete(){
		employeeService.delete(3);
	}
	
}
