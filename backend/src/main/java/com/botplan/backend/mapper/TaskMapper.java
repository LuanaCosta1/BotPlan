package com.botplan.mapper;

import com.botplan.dto.EmployeeDTO;
import com.botplan.dto.TaskDTO;
import com.botplan.entity.Employee;
import com.botplan.entity.Task;
import com.botplan.request.EmployeeRequest;
import com.botplan.request.TaskRequest;

public class TaskMapper {
    private TaskMapper() {}

    public static TaskDTO toDto(Task task) {
        return TaskDTO.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .notes(task.getNotes())
                .points(task.getPoints())
                .state(task.getState())
                .priority(task.getPriority())
                .type(task.getType())
                .testerAssigned(task.getTesterAssigned())
                .creator(task.getCreator())
                .creationDate(task.getCreationDate())
                .conclusionDate(task.getConclusionDate())
                .idEmployee(task.getIdEmployee())
                .backupIdEmployee(task.getBackupIdEmployee())
                .build();
    }

    public static Task toEntity(TaskRequest request) {
        return Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .notes(request.getNotes())
                .points(request.getPoints())
                .state(request.getState())
                .priority(request.getPriority())
                .type(request.getType())
                .testerAssigned(request.getTesterAssigned())
                .creator(request.getCreator())
                .creationDate(request.getCreationDate())
                .conclusionDate(request.getConclusionDate())
                .idEmployee(request.getIdEmployee())
                .backupIdEmployee(request.getBackupIdEmployee())
                .build();
    }
}
