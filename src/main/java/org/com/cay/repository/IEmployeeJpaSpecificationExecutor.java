package org.com.cay.repository;

import org.com.cay.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEmployeeJpaSpecificationExecutor extends JpaSpecificationExecutor<Employee2>, JpaRepository<Employee2, Integer> {

}
