package com.georgiiHadzhiev.component.task.strategy.creation;

import com.georgiiHadzhiev.dto.EmployeeTransferPayload;
import com.georgiiHadzhiev.dto.LoggingPayload;
import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskPayload;
import com.georgiiHadzhiev.entity.Department;
import com.georgiiHadzhiev.entity.Worker;
import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.LoggingTask;
import com.georgiiHadzhiev.entity.task.Task;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class LoggingCreateStrategy implements TaskCreateStrategy{

    @Override
    public Class<? extends TaskPayload> getPayloadType() {
        return LoggingPayload.class;
    }

    @Override
    public Task create(TaskCreateRequest request) {
        LoggingTask task = new LoggingTask();
        if (!(request.getPayload() instanceof LoggingPayload)) {
            throw new IllegalArgumentException("Invalid payload type for Logging payload");
        }
        LoggingPayload payload = (LoggingPayload)request.getPayload();
        task.setLogMessage(payload.getLogMessage());
        return task;

    }
}
