package com.georgiiHadzhiev.component.scheduler;

import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.entity.task.TaskStatus;
import com.georgiiHadzhiev.repository.TaskRepository;
import com.georgiiHadzhiev.service.TaskExecutionService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.OptimisticLockException;
import java.time.Instant;
import java.util.List;

@Component
public class TaskExecuteScheduler {

    private final TaskRepository taskRepository;
    private final TaskExecutionService executionService;

    public TaskExecuteScheduler(TaskRepository taskRepository, TaskExecutionService executionService) {
        this.taskRepository = taskRepository;
        this.executionService = executionService;
    }

    @Scheduled(fixedDelay = 10000)
    public void executeTasks(){
        List<Task> tasksToDo = taskRepository.findByIsExecutedFalseAndExecuteTimeBefore(Instant.now());
        for(Task task : tasksToDo) {
            try{
                executionService.execute(task);
            }catch (OptimisticLockException op){
                System.out.println("Task " + task.getId() +  " already completed by another instance - skip");
            } catch (Exception e) {
                task.setExecuted(true);
                task.setTaskStatus(TaskStatus.FAILED);
                task.setExecutedAt(Instant.now());
                task.setErrorText(e.getMessage());
                taskRepository.save(task);
            }
        }
    }
}
