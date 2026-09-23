package com.talentsync.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "JOB-SERVICE")
public interface JobClient {

    @GetMapping("/jobs/{id}")
    JobResponse getJob(@PathVariable Long id);
}