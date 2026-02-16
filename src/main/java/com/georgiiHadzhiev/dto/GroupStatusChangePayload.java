package com.georgiiHadzhiev.dto;

import com.georgiiHadzhiev.entity.GroupStatus;

import javax.validation.constraints.NotNull;

public class GroupStatusChangePayload extends TaskPayload{

    @NotNull( message = "GroupId can not be null")
    private Long groupId;

    @NotNull(message = "Status can not be null")
    private GroupStatus newStatus;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public GroupStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(GroupStatus newStatus) {
        this.newStatus = newStatus;
    }
}
