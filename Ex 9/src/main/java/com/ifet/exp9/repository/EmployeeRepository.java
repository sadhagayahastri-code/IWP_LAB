package com.ifet.exp9.repository;

import com.ifet.exp9.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
