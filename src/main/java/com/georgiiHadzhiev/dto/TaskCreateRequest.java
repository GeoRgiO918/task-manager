package com.georgiiHadzhiev.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

public class TaskCreateRequest {


    @NotNull(message = "executeTime cannot be null")
    private Instant executeTime;

    @NotNull(message = "payload cannot be null")
    @Valid
    private TaskPayload payload;

    @Size(max = 1000, message = "description must be at most 500 characters")
    private String description;

    public Instant getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Instant executeTime) {
        this.executeTime = executeTime;
    }

    public TaskPayload getPayload() {
        return payload;
    }

    public void setPayload(TaskPayload payload) {
        this.payload = payload;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskCreateRequest(Instant executeTime, TaskPayload payload, String description) {
        this.executeTime = executeTime;
        this.payload = payload;
        this.description = description;
    }
}
