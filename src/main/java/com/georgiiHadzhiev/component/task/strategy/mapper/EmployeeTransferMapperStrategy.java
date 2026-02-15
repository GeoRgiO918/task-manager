package com.georgiiHadzhiev.component.task.strategy.mapper;

import com.georgiiHadzhiev.dto.EmployeeTransferPayload;
import com.georgiiHadzhiev.dto.TaskDto;
import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.Task;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTransferMapperStrategy implements TaskMapperStrategy {

    @Override
    public TaskDto toDto(Task task) {
        if(!(task instanceof EmployeeTransferTask)){
            throw new IllegalStateException("Uncorrect taskType");
        }

        EmployeeTransferTask transferTask = (EmployeeTransferTask)task;
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setExecuteTime(task.getExecuteTime());
        taskDto.setExecuted(task.getIsExecuted());
        taskDto.setVersion(task.getVersion());
        EmployeeTransferPayload payload = new EmployeeTransferPayload();
        payload.setDepartmentId(transferTask.getNewDepartment().getId());
        payload.setWorkerId(transferTask.getWorker().getId());
        taskDto.setPayload(payload);

        return taskDto;
    }

    @Override
    public Class<? extends Task> getSupportedType() {
        return EmployeeTransferTask.class;
    }
}
