package com.georgiiHadzhiev.component.task.strategy.creation;

import com.georgiiHadzhiev.dto.EmployeeTransferPayload;
import com.georgiiHadzhiev.dto.GroupStatusChangePayload;
import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskPayload;
import com.georgiiHadzhiev.entity.WorkGroup;
import com.georgiiHadzhiev.entity.task.GroupStatusChangeTask;
import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.repository.WorkGroupRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class GroupStatusChangeCreateStrategy implements TaskCreateStrategy {

    private final WorkGroupRepository workGroupRepository;

    public GroupStatusChangeCreateStrategy(WorkGroupRepository workGroupRepository) {
        this.workGroupRepository = workGroupRepository;
    }

    @Override
    public Task create(TaskCreateRequest request) {
        GroupStatusChangeTask task = new GroupStatusChangeTask();
        if (!(request.getPayload() instanceof GroupStatusChangePayload)) {
            throw new IllegalArgumentException("Invalid payload type for GroupStatusChangeTask");
        }
        GroupStatusChangePayload payload = (GroupStatusChangePayload)request.getPayload();

        WorkGroup group = workGroupRepository.findById(payload.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("Work group not found"));;
        task.setGroup(group);
        task.setNewStatus(payload.getNewStatus());
        return task;
    }

    @Override
    public Class<? extends TaskPayload> getPayloadType() {
        return GroupStatusChangePayload.class;
    }
}
