package com.georgiiHadzhiev.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmployeeTransferPayload.class, name = "EMPLOYEE_TRANSFER"),
        @JsonSubTypes.Type(value = LoggingPayload.class, name = "LOGGING"),
        @JsonSubTypes.Type(value = GroupStatusChangePayload.class, name = "GROUP_STATUS_CHANGE"),
})
public abstract class TaskPayload {
}
