package com.talentsync.recruitment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentsync.recruitment.entity.Recruitment;
import com.talentsync.recruitment.repository.RecruitmentRepository;

@Service
public class RecruitmentService {

    private final RecruitmentRepository repository;

    public RecruitmentService(RecruitmentRepository repository) {
        this.repository = repository;
    }

    public Recruitment save(Recruitment recruitment) {
        return repository.save(recruitment);
    }

    public List<Recruitment> getAll() {
        return repository.findAll();
    }

    public Recruitment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}