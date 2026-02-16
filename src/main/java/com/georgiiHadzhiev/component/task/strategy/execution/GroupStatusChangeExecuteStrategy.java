package com.georgiiHadzhiev.component.task.strategy.execution;

import com.georgiiHadzhiev.entity.Department;
import com.georgiiHadzhiev.entity.WorkGroup;
import com.georgiiHadzhiev.entity.Worker;
import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.GroupStatusChangeTask;
import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.entity.task.TaskStatus;
import com.georgiiHadzhiev.repository.DepartmentRepository;
import com.georgiiHadzhiev.repository.TaskRepository;
import com.georgiiHadzhiev.repository.WorkGroupRepository;
import com.georgiiHadzhiev.repository.WorkerRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Configuration
public class GroupStatusChangeExecuteStrategy implements TaskExecuteStrategy{

    public final WorkGroupRepository workGroupRepository;
    public final TaskRepository taskRepository;


    public GroupStatusChangeExecuteStrategy(WorkGroupRepository workGroupRepository, TaskRepository taskRepository) {
        this.workGroupRepository = workGroupRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public void execute(Task task) {
        if(!(task instanceof GroupStatusChangeTask)){
            throw new IllegalStateException("Uncorrect task type");
        }
        GroupStatusChangeTask statusChangeTask = (GroupStatusChangeTask) task;
        WorkGroup group = workGroupRepository.findById(statusChangeTask.getGroup().getId())
                .orElseThrow(() -> new IllegalStateException("Work group not found"));

        group.setStatus(statusChangeTask.getNewStatus());
        group.setChangeDate(Instant.now());
        group.setChangedByTask(statusChangeTask);
        workGroupRepository.save(group);
        task.setExecutedAt(Instant.now());
        task.setTaskStatus(TaskStatus.COMPLETED);
        task.setIsExecuted(true);
        taskRepository.save(task);

    }

    @Override
    public Class<? extends Task> getSupportedType() {
        return GroupStatusChangeTask.class;
    }
}
