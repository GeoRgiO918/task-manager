package com.georgiiHadzhiev.component.task.strategy.creation;

import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskPayload;
import com.georgiiHadzhiev.entity.task.Task;

public interface TaskCreateStrategy {

    public Task create(TaskCreateRequest request);

    public Class<? extends TaskPayload> getPayloadType();
}
