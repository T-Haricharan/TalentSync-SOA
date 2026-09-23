package com.talentsync.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RECRUITMENT-SERVICE")
public interface RecruitmentClient {

    @PostMapping("/recruitments")
    RecruitmentResponse createRecruitment(@RequestBody RecruitmentRequest request);
}