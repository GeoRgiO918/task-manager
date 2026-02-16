package com.georgiiHadzhiev.dto;

import javax.validation.constraints.NotNull;

public class EmployeeTransferPayload extends TaskPayload{

    @NotNull(message = "WorkerId can not be null")
    Long workerId;

    @NotNull(message = "DepartmentId can not be null")
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


}
