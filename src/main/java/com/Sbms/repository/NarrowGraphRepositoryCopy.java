package com.Sbms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sbms.document.NarrowGraphCopy;



public interface NarrowGraphRepositoryCopy extends MongoRepository<NarrowGraphCopy, String>{

	NarrowGraphCopy findByDate(String date);

}
