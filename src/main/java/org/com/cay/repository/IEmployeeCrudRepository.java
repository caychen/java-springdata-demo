package org.com.cay.repository;

import org.com.cay.entity.Employee2;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeCrudRepository extends CrudRepository<Employee2, Integer> {

}
