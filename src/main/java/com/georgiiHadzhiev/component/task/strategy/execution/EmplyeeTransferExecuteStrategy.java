package com.georgiiHadzhiev.component.task.strategy.execution;

import com.georgiiHadzhiev.entity.Department;
import com.georgiiHadzhiev.entity.Worker;
import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.entity.task.TaskStatus;
import com.georgiiHadzhiev.repository.DepartmentRepository;
import com.georgiiHadzhiev.repository.TaskRepository;
import com.georgiiHadzhiev.repository.WorkerRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Configuration
public class EmplyeeTransferExecuteStrategy implements TaskExecuteStrategy{

    public final WorkerRepository workerRepository;
    public final DepartmentRepository departmentRepository;
    public final TaskRepository taskRepository;


    public EmplyeeTransferExecuteStrategy(WorkerRepository workerRepository, DepartmentRepository departmentRepository, TaskRepository taskRepository) {
        this.workerRepository = workerRepository;
        this.departmentRepository = departmentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public void execute(Task task) {
        if(!(task instanceof EmployeeTransferTask)){
            throw new IllegalStateException("Uncorrect task type");
        }
        EmployeeTransferTask transferTask = (EmployeeTransferTask) task;
        Worker worker = workerRepository.findById(transferTask.getWorker().getId())
                .orElseThrow(() -> new IllegalStateException("Worker not found"));

        Department department = departmentRepository.findById(transferTask.getNewDepartment().getId())
                .orElseThrow(() -> new IllegalStateException("Department not found"));
        worker.setDepartment(department);
        workerRepository.save(worker);
        task.setExecutedAt(Instant.now());
        task.setTaskStatus(TaskStatus.COMPLETED);
        task.setIsExecuted(true);
        taskRepository.save(task);

    }

    @Override
    public Class<? extends Task> getSupportedType() {
        return EmployeeTransferTask.class;
    }
}
