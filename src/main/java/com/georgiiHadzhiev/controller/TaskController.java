package com.georgiiHadzhiev.controller;

import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    @PostMapping()
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskCreateRequest request) throws Exception {
        request = request;
        return ResponseEntity.ok().build();
    }

}
