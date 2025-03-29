package com.example.mockserver.repository;

import com.example.mockserver.model.MockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MockRepository extends MongoRepository<MockEntity, String> {
    Optional<MockEntity> findByUriAndMethod(String uri, String method);
}
