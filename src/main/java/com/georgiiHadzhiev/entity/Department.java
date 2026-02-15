package com.georgiiHadzhiev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department extends BaseEntity  {

    private String name;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private List<Worker> workers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
