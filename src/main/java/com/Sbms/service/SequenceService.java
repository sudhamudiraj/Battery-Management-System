package com.Sbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.Sbms.document.SequenceId;
import com.Sbms.repository.SequenceRepository;

@Service
public class SequenceService {

	@Autowired
	private MongoOperations mongoOperation;
	
	@Autowired
	private SequenceRepository sequenceRepository;
	

	public long getNextSequenceId(String key) {

		Query query = new Query(Criteria.where("_id").is(key));
		Update update = new Update();
		update.inc("seq", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		SequenceId seqId = mongoOperation.findAndModify(query, update, options, SequenceId.class);
		return seqId.getSeq();

	}
	public void saveSequence(SequenceId seq) {
		sequenceRepository.save(seq);
	}
	


}
