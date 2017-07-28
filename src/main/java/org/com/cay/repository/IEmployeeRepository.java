package org.com.cay.repository;

import java.util.List;

import org.com.cay.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends Repository<Employee, Integer> {

	public Employee findByUsername(String username);
	
	public List<Employee> findByUsernameStartingWithAndAgeLessThan(String username, int age);
	
	public List<Employee> findByUsernameEndingWithAndAgeLessThan(String username, int age);
	
	public List<Employee> findByUsernameInOrAgeGreaterThan(String[] usernames, int age);
	
	public List<Employee> findByAgeBetween(int minAge, int maxAge);
	
	@Query("from Employee where id = (select max(id) from Employee)")
	public Employee getEmployeeByMaxId();
	
	@Query("from Employee where username=?1 and age =?2")
	public Employee getEmployeeByUsernameAndAge1(String username, int age);
	
	@Query("from Employee where username=:name and age =:age")
	public Employee getEmployeeByUsernameAndAge2(@Param("name")String username, @Param("age") int age);
	
	@Query("from Employee where username like %?1%")
	public List<Employee> getEmployeeLike1(String username);
	
	@Query("from Employee where username like %:name%")
	public List<Employee> getEmployeeLike2(@Param("name")String username);
	
	@Query(nativeQuery=true, value="select count(id) from employee")
	public long getCount();
	
	@Modifying
	@Query("update Employee e set e.age = :age where e.id = :id")
	public void update(@Param("id")Integer id, @Param("age")int age);
	
	@Modifying
	@Query("delete from Employee where id = ?1")
	public void delete(Integer id);
}
