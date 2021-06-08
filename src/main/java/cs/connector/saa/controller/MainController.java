package cs.connector.saa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
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

	@GetMapping("/student")
	public SAAStudent getSAAStudent(@RequestParam String fiscalCode) {
		String id = RandomStringUtils.randomNumeric(8);
		SAAStudent s = new SAAStudent();
		s.setOrigin("INFOTNISTRUZIONE");
		s.setExtId(id);
		s.setCf(fiscalCode);
		s.setName("Nome " + id);
		s.setSurname("Cognome " + id);
		s.setEmail("email " + id);
		s.setPhone("telefono " + id);
		s.setAddress("indirizzo " + id);
		return s;
	}
	
	@GetMapping("/exam")
	public List<SAAExam> getSAAExam(@RequestParam String fiscalCode) {
		List<SAAExam> list = new ArrayList<>();
		for(int i=0; i<2; i++) {
			String id = fiscalCode + "_exam_" + i;
			int giorno = random.nextInt(max - min) + min;
			SAAExam e = new SAAExam();
			e.setOrigin("INFOTNISTRUZIONE");
			e.setExtId(id);
			e.setDateFrom("2021-04-" + giorno);
			e.setDateTo("2021-04-" + giorno);
			e.setQualification("Operatore elettrico");
			e.setSchoolYear("2020-21");
			e.setType("ESAME DI STATO CONCLUSIVO DEL PRIMO CICLO");
			e.setInstituteRef("istituto1");
			e.setHonour(true);
			e.setGrade(String.valueOf(random.nextInt(60) + 36));
			e.setExternalCandidate(false);
			e.setPositiveResult(true);
			list.add(e);
		}
		return list;
	}
	
	@GetMapping("/stage")
	public List<SAAStage> getSAAStage(@RequestParam String fiscalCode) {
		List<SAAStage> list = new ArrayList<>();
		SAAStage s = new SAAStage();
		String id = fiscalCode + "_stage_1";
		int giorno = random.nextInt(max - min) + min;
		s.setExtId(id);
		s.setOrigin("INFOTNISTRUZIONE");
		s.setDateFrom("2021-04-" + giorno);
		s.setDateTo("2021-04-" + giorno);
		s.setType("Tirocinio estivo");
		s.setTitle("3° OP. CARPENTERIA IN LEGNO - PRIMO PERIODO");
		s.setDuration("80");
		s.setLocation("EFFEFFE RESTAURI srl - LOCALITA' AL PONTE  38082 BORGO CHIESE (TN)");
		s.setCompanyRef("azienda1");
		list.add(s);
		return list;
	}
	
	@GetMapping("/certification")
	public List<SAACertification> getSAACertification(@RequestParam String fiscalCode) {
		List<SAACertification> list = new ArrayList<>();
		SAACertification cert = new SAACertification();
		String id = fiscalCode + "_cert_1";
		int giorno = random.nextInt(max - min) + min;
		cert.setExtId(id);
		cert.setOrigin("INFOTNISTRUZIONE");
		cert.setTitle("titolo");
		cert.setDescription("descrizione");
		cert.setDateFrom("2021-04-" + giorno);
		cert.setDateTo("2021-04-" + giorno);
		cert.setDateCertification("2021-04-" + giorno);
		cert.setContact("referente1");
		cert.setCertifier("ente certificatore");
		cert.setDuration("3 gg");
		cert.setLanguage("en");
		cert.setJudgment("voto, giudizio");
		cert.setLocation("indirizzo");
		cert.setType("LANG");
		cert.setCompanyRef("azienda1");
		list.add(cert);
		return list;
	}
	
	@GetMapping("/mobility")
	public List<SAAMobility> getSAAMobility(@RequestParam String fiscalCode) {
		List<SAAMobility> list = new ArrayList<>();
		SAAMobility mob = new SAAMobility();
		String id = fiscalCode + "_mobility_1";
		int giorno = random.nextInt(max - min) + min;
		mob.setExtId(id);
		mob.setOrigin("INFOTNISTRUZIONE");
		mob.setTitle("titolo");	
		mob.setDescription("descrizione");
		mob.setDateFrom("2021-04-" + giorno);
		mob.setDateTo("2021-04-" + giorno);
		mob.setContact("referente1");
		mob.setDuration("15 gg");
		mob.setLocation("indirizzo");
		mob.setType("extrascolastico");
		mob.setCompanyRef("azienda1");
		list.add(mob);
		return list;
	}
	
	public List<SAAEnrollment> getSAAEnrollment(@RequestParam String fiscalCode) {
		List<SAAEnrollment> list = new ArrayList<>();
		SAAEnrollment enrol = new SAAEnrollment();
		String id = fiscalCode + "_enrollment_1";
		int giorno = random.nextInt(max - min) + min;
		enrol.setExtId(id);
		enrol.setOrigin("INFOTNISTRUZIONE");
		enrol.setCourse("CARPENTERIA");
		enrol.setSchoolYear("2020-21");
		enrol.setClassroom("3C");
		enrol.setDateFrom("2021-04-" + giorno);
		enrol.setDateTo("2021-04-" + giorno);
		enrol.setInstituteRef("istituto1");
		list.add(enrol);
		return list;
	}
	
	@GetMapping("/institute")
	public SAAInstitute getSAAInstitute(@RequestParam String extId) {
		SAAInstitute i = new SAAInstitute();
		i.setExtId(extId);
		i.setOrigin("INFOTNISTRUZIONE");
		i.setName("istituto1");
		i.setAddress("indirizzo1");
		i.setEmail("email1");
		i.setPec("pec1");
		return i;
	}
	
	@GetMapping("/company")
	public SAACompany getSAACompany(@RequestParam String extId) {
		SAACompany c = new SAACompany();
		c.setExtId(extId);
		c.setOrigin("INFOTNISTRUZIONE");
		c.setAddress("indirizzo1");
		c.setEmail("email1");
		c.setName("campany1");
		c.setPartita_iva("111222333");
		c.setPec("pec1");
		c.setPhone("phone1");
		c.setIdTipoAzienda(10);
		return c;
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
