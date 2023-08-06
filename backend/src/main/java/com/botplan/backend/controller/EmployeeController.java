package com.botplan.backend.controller;

import com.botplan.backend.dto.EmployeeDTO;
import com.botplan.backend.entity.Employee;
import com.botplan.backend.response.BaseResponse;
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
    public BaseResponse<EmployeeDTO> add(@RequestBody Employee employee){
        return BaseResponse.<EmployeeDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(employeeService.addEmployee(employee)).build();
    }

    @GetMapping("/")
    public BaseResponse<List<EmployeeDTO>> selectAll(){
        return BaseResponse.<List<EmployeeDTO>>builder()
                .httpCode(200)
                .message("OK")
                .response(employeeService.getAllEmployees()).build();
    }

    @GetMapping("/{id}")
    public BaseResponse<EmployeeDTO> getEmployee(@PathVariable("id") Long id) {
        return BaseResponse.<EmployeeDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(employeeService.getEmployee(id))
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<EmployeeDTO> update(@RequestBody Employee employee, @PathVariable("id") Long id){
        return BaseResponse.<EmployeeDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(employeeService.updateStory(employee, id)).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
