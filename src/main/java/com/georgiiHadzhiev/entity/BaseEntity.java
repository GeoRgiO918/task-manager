package com.georgiiHadzhiev.entity;

import com.georgiiHadzhiev.entity.task.Task;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by_task_id")
    Task changedByTask;

    @Column(name = "change_date")
    Instant changeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getChangedByTask() {
        return changedByTask;
    }

    public void setChangedByTask(Task changedByTask) {
        this.changedByTask = changedByTask;
    }

    public Instant getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Instant changeDate) {
        this.changeDate = changeDate;
    }


}
