package com.georgiiHadzhiev.dto;

import javax.validation.constraints.NotNull;

public class LoggingPayload  extends TaskPayload {

    @NotNull(message = "Log message can not be null")
    private String logMessage;

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}
