package org.com.cay.repository;

import java.util.List;

import org.com.cay.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

public class IEmployeeRepositoryTest {
	private ApplicationContext ctx = null;
	private IEmployeeRepository employeeRepository = null;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("beans-new.xml");
		employeeRepository = ctx.getBean(IEmployeeRepository.class);
	}

	@After
	public void tearDown() {
		ctx = null;
	}

	@Test
	public void testFindByUsername(){
		Employee employee = employeeRepository.findByUsername("zhangsan");
		System.out.println(JSON.toJSONString(employee));
	}
	
	@Test
	public void testFindByUsernameStartingWithAndAgeLessThan(){
		List<Employee> employees = employeeRepository.findByUsernameStartingWithAndAgeLessThan("test", 23);
		System.out.println(JSON.toJSONString(employees));
	}
	
	@Test
	public void testFindByUsernameEndingWithAndAgeLessThan(){
		List<Employee> employees = employeeRepository.findByUsernameEndingWithAndAgeLessThan("6", 23);
		System.out.println(JSON.toJSONString(employees));
	}
	
	@Test
	public void testFindByUsernameInOrAgeGreaterThan(){
		String[] usernames = new String[]{"test1", "test4", "test8"};
		List<Employee> employees = employeeRepository.findByUsernameInOrAgeGreaterThan(usernames, 22);
		System.out.println(JSON.toJSONString(employees));
	}
	
	@Test
	public void testFindByAgeBetween(){
		List<Employee> employees = employeeRepository.findByAgeBetween(20, 22);
		System.out.println(JSON.toJSONString(employees));
	}
	
	@Test
	public void testGetEmployeeByMaxId(){
		Employee employee = employeeRepository.getEmployeeByMaxId();
		System.out.println(JSON.toJSONString(employee));
	}
	
	@Test
	public void testGetEmployeeByUsernameAndAge1(){
		Employee employee = employeeRepository.getEmployeeByUsernameAndAge1("test16", 25);
		System.out.println(JSON.toJSONString(employee));
	}
	
	@Test
	public void testGetEmployeeByUsernameAndAge2(){
		Employee employee = employeeRepository.getEmployeeByUsernameAndAge2("test16", 25);
		System.out.println(JSON.toJSONString(employee));
	}
	
	@Test
	public void testGetEmployeeLike1(){
		List<Employee> employees = employeeRepository.getEmployeeLike1("test");
		System.out.println(JSON.toJSONString(employees));
	}
	
	@Test
	public void testGetEmployeeLike2(){
		List<Employee> employees = employeeRepository.getEmployeeLike2("test1");
		System.out.println(JSON.toJSONString(employees));
	}
	
	@Test
	public void testGetCount(){
		long rows = employeeRepository.getCount();
		System.out.println(rows);
	}
	
	
}
