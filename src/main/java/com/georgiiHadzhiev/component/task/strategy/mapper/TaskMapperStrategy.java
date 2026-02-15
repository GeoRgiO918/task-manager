package com.georgiiHadzhiev.component.task.strategy.mapper;

import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskDto;
import com.georgiiHadzhiev.entity.task.Task;

public interface TaskMapperStrategy {

    public TaskDto  toDto(Task task);

    public Class<? extends Task> getSupportedType();
}
