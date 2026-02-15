package com.georgiiHadzhiev.controller;

import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskDto;
import com.georgiiHadzhiev.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskCreateRequest request) {
        TaskDto dto = taskService.createTask(request);;
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id){
        TaskDto dto = taskService.getTask(id);
        if(dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<TaskDto>> getAllTask(Pageable pageable){
        Page<TaskDto> taskDto = taskService.getAll(pageable);
        if(taskDto.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskDto);
    }

}
