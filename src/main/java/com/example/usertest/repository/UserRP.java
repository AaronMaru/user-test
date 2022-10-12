package com.example.usertest.repository;

import com.example.usertest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRP extends JpaRepository<User, Long> {
}
