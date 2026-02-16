package com.georgiiHadzhiev.component.task.strategy.execution;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TaskExecutionRegistry {


    private final Map<Class<?>, TaskExecuteStrategy> registry = new HashMap<>();


    public TaskExecutionRegistry(List<TaskExecuteStrategy> strategies) {
        for (TaskExecuteStrategy strategy : strategies) {
            Class<?> payloadType = strategy.getSupportedType();
            if (registry.containsKey(payloadType)) {
                throw new IllegalStateException("Strategy for task type " + payloadType + " already registered");
            }
            registry.put(payloadType, strategy);
        }
    }


    public TaskExecuteStrategy getStrategyByTaskType(Class<?> taskType) {
        TaskExecuteStrategy strategy = registry.get(taskType);
        if (strategy == null) {
            throw new IllegalArgumentException("No TaskMapperStrategy registered for type: " + taskType.getName());
        }
        return strategy;
    }

}
