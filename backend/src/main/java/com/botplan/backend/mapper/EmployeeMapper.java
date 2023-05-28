package com.botplan.mapper;

import com.botplan.dto.EmployeeDTO;
import com.botplan.dto.EmployeeTasksDTO;
import com.botplan.entity.Employee;
import com.botplan.request.EmployeeRequest;

import java.util.stream.Collectors;

public class EmployeeMapper {
    private EmployeeMapper() {}

    public static EmployeeDTO toDto(Employee employee) {
        return EmployeeDTO.builder()
                .name(employee.getName())
                .picture(employee.getPicture())
                .stack(employee.getStack())
                .technologies(employee.getTechnologies())
                .seniority(employee.getSeniority())
                .admin(employee.isAdmin())
                .type(employee.getType())
                .isWorking(employee.isWorking())
                .reasonWhyNotWorking(employee.getReasonWhyNotWorking())
                .taskAssigned(employee.getTaskAssigned())
                .build();
    }


    public static EmployeeTasksDTO toEmployeeTasksDTO(Employee employee) {
        return EmployeeTasksDTO.builder()
                .name(employee.getName())
                .picture(employee.getPicture())
                .stack(employee.getStack())
                .technologies(employee.getTechnologies())
                .seniority(employee.getSeniority())
                .admin(employee.isAdmin())
                .type(employee.getType())
                .isWorking(employee.isWorking())
                .reasonWhyNotWorking(employee.getReasonWhyNotWorking())
                .tasks(employee.getTaskList().stream().map(TaskMapper::toDto).collect(Collectors.toList()))
                .build();
    }

    public static Employee toEntity(EmployeeRequest request) {
        return Employee.builder()
                .name(request.getName())
                .picture(request.getPicture())
                .stack(request.getStack())
                .technologies(request.getTechnologies())
                .seniority(request.getSeniority())
                .admin(request.isAdmin())
                .type(request.getType())
                .isWorking(request.isWorking())
                .reasonWhyNotWorking(request.getReasonWhyNotWorking())
                .build();
    }
}
