package com.talentsync.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentsync.application.client.JobClient;
import com.talentsync.application.client.JobResponse;
import com.talentsync.application.client.RecruitmentClient;
import com.talentsync.application.client.RecruitmentRequest;
import com.talentsync.application.entity.Application;
import com.talentsync.application.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository repository;
    private final JobClient jobClient;
    private final RecruitmentClient recruitmentClient;

    public ApplicationService(
            ApplicationRepository repository,
            JobClient jobClient,
            RecruitmentClient recruitmentClient) {

        this.repository = repository;
        this.jobClient = jobClient;
        this.recruitmentClient = recruitmentClient;
    }

    public Application save(Application application) {

        JobResponse job = jobClient.getJob(application.getJobId());

        if (job == null) {
            return null;
        }

        Application savedApplication = repository.save(application);

        RecruitmentRequest request = new RecruitmentRequest();

        request.setApplicationId(savedApplication.getApplicationId());
        request.setInterviewStatus("PENDING");
        request.setFinalStatus("PENDING");

        recruitmentClient.createRecruitment(request);

        return savedApplication;
    }

    public List<Application> getAll() {
        return repository.findAll();
    }

    public Application getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}