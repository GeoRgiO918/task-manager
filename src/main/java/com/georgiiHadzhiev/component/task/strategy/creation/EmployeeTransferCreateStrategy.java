package com.georgiiHadzhiev.component.task.strategy.creation;

import com.georgiiHadzhiev.dto.EmployeeTransferPayload;
import com.georgiiHadzhiev.dto.TaskCreateRequest;
import com.georgiiHadzhiev.dto.TaskPayload;
import com.georgiiHadzhiev.entity.Department;
import com.georgiiHadzhiev.entity.Worker;
import com.georgiiHadzhiev.entity.task.EmployeeTransferTask;
import com.georgiiHadzhiev.entity.task.Task;
import com.georgiiHadzhiev.repository.DepartmentRepository;
import com.georgiiHadzhiev.repository.WorkerRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class EmployeeTransferCreateStrategy implements TaskCreateStrategy {

    private final DepartmentRepository departmentRepository;
    private final WorkerRepository workerRepository;

    public EmployeeTransferCreateStrategy(DepartmentRepository departmentRepository, WorkerRepository workerRepository) {
        this.departmentRepository = departmentRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public Task create(TaskCreateRequest request) {
        EmployeeTransferTask task = new EmployeeTransferTask();
        if (!(request.getPayload() instanceof EmployeeTransferPayload)) {
            throw new IllegalArgumentException("Invalid payload type for EmployeeTransferTask");
        }
        EmployeeTransferPayload payload = (EmployeeTransferPayload)request.getPayload();
        Department department = departmentRepository.findById(payload.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        Worker worker = workerRepository.findById(payload.getWorkerId())
                .orElseThrow(() -> new EntityNotFoundException("Worker not found"));;
        task.setNewDepartment(department);
        task.setWorker(worker);
        return task;
    }

    @Override
    public Class<? extends TaskPayload> getPayloadType() {
        return EmployeeTransferPayload.class;
    }
}
