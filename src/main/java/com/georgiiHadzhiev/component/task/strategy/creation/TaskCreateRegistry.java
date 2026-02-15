package com.georgiiHadzhiev.component.task.strategy.creation;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class TaskCreateRegistry {

    private final Map<Class<?>, TaskCreateStrategy> registry = new HashMap<>();


    public TaskCreateRegistry(List<TaskCreateStrategy> strategies) {
        for (TaskCreateStrategy strategy : strategies) {
            Class<?> payloadType = strategy.getPayloadType();
            if (registry.containsKey(payloadType)) {
                throw new IllegalStateException("Strategy for payload type " + payloadType + " already registered");
            }
            registry.put(payloadType, strategy);
        }
    }


    public TaskCreateStrategy getStrategyByPayloadType(Class<?> payloadType) {
        TaskCreateStrategy strategy = registry.get(payloadType);
        if (strategy == null) {
            throw new IllegalArgumentException("No TaskCreateStrategy registered for payload type: " + payloadType.getName());
        }
        return strategy;
    }
}
