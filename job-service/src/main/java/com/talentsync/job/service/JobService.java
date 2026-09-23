package com.talentsync.job.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentsync.job.entity.Job;
import com.talentsync.job.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public Job save(Job job) {
        return repository.save(job);
    }

    public List<Job> getAll() {
        return repository.findAll();
    }

    public Job getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}