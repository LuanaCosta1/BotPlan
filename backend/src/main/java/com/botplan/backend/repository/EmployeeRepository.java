package com.botplan.backend.repository;

import com.botplan.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByIdEmployee(Long id);
}
