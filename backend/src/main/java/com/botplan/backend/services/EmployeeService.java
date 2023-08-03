package com.botplan.backend.services;

import com.botplan.backend.entity.Employee;
import com.botplan.backend.entity.Story;
import com.botplan.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployee(Long id){
        return employeeRepository.findByIdEmployee(id);
    }
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateStory(Employee employee, Long id){
        Employee entity = employeeRepository.findByIdEmployee(id);
        entity.setName(employee.getName());
        entity.setPicture(employee.getPicture());
        entity.setStack(employee.getStack());
        entity.setTechnologies(employee.getTechnologies());
        entity.setSeniority(employee.getSeniority());
        entity.setAdmin(employee.isAdmin());
        entity.setType(employee.getType());
        entity.setWorking(employee.isWorking());
        entity.setReasonWhyNotWorking(employee.getReasonWhyNotWorking());
        entity.setTaskAssigned(employee.getTaskAssigned());
        return employeeRepository.save(entity);
    }

    public void deleteEmployee(Long id) {
        Employee entity = employeeRepository.findByIdEmployee(id);
        employeeRepository.delete(entity);
    }

}
