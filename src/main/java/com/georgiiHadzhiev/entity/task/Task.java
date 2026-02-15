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

    @Column(name = "description")
    private String description;

    @Column(name = "execute_time",nullable = false)
    private Instant executeTime;

    @Column(name = "is_executed",nullable = false)
    private Boolean isExecuted =false;

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
}
