package com.georgiiHadzhiev.repository;

import com.georgiiHadzhiev.entity.WorkGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkGroupRepository extends JpaRepository<WorkGroup,Long> {
}
