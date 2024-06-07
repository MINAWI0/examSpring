package com.example.oauth2project.service;

import com.example.oauth2project.ProjectRepository.EmployeeRepository;
import com.example.oauth2project.ProjectRepository.ProjectRepository;
import com.example.oauth2project.entity.Employee;
import com.example.oauth2project.entity.Project;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Transactional
    public void assignEmployeesToProject(Long projectId, List<Long> employeeIds) {
        // Find the project by its ID
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));

        // Find all employees by their IDs
        List<Employee> employees = employeeRepository.findAllById(employeeIds);

        // Assign the employees to the project
        project.setEmployees(employees);

        // Save the updated project
        projectRepository.save(project);
    }
}