package com.talentsync.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talentsync.recruitment.entity.Recruitment;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

}