package org.com.cay.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.com.cay.entity.Employee2;
import org.com.cay.repository.IEmployeeCrudRepository;
import org.com.cay.repository.IEmployeeRepository;
import org.com.cay.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Autowired
	private IEmployeeCrudRepository employeeCrudRepository;

	@Override
	@Transactional
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		employeeRepository.update(id, age);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.delete(id);
	}

	@Override
	public void save(List<Employee2> employees) {
		// TODO Auto-generated method stub
		employeeCrudRepository.save(employees);
	}
	
}
