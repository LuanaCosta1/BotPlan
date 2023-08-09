package com.botplan.backend.services;

import com.botplan.backend.dto.EmployeeDTO;
import com.botplan.backend.entity.Employee;
import com.botplan.backend.mapper.EmployeeMapper;
import com.botplan.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO getEmployee(Long id){
        return EmployeeMapper.toDto(employeeRepository.findByIdEmployee(id));
    }

    public EmployeeDTO addEmployee(Employee employee){
        return EmployeeMapper.toDto(employeeRepository.save(employee));
    }

    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    public EmployeeDTO updateStory(Employee employee, Long id){
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
        return EmployeeMapper.toDto(employeeRepository.save(entity));
    }

    public void deleteEmployee(Long id) {
        Employee entity = employeeRepository.findByIdEmployee(id);
        employeeRepository.delete(entity);
    }

}
