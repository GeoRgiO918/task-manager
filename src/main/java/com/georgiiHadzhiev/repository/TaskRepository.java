package com.georgiiHadzhiev.repository;

import com.georgiiHadzhiev.entity.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    public List<Task> findByIsExecutedFalseAndExecuteTimeBefore(Instant date);

}
