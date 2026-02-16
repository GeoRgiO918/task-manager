package com.georgiiHadzhiev.component.task;

import com.georgiiHadzhiev.component.task.strategy.creation.TaskCreateRegistry;
import com.georgiiHadzhiev.component.task.strategy.creation.TaskCreateStrategy;
import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.entity.task.TaskStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskFactory {

    private final TaskCreateRegistry creationRegistry;

    public TaskFactory(TaskCreateRegistry creationRegistry) {
        this.creationRegistry = creationRegistry;
    }

    @Transactional
    public Task createFromRequest(TaskCreateRequest request){
        if (request.getPayload() == null) {
            throw new IllegalArgumentException("Payload cannot be null");
        }

        TaskCreateStrategy createStrategy = creationRegistry.getStrategyByPayloadType(request.getPayload().getClass());
        Task task = createStrategy.create(request);
        task.setExecuteTime(request.getExecuteTime());
        task.setIsExecuted(false);
        task.setDescription(request.getDescription());
        task.setTaskStatus(TaskStatus.SCHEDULED);
        return task;
    }


}
