package com.talentsync.recruitment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentsync.recruitment.entity.Recruitment;
import com.talentsync.recruitment.service.RecruitmentService;

@RestController
@RequestMapping("/recruitments")
public class RecruitmentController {

    private final RecruitmentService service;

    public RecruitmentController(RecruitmentService service) {
        this.service = service;
    }

    @PostMapping
    public Recruitment create(@RequestBody Recruitment recruitment) {
        return service.save(recruitment);
    }

    @GetMapping
    public List<Recruitment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Recruitment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Recruitment update(@PathVariable Long id, @RequestBody Recruitment recruitment) {

        Recruitment old = service.getById(id);

        if (old == null) {
            return null;
        }

        old.setApplicationId(recruitment.getApplicationId());
        old.setInterviewStatus(recruitment.getInterviewStatus());
        old.setFinalStatus(recruitment.getFinalStatus());

        return service.save(old);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Recruitment deleted successfully";
    }
}