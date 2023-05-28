package com.botplan.service;

import com.botplan.dto.EmployeeDTO;
import com.botplan.dto.EmployeeTasksDTO;
import com.botplan.entity.Employee;
import com.botplan.mapper.EmployeeMapper;
import com.botplan.repository.EmployeeRepository;
import com.botplan.repository.TaskRepository;
import com.botplan.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    public List<EmployeeTasksDTO> getAll() {
        return  employeeRepository.findAll().stream()
                .map(EmployeeMapper::toEmployeeTasksDTO)
                .collect(Collectors.toList());
    }
    public EmployeeDTO update(EmployeeRequest employee, Long id) {
        Employee entity = employeeRepository.getById(id);
        entity.setName(employee.getName());
        entity.setPicture(employee.getPicture());
        entity.setStack(employee.getStack());
        entity.setTechnologies(employee.getTechnologies());
        entity.setSeniority(employee.getSeniority());
        entity.setAdmin(employee.isAdmin());
        entity.setType(employee.getType());
        entity.setWorking(employee.isWorking());
        entity.setReasonWhyNotWorking(employee.getReasonWhyNotWorking());
        entity.setTaskList(employee.getTaskAssigned());
        return EmployeeMapper.toDto(employeeRepository.save(entity));
    }

    public Employee create(EmployeeRequest request) {
        return employeeRepository.save(EmployeeMapper.toEntity(request));
    }

    public Void delete(Long id) {
        Employee entity = employeeRepository.getById(id);
        employeeRepository.delete(entity);
        return null;
    }
}
