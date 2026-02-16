package com.georgiiHadzhiev.component.task.strategy.mapper;

import com.georgiiHadzhiev.dto.EmployeeTransferPayload;
import com.georgiiHadzhiev.dto.GroupStatusChangePayload;
import com.georgiiHadzhiev.dto.TaskDto;
import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.GroupStatusChangeTask;
import com.georgiiHadzhiev.entity.task.Task;
import org.springframework.stereotype.Component;

@Component
public class GroupStatusChangeMapperStrategy implements TaskMapperStrategy {

    @Override
    public TaskDto toDto(Task task) {
        if(!(task instanceof GroupStatusChangeTask)){
            throw new IllegalStateException("Uncorrect taskType");
        }

        GroupStatusChangeTask gscTask = (GroupStatusChangeTask)task;
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setExecuteTime(task.getExecuteTime());
        taskDto.setExecuted(task.getIsExecuted());
        taskDto.setVersion(task.getVersion());
        GroupStatusChangePayload payload = new GroupStatusChangePayload();
        payload.setGroupId(gscTask.getGroup().getId());
        payload.setNewStatus(gscTask.getNewStatus());
        taskDto.setPayload(payload);

        return taskDto;
    }

    @Override
    public Class<? extends Task> getSupportedType() {
        return GroupStatusChangeTask.class;
    }
}
