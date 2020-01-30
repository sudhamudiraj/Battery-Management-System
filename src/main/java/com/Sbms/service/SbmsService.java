package com.Sbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sbms.document.Sbms;
import com.Sbms.repository.SbmsRepository;

@Service
public class SbmsService {
	
	@Autowired
	SbmsRepository sbmsRepository;
	
	public List<Sbms> findAll() {
		return sbmsRepository.findAll();
	}
	

}
