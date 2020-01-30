package com.Sbms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Sbms.document.SequenceId;

@Repository
public interface SequenceRepository extends MongoRepository<SequenceId, String> {

}
