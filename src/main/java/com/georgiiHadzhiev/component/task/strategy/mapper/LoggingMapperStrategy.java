package com.georgiiHadzhiev.component.task.strategy.mapper;

import com.georgiiHadzhiev.dto.EmployeeTransferPayload;
import com.georgiiHadzhiev.dto.LoggingPayload;
import com.georgiiHadzhiev.dto.TaskDto;
import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.LoggingTask;
import com.georgiiHadzhiev.entity.task.Task;
import org.springframework.stereotype.Component;

@Component
public class LoggingMapperStrategy implements TaskMapperStrategy{
    @Override
    public Class<? extends Task> getSupportedType() {
        return LoggingTask.class;
    }

    //TODO: Вынести общую логику Task в деволт метод интерфейса
    @Override
    public TaskDto toDto(Task task) {
        if(!(task instanceof LoggingTask)){
            throw new IllegalStateException("Uncorrect taskType");
        }

        LoggingTask loggingTask = (LoggingTask)task;
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setExecuteTime(task.getExecuteTime());
        taskDto.setExecuted(task.getIsExecuted());
        taskDto.setVersion(task.getVersion());
        LoggingPayload payload = new LoggingPayload();
        payload.setLogMessage(loggingTask.getLogMessage());
        taskDto.setPayload(payload);

        return taskDto;
    }
}
