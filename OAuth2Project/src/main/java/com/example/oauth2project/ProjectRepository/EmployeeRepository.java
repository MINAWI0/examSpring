package com.example.oauth2project.ProjectRepository;

import com.example.oauth2project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
