package com.botplan.backend.controller;

import com.botplan.backend.entity.Employee;
import com.botplan.backend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee add(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> selectAll(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) { return employeeService.getEmployee(id); }

    @PutMapping("/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable("id") Long id){
        return employeeService.updateStory(employee, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
