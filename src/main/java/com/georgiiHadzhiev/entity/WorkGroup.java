package com.georgiiHadzhiev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "work_group")
public class WorkGroup extends BaseEntity {

    private String name;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    @OneToMany(mappedBy = "group",fetch = FetchType.LAZY)
    private List<Worker> workers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupStatus getStatus() {
        return status;
    }

    public void setStatus(GroupStatus status) {
        this.status = status;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
