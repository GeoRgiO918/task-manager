package com.georgiiHadzhiev.entity.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "logging_task")
public class LoggingTask  extends Task{

    @Column(name="log_message",length = 1000)
    private String logMessage;

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}
