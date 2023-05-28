package com.botplan.controller;

import com.botplan.dto.EmployeeDTO;
import com.botplan.dto.EmployeeTasksDTO;
import com.botplan.entity.Employee;
import com.botplan.repository.EmployeeRepository;
import com.botplan.request.EmployeeRequest;
import com.botplan.response.BaseResponse;
import com.botplan.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(tags = "Employee Controller", consumes = "application/json")
@RestController
@AllArgsConstructor
@RequestMapping("employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    @ApiOperation(value = "Get ALL Employees", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get All was completed successfully"),
            @ApiResponse(code = 500, message = "Internal server error for: Employees")
    } )
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmployeeTasksDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    };


    @ApiOperation(value = "Create a new Employee", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new Employee"),
            @ApiResponse(code = 404, message = "Task not found")
    } )
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<Employee>> add(@RequestBody @Validated EmployeeRequest request) {
        Employee employee = employeeService.create(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/employee/{id}")
                .buildAndExpand(employee.getIdEmployee())
                .toUri();

        return ResponseEntity.created(uri).body(BaseResponse.<Employee>builder()
                .httpCode(200)
                .message("Ok")
                .response(employee)
                .build());
    }

    @ApiOperation(value = "Update an Employee info", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the Employee"),
            @ApiResponse(code = 404, message = "Task not found")
    } )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse<EmployeeDTO>> update(@RequestBody EmployeeRequest request, @PathVariable("id") Long id) {
        EmployeeDTO employee = employeeService.update(request,id);

        return ResponseEntity.ok().body(BaseResponse.<EmployeeDTO>builder()
                .httpCode(200)
                .message("Ok")
                .response(employee)
                .build());
    }

    @ApiOperation(value = "Delete an Employee", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the Employee"),
            @ApiResponse(code = 204, message = "Successfully deleted the Employee but returned No Content"),
            @ApiResponse(code = 404, message = "Employee not found")
    } )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(BaseResponse.<Void>builder()
                .httpCode(200)
                .message("Successfully deleted the Employee")
                .response(employeeService.delete(id))
                .build());
    }
}
