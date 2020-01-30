package com.Sbms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sbms.document.NarrowGraph;



public interface NarrowGraphRepository extends MongoRepository<NarrowGraph, String>{

	NarrowGraph findByDate(String date);

}
