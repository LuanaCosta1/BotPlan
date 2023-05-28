package com.botplan.controller;

import com.botplan.dto.TaskDTO;
import com.botplan.request.TaskRequest;
import com.botplan.response.BaseResponse;
import com.botplan.service.TaskService;
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

@RestController
@AllArgsConstructor
@RequestMapping("tasks")
@Validated
public class TaskController {
    @Autowired
    private final TaskService taskService;

    @ApiOperation(value = "Get ALL Tasks", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get All was completed successfully"),
            @ApiResponse(code = 500, message = "Internal server error for: Tasks")
    } )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TaskDTO>> getAll() { return ResponseEntity.status(HttpStatus.OK).body(taskService.getAll()); }

    @ApiOperation(value = "Create a new Tasks", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created a new Tasks"),
            @ApiResponse(code = 404, message = "Employee not found")
    } )
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<TaskDTO>> add(@RequestBody @Validated TaskRequest request) {
        TaskDTO taskDTO = taskService.create(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/task/{id}")
                .buildAndExpand(taskDTO.getIdEmployee())
                .toUri();

        return ResponseEntity.created(uri).body(BaseResponse.<TaskDTO>builder()
                .httpCode(200)
                .message("Ok")
                .response(taskDTO)
                .build());
    }

    @ApiOperation(value = "Update an Task", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the Task"),
            @ApiResponse(code = 404, message = "Employee or Task not found")
    } )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse<TaskDTO>> update(@RequestBody @Validated TaskRequest request, @PathVariable("id") Long id) {
        TaskDTO taskDTO = taskService.update(request, id);

        return ResponseEntity.ok().body(
                BaseResponse.<TaskDTO>builder()
                        .httpCode(200)
                        .message("Ok")
                        .response(taskDTO)
                        .build());
    }

    @ApiOperation(value = "Delete an Task", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the Task"),
            @ApiResponse(code = 404, message = "Task not found")
    } )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(BaseResponse.<Void>builder()
                .httpCode(200)
                .message("Successfully deleted the Task")
                .response(taskService.delete(id))
                .build());
    }
}
