package org.com.cay.repository;

import org.com.cay.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeJpaRepository extends JpaRepository<Employee2, Integer> {

}
