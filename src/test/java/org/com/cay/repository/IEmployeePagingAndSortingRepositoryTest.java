package org.com.cay.repository;

import org.com.cay.entity.Employee2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class IEmployeePagingAndSortingRepositoryTest {

	private ApplicationContext ctx = null;
	private IEmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("beans-new.xml");
		employeePagingAndSortingRepository = ctx.getBean(IEmployeePagingAndSortingRepository.class);
	}

	@After
	public void tearDown() {
		ctx = null;
	}
	
	@Test
	public void testPageAndSort(){
		
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		
		//page:index从0开始
		//size:每页多少条数据
		Pageable pageable = new PageRequest(0, 5, sort);
		Page<Employee2> page = employeePagingAndSortingRepository.findAll(pageable);
		
		System.out.println("总页数：" + page.getTotalPages());
		System.out.println("总记录数：" + page.getTotalElements());
		System.out.println("当前第几页：" + (page.getNumber() + 1));
		System.out.println("当前页面记录数：" + page.getNumberOfElements());
		System.out.println("当前页面集合：" + page.getContent());
	}

}
