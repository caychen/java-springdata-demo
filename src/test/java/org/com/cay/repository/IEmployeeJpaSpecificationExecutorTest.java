package org.com.cay.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
import org.springframework.data.jpa.domain.Specification;

public class IEmployeeJpaSpecificationExecutorTest {

	private ApplicationContext ctx = null;
	private IEmployeeJpaSpecificationExecutor employeeJpaSpecificationExecutor = null;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("beans-new.xml");
		employeeJpaSpecificationExecutor = ctx.getBean(IEmployeeJpaSpecificationExecutor.class);
	}

	@After
	public void tearDown() {
		ctx = null;
	}
	
	/*
	 * 1) 分页
	 * 2) 排序
	 * 3) 查询：查询age大于50
	 */
	@Test
	public void testQuery(){
		Sort sort = new Sort(new Order(Direction.ASC, "id"));
	
		Pageable pageable = new PageRequest(0, 5, sort);
		
		Specification<Employee2> specification = new Specification<Employee2>() {

			/*
			 * Root:需要查询的类型
			 * CriteriaQuery:添加查询条件
			 * CriteriaBuilder:构建Predicate
			 */
			@Override
			public Predicate toPredicate(Root<Employee2> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				
				//root --> Employee2 --> age
				Path path = root.get("age");//从root能够获取age属性的路径
				return cb.gt(path, 50);
			}
		
		};
		
		Page<Employee2> page = employeeJpaSpecificationExecutor.findAll(specification, pageable);
		System.out.println(page.getContent());
	}

}
