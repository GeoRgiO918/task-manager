package com.georgiiHadzhiev.entity.task;

import com.georgiiHadzhiev.entity.GroupStatus;
import com.georgiiHadzhiev.entity.WorkGroup;

import javax.persistence.*;

@Entity
@Table(name = "group_status_change_task")
public class GroupStatusChangeTask extends Task{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id",nullable = false)
    private WorkGroup group;

    @Enumerated(EnumType.STRING)
    @Column(name = "new_status",length = 50,nullable = false)
    private GroupStatus newStatus;

    public WorkGroup getGroup() {
        return group;
    }

    public void setGroup(WorkGroup group) {
        this.group = group;
    }

    public GroupStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(GroupStatus newStatus) {
        this.newStatus = newStatus;
    }
}
