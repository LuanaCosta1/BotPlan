package com.botplan.controller;

import com.botplan.entity.Task;
import com.botplan.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("tasks")
@Validated
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String addTask (@RequestParam String title
            , @RequestParam String description) {

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        taskRepository.save(task);
        return "Task saved";
    }
}
