package com.georgiiHadzhiev.dto;

import java.time.Instant;

public class TaskCreateRequest {


    Instant executeTime;

    TaskPayload payload;

    String description;

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
