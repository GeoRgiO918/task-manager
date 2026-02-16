package com.georgiiHadzhiev.service;

import com.georgiiHadzhiev.component.task.strategy.execution.TaskExecuteStrategy;
import com.georgiiHadzhiev.component.task.strategy.execution.TaskExecutionRegistry;
import com.georgiiHadzhiev.entity.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskExecutionService {


    public final TaskExecutionRegistry registry;

    public TaskExecutionService(TaskExecutionRegistry registry) {
        this.registry = registry;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void execute(Task task){
        TaskExecuteStrategy strategy = registry.getStrategyByTaskType(task.getClass());
        strategy.execute(task);
    }
}
