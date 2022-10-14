package com.example.usertest.repository;

import com.example.usertest.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRP extends MongoRepository<User, Integer> {
}
