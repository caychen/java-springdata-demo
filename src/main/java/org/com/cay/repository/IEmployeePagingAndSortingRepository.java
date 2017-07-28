package org.com.cay.repository;

import org.com.cay.entity.Employee2;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee2, Integer> {

}
