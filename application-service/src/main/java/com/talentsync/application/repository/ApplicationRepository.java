package com.talentsync.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talentsync.application.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}