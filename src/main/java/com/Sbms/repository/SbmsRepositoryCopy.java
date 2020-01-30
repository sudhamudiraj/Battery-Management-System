package com.Sbms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.Sbms.document.SbmsCopy;



public interface SbmsRepositoryCopy extends MongoRepository<SbmsCopy, String>{

	SbmsCopy findByDate(String date);

}
