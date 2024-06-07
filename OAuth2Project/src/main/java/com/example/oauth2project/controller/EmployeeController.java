package com.example.oauth2project.controller;


import com.example.oauth2project.ProjectRepository.EmployeeRepository;
import com.example.oauth2project.ProjectRepository.ProjectRepository;
import com.example.oauth2project.entity.Employee;
import com.example.oauth2project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/assign")
    public String showAssignPage(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        return "assign";
    }

    @PostMapping("/assign")
    public String assignEmployeeToProject(@RequestParam Long employeeId, @RequestParam Long projectId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        Project project = projectRepository.findById(projectId).orElseThrow();
        project.getEmployees().add(employee);
        projectRepository.save(project);
        return "redirect:/assign";
    }
}