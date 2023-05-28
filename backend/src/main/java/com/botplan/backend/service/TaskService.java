package com.botplan.service;

import com.botplan.dto.TaskDTO;
import com.botplan.entity.Employee;
import com.botplan.entity.Task;
import com.botplan.exception.EmployeeNotFoundException;
import com.botplan.mapper.TaskMapper;
import com.botplan.repository.EmployeeRepository;
import com.botplan.repository.TaskRepository;
import com.botplan.request.TaskRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;

    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<TaskDTO> getAll() {
        return taskRepository.findAll().stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TaskDTO create(TaskRequest request) {
        Employee employee = employeeRepository.findById(request.getIdEmployee())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with this id " + request.getIdEmployee() + " does not exist"));

        Task task = taskRepository.save(TaskMapper.toEntity(request));
        task.addEmployee(employee);

        return TaskMapper.toDto(task);
    }

    public TaskDTO update(TaskRequest task, Long id) {
        Task entity = taskRepository.getById(id);
        entity.setTitle(entity.getTitle());
        entity.setDescription(task.getDescription());
        entity.setNotes(task.getNotes());
        entity.setNotes(String.valueOf(task.getPoints()));
        entity.setState(task.getState());
        entity.setPriority(task.getPriority());
        entity.setType(task.getType());
        entity.setTesterAssigned(task.getTesterAssigned());
        entity.setCreator(task.getCreator());
        entity.setCreationDate(task.getCreationDate());
        entity.setConclusionDate(task.getConclusionDate());
        entity.setIdEmployee(task.getIdEmployee());
        entity.setBackupIdEmployee((long) task.getBackupIdEmployee());
        return TaskMapper.toDto(taskRepository.save(entity));
    }

    public Void delete(Long id) {
        Task entity = taskRepository.getById(id);
        taskRepository.delete(entity);
        return null;
    }
}
