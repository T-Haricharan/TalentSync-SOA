package com.talentsync.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talentsync.auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
