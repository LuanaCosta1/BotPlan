package com.botplan.backend.mapper;

import com.botplan.backend.dto.EmployeeDTO;
import com.botplan.backend.entity.Employee;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeDTO dto) {
        return Employee.builder()
                .name(dto.getName())
                .picture(dto.getPicture())
                .stack(dto.getStack())
                .technologies(dto.getTechnologies())
                .seniority(dto.getSeniority())
                .admin(dto.isAdmin())
                .type(dto.getType())
                .isWorking(dto.isWorking())
                .reasonWhyNotWorking(dto.getReasonWhyNotWorking())
                .taskAssigned(dto.getTaskAssigned())
                .build();
    }

    public static EmployeeDTO toDto(Employee entity) {
        return EmployeeDTO.builder()
                .name(entity.getName())
                .picture(entity.getPicture())
                .stack(entity.getStack())
                .technologies(entity.getTechnologies())
                .seniority(entity.getSeniority())
                .admin(entity.isAdmin())
                .type(entity.getType())
                .isWorking(entity.isWorking())
                .reasonWhyNotWorking(entity.getReasonWhyNotWorking())
                .taskAssigned(entity.getTaskAssigned())
                .build();
    }
}
