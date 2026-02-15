package com.georgiiHadzhiev.dto;

public class EmployeeTransferPayload extends TaskPayload{

    Long workerId;
    Long departmentId;

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public EmployeeTransferPayload(Long workerId, Long departmentId) {
        this.workerId = workerId;
        this.departmentId = departmentId;
    }
}
