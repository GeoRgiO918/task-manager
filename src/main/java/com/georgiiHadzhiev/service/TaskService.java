package com.georgiiHadzhiev.service;

import com.georgiiHadzhiev.component.task.TaskFactory;
import com.georgiiHadzhiev.component.task.strategy.mapper.TaskMapperRegistry;
import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskDto;
import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskFactory factory;
    private final TaskMapperRegistry mapperRegistry;

    public TaskService(TaskRepository repository, TaskFactory factory, TaskMapperRegistry mapperRegistry) {
        this.repository = repository;
        this.factory = factory;
        this.mapperRegistry = mapperRegistry;
    }

    @Transactional
    public TaskDto createTask(TaskCreateRequest request){

        Task task = factory.createFromRequest(request);
        task = repository.save(task);

        return mapperRegistry.getStrategyByTaskType(task.getClass()).toDto(task);
    }


    public TaskDto getTask(Long id){
        Optional<Task> task = repository.findById(id);
        return task.map(value -> mapperRegistry.getStrategyByTaskType(value.getClass()).toDto(value)).orElse(null);

    }
}
