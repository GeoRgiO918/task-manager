package com.georgiiHadzhiev.repository;

import com.georgiiHadzhiev.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

    public Task save(Task task);
}
