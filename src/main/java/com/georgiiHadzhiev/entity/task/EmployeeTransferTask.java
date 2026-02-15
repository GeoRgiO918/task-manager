package com.georgiiHadzhiev.entity.task;

import com.georgiiHadzhiev.entity.Department;
import com.georgiiHadzhiev.entity.Worker;

import javax.persistence.*;

@Entity
@Table(name = "employee_transfer_task")
public class EmployeeTransferTask extends Task{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id",nullable = false)
    Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_department_id")
    Department newDepartment;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Department getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(Department newDepartment) {
        this.newDepartment = newDepartment;
    }
}
