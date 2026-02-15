package com.georgiiHadzhiev.component.task.strategy.mapper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TaskMapperRegistry {


    private final Map<Class<?>, TaskMapperStrategy> registry = new HashMap<>();


    public TaskMapperRegistry(List<TaskMapperStrategy> strategies) {
        for (TaskMapperStrategy strategy : strategies) {
            Class<?> payloadType = strategy.getSupportedType();
            if (registry.containsKey(payloadType)) {
                throw new IllegalStateException("Strategy for task type " + payloadType + " already registered");
            }
            registry.put(payloadType, strategy);
        }
    }


    public TaskMapperStrategy getStrategyByTaskType(Class<?> taskType) {
        TaskMapperStrategy strategy = registry.get(taskType);
        if (strategy == null) {
            throw new IllegalArgumentException("No TaskMapperStrategy registered for type: " + taskType.getName());
        }
        return strategy;
    }
}
