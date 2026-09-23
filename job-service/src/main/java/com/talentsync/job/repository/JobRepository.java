package com.talentsync.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.talentsync.job.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}