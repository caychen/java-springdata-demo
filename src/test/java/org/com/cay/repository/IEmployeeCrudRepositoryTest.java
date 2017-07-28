package org.com.cay.repository;

import java.util.ArrayList;
import java.util.List;

import org.com.cay.entity.Employee2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IEmployeeCrudRepositoryTest {

	private ApplicationContext ctx = null;
	private IEmployeeCrudRepository employeeCrudRepository = null;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("beans-new.xml");
		employeeCrudRepository = ctx.getBean(IEmployeeCrudRepository.class);
	}

	@After
	public void tearDown() {
		ctx = null;
	}

	@Test
	public void testSave(){
		List<Employee2> employees = new ArrayList<Employee2>();
		
		Employee2 employee = null;
		for(int i = 0; i < 100; ++i){
			employee = new Employee2();
			employee.setUsername("test" + i);
			employee.setAge((int) (Math.random() * 50 + 10));
			employees.add(employee);
		}
		employeeCrudRepository.save(employees);
		
	}
	
}
