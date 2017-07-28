package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.Employee2;

public interface IEmployeeService {

	public void update(Integer id, Integer age);
	
	public void delete(Integer id);
	
	public void save(List<Employee2> employees);
}
