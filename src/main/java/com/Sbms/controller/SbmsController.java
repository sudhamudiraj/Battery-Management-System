package com.Sbms.controller;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sbms.document.NarrowGraph;
import com.Sbms.document.NarrowGraphCopy;
import com.Sbms.document.Sbms;
import com.Sbms.document.SbmsCopy;
import com.Sbms.repository.NarrowGraphRepository;
import com.Sbms.repository.NarrowGraphRepositoryCopy;
import com.Sbms.repository.SbmsRepository;
import com.Sbms.repository.SbmsRepositoryCopy;

@RequestMapping("/sbms")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SbmsController {

	@Autowired
	SbmsRepository sbmsRepository;

	@Autowired
	SbmsRepositoryCopy sbmsRepositoryCopy;

	@Autowired
	NarrowGraphRepository narrowGraphRepository;

	@Autowired
	NarrowGraphRepositoryCopy narrowGraphRepositoryCopy;

	final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
	final LocalDateTime now = LocalDateTime.now();

	@PostMapping("/saveData")
	public void saveData() throws InterruptedException {

		SbmsCopy sbms = sbmsRepositoryCopy.findByDate(dtf.format(now));
		List<Long> data = new ArrayList<Long>();
		List<String> label = new ArrayList<String>();
		if (sbms == null) {
			sbms = new SbmsCopy();
			sbms.setDate(dtf.format(now));
			int random = 80 - ((int) Math.round((Math.random()) * (80 - 60)));
			data.add((long) random);
			sbms.setData(data);
			label.add(dtf.format(now) + " " + dtfTime.format(now));
			sbms.setLabel(label);
			sbmsRepositoryCopy.save(sbms);
			
		}
		SbmsCopy sbms1 = sbmsRepositoryCopy.findByDate(dtf.format(now));
		do {
			final LocalDateTime now1 = LocalDateTime.now();
			int random = 80 - ((int) Math.round((Math.random()) * (80 - 60)));
			data.add((long) random);
			label.add(dtf.format(now1) + " " + dtfTime.format(now1));
			sbms1.setData(data);
			sbms1.setLabel(label);
			sbmsRepositoryCopy.save(sbms1);
			Thread.sleep(5000);
		} while (sbms1 != null);
		//return CompletableFuture.completedFuture(Arrays.asList(sbms1));

	}

	@PostMapping("/save")
	public void Save() throws InterruptedException {

		Sbms sbms = sbmsRepository.findByDate(dtf.format(now));
		List<Long> data = new ArrayList<Long>();
		List<String> label = new ArrayList<String>();
		if (sbms == null) {
			sbms = new Sbms();
			sbms.setDate(dtf.format(now));
			int random = 60 - ((int) Math.round((Math.random()) * (60 - 40)));
			data.add((long) random);
			sbms.setData(data);
			label.add(dtf.format(now) + " " + dtfTime.format(now));
			sbms.setLabel(label);
			sbmsRepository.save(sbms);
			System.out.println("data saved");
		}
		Sbms sbms1 = sbmsRepository.findByDate(dtf.format(now));
		do {
			final LocalDateTime now1 = LocalDateTime.now();
			int random = 60 - ((int) Math.round((Math.random()) * (60 - 40)));
			data.add((long) random);
			label.add(dtf.format(now1) + " " + dtfTime.format(now1));
			sbms1.setData(data);
			sbms1.setLabel(label);
			sbmsRepository.save(sbms1);
			Thread.sleep(5000);
		} while (sbms1 != null);
		//return CompletableFuture.completedFuture(Arrays.asList(sbms1));

	}

	@GetMapping("/getData/{date}")
	public Sbms getData(@PathVariable String date) {
		// System.out.println("Date: " + date);
		return sbmsRepository.findByDate(date);
	}

	@GetMapping("/getSecoundData/{date}")
	public SbmsCopy getSecondData(@PathVariable String date) {
		// Random r=new Random();
		/*
		 * System.out.println("Date: " + date); Sbms s =
		 * sbmsRepository.findByDate(date); List<Long> datas = new ArrayList<Long>();
		 * List<Long> data = s.getData(); long sum = 0; for (long d : data) { int random
		 * = 10 - ((int) Math.round((Math.random()) * (20 - 10))); sum = d + random;
		 * datas.add(sum); } // Sbms s1=new Sbms(); s.setData(datas);
		 */
		return sbmsRepositoryCopy.findByDate(date);
	}

	@PostMapping("/narrowGraph")
	public NarrowGraph saveGraphData() throws InterruptedException {

		NarrowGraph narrowGraph = narrowGraphRepository.findByDate(dtf.format(now));
		List<Double> data = new ArrayList<Double>();
		List<String> label = new ArrayList<String>();
		double input = 10.00;
		if (narrowGraph == null) {
			narrowGraph = new NarrowGraph();
			narrowGraph.setDate(dtf.format(now));
			data.add(input);
			narrowGraph.setData(data);
			label.add(dtf.format(now) + " " + dtfTime.format(now));
			narrowGraph.setLabel(label);
			narrowGraphRepository.save(narrowGraph);

		}
		NarrowGraph narrowGraph1 = narrowGraphRepository.findByDate(dtf.format(now));
		do {
			DecimalFormat form = new DecimalFormat("#.#");
			final LocalDateTime now1 = LocalDateTime.now();
			// List<Double> newData=narrowGraph1.getData();
			input += 0.1;
			data.add(Double.valueOf(form.format(input)));
			label.add(dtf.format(now1) + " " + dtfTime.format(now1));
			narrowGraph1.setData(data);
			narrowGraph1.setLabel(label);
			narrowGraphRepository.save(narrowGraph1);
			Thread.sleep(5000);
		} while (narrowGraph1 != null);

		return null;

	}

	@PostMapping("/secondNarrowGraph")
	public NarrowGraphCopy secondNarrowGraph() throws InterruptedException {

		NarrowGraphCopy narrowGraphCopy = narrowGraphRepositoryCopy.findByDate(dtf.format(now));
		List<Double> data = new ArrayList<Double>();
		List<String> label = new ArrayList<String>();
		double input = 20.00;
		if (narrowGraphCopy == null) {
			narrowGraphCopy = new NarrowGraphCopy();
			narrowGraphCopy.setDate(dtf.format(now));
			data.add(input);
			narrowGraphCopy.setData(data);
			label.add(dtf.format(now) + " " + dtfTime.format(now));
			narrowGraphCopy.setLabel(label);
			narrowGraphRepositoryCopy.save(narrowGraphCopy);

		}
		NarrowGraphCopy narrowGraphCopy1 = narrowGraphRepositoryCopy.findByDate(dtf.format(now));
		do {
			DecimalFormat form = new DecimalFormat("#.#");
			final LocalDateTime now1 = LocalDateTime.now();
			// List<Double> newData=narrowGraph1.getData();
			input += 0.1;
			data.add(Double.valueOf(form.format(input)));
			label.add(dtf.format(now1) + " " + dtfTime.format(now1));
			narrowGraphCopy1.setData(data);
			narrowGraphCopy1.setLabel(label);
			narrowGraphRepositoryCopy.save(narrowGraphCopy1);
			Thread.sleep(5000);
		} while (narrowGraphCopy1 != null);

		return null;

	}

	@GetMapping("/getNarrowGraph/{date}")
	public NarrowGraph getNarrowGraph(@PathVariable String date) {
		return narrowGraphRepository.findByDate(date);
	}

	@GetMapping("/getSecondNarrowGraph/{date}")
	public NarrowGraphCopy getSecondNarrowGraph(@PathVariable String date) {
		return narrowGraphRepositoryCopy.findByDate(date);
	}

}
