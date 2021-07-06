package cs.connector.saa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs.connector.saa.dto.SAACertification;
import cs.connector.saa.dto.SAACompany;
import cs.connector.saa.dto.SAACompetence;
import cs.connector.saa.dto.SAAEnrollment;
import cs.connector.saa.dto.SAAExam;
import cs.connector.saa.dto.SAAInstitute;
import cs.connector.saa.dto.SAAMobility;
import cs.connector.saa.dto.SAAStage;
import cs.connector.saa.dto.SAAStudent;

@RestController
public class MainController {
	Random random = new Random();
	int min = 10;
	int max = 31;
	Map<String, Object> dataMap = new HashMap<>();

	@PostConstruct
	public void init() {
		ObjectMapper objectMapper = new ObjectMapper();
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = null;
		try {
			resource = resourceLoader.getResource("classpath:json/student.json");
			SAAStudent student = objectMapper.readValue(resource.getInputStream(), SAAStudent.class);
			dataMap.put("student", student);

			resource = resourceLoader.getResource("classpath:json/exam.json");
			SAAExam exam = objectMapper.readValue(resource.getInputStream(), SAAExam.class);
			dataMap.put("exam", exam);

			resource = resourceLoader.getResource("classpath:json/stage.json");
			SAAStage stage = objectMapper.readValue(resource.getInputStream(), SAAStage.class);
			dataMap.put("stage", stage);

			resource = resourceLoader.getResource("classpath:json/certification.json");
			SAACertification certification = objectMapper.readValue(resource.getInputStream(), SAACertification.class);
			dataMap.put("certification", certification);

			resource = resourceLoader.getResource("classpath:json/mobility.json");
			SAAMobility mobility = objectMapper.readValue(resource.getInputStream(), SAAMobility.class);
			dataMap.put("mobility", mobility);

			resource = resourceLoader.getResource("classpath:json/enrollment.json");
			SAAEnrollment enrollment = objectMapper.readValue(resource.getInputStream(), SAAEnrollment.class);
			dataMap.put("enrollment", enrollment);

			resource = resourceLoader.getResource("classpath:json/institute.json");
			SAAInstitute institute = objectMapper.readValue(resource.getInputStream(), SAAInstitute.class);
			dataMap.put("institute", institute);

			resource = resourceLoader.getResource("classpath:json/company.json");
			SAACompany company = objectMapper.readValue(resource.getInputStream(), SAACompany.class);
			dataMap.put("company", company);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/student")
	public SAAStudent getSAAStudent(@RequestParam String fiscalCode) {
		return (SAAStudent) dataMap.get("student");
	}
	
	@GetMapping("/exam")
	public List<SAAExam> getSAAExam(@RequestParam String fiscalCode) {
		List<SAAExam> list = new ArrayList<>();
		list.add((SAAExam) dataMap.get("exam"));
		return list;
	}
	
	@GetMapping("/stage")
	public List<SAAStage> getSAAStage(@RequestParam String fiscalCode) {
		List<SAAStage> list = new ArrayList<>();
		list.add((SAAStage) dataMap.get("stage"));
		return list;
	}
	
	@GetMapping("/certification")
	public List<SAACertification> getSAACertification(@RequestParam String fiscalCode) {
		List<SAACertification> list = new ArrayList<>();
		list.add((SAACertification) dataMap.get("certification"));
		return list;
	}
	
	@GetMapping("/mobility")
	public List<SAAMobility> getSAAMobility(@RequestParam String fiscalCode) {
		List<SAAMobility> list = new ArrayList<>();
		list.add((SAAMobility) dataMap.get("mobility"));
		return list;
	}
	
	@GetMapping("/enrollment")
	public List<SAAEnrollment> getSAAEnrollment(@RequestParam String fiscalCode) {
		List<SAAEnrollment> list = new ArrayList<>();
		list.add((SAAEnrollment) dataMap.get("enrollment"));
		return list;
	}
	
	@GetMapping("/institute")
	public SAAInstitute getSAAInstitute(@RequestParam String extId) {
		return (SAAInstitute) dataMap.get("institute");
	}
	
	@GetMapping("/company")
	public SAACompany getSAACompany(@RequestParam String extId) {
		return (SAACompany) dataMap.get("company");
	}
	
	@SuppressWarnings("unused")
	private SAACompetence getCompetence() {
		SAACompetence comp = new SAACompetence();
		comp.setUri("http://data.europa.eu/esco/skill/09638218-695c-44c7-bac3-26b45a2ae418");
		comp.setConcentType("KnowledgeSkillCompetence");
		comp.getPreferredLabel().put("it", "svolgere i patch test");
		comp.getPreferredLabel().put("en", "conduct patch testing");
		return comp;
	}

}
