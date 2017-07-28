package org.com.cay.repository;

import org.com.cay.entity.Employee2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IEmployeeJpaRepositoryTest {

	private ApplicationContext ctx = null;
	private IEmployeeJpaRepository employeeJpaRepository = null;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("beans-new.xml");
		employeeJpaRepository = ctx.getBean(IEmployeeJpaRepository.class);
	}

	@After
	public void tearDown() {
		ctx = null;
	}
	
	@Test
	public void testFind(){
		Employee2 one = employeeJpaRepository.findOne(34);
		System.out.println(one);
		
		System.out.println(employeeJpaRepository.exists(99));
		System.out.println(employeeJpaRepository.exists(103));
		
	}

}
