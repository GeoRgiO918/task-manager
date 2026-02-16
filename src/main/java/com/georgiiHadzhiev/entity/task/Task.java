package com.georgiiHadzhiev.entity.task;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "execute_time",nullable = false)
    private Instant executeTime;

    @Column(name = "is_executed",nullable = false)
    private Boolean isExecuted =false;

    @Column(name = "executed_at",nullable = false)
    private Instant executedAt;

    @Column(name = "task_status",nullable = false,length = 50)
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus = TaskStatus.SCHEDULED;

    @Column(name = "error_text",length = 500)
    private String errorText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Instant executeTime) {
        this.executeTime = executeTime;
    }

    public Boolean getIsExecuted() {
        return isExecuted;
    }

    public void setIsExecuted(Boolean isExecuted) {
        this.isExecuted = isExecuted;
    }

    public void setExecuted(Boolean executed) {
        isExecuted = executed;
    }

    public Instant getExecutedAt() {
        return executedAt;
    }

    public void setExecutedAt(Instant executedAt) {
        this.executedAt = executedAt;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
