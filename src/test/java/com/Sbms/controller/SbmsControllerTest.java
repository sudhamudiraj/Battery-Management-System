package com.Sbms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Sbms.document.Sbms;
import com.Sbms.repository.SbmsRepository;
import com.Sbms.service.SbmsService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SbmsControllerTest {
	
	@MockBean
	SbmsRepository sbmsRepository;
	
	@Autowired
	SbmsService sbmsService;

	@Test
	void getAllData() {
		List<Long> list=new ArrayList<>();
		List<String> list1=new ArrayList<>();
		list.add((long) 10);
		list.add((long) 10);
		list1.add("sdf");
		list1.add("sdfg");
		
		when(sbmsRepository.findAll()).thenReturn(Stream.of(new Sbms("2020-02-12",list,list1),new Sbms("2020-02-12",list,list1)).collect(Collectors.toList()));
		assertEquals(2, sbmsService.findAll().size());
	}
	
	@Test
	void getData() {
		List<Long> list=new ArrayList<>();
		List<String> list1=new ArrayList<>();
		list.add((long) 10);
		list.add((long) 10);
		list1.add("sdf");
		list1.add("sdfg");
		
		when(sbmsRepository.findAll()).thenReturn(Stream.of(new Sbms("2020-02-12",list,list1),new Sbms("2020-02-12",list,list1)).collect(Collectors.toList()));
		assertEquals(1, sbmsService.findAll().size());
	}
}
