package com.project.voting.repository;

import com.project.voting.model.Records;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CandidateRepository extends MongoRepository<Records, String> {
    Optional<Records> findByConstituencyName(String constituencyName);
}
