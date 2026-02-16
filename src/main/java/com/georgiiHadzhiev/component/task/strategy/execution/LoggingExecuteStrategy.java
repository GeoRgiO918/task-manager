package com.georgiiHadzhiev.component.task.strategy.execution;

import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.LoggingTask;
import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.entity.task.TaskStatus;
import com.georgiiHadzhiev.repository.TaskRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class LoggingExecuteStrategy implements TaskExecuteStrategy{

    private final TaskRepository taskRepository;

    public LoggingExecuteStrategy(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void execute(Task task) {
        if(!(task instanceof LoggingTask)){
            throw new IllegalStateException("Uncorrect task type");
        }
        LoggingTask loggingTask = (LoggingTask) task;
        task.setExecutedAt(Instant.now());
        task.setTaskStatus(TaskStatus.COMPLETED);
        task.setIsExecuted(true);
        System.out.println();
        System.out.println("==========================================");
        System.out.println("🔔 НАПОМИНАНИЕ");
        System.out.println("------------------------------------------");
        System.out.println(loggingTask.getLogMessage());
        System.out.println("==========================================");
        System.out.println();
        taskRepository.save(task);

    }

    @Override
    public Class<? extends Task> getSupportedType() {
        return LoggingTask.class;
    }
}
