package com.talentsync.job.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentsync.job.entity.Job;
import com.talentsync.job.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping
    public Job create(@RequestBody Job job) {
        return service.save(job);
    }

    @GetMapping
    public List<Job> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Job update(@PathVariable Long id, @RequestBody Job job) {
        Job old = service.getById(id);

        if (old == null) {
            return null;
        }

        old.setCompanyName(job.getCompanyName());
        old.setRole(job.getRole());
        old.setLocation(job.getLocation());
        old.setStatus(job.getStatus());

        return service.save(old);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Job deleted successfully";
    }
}