/*package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Reglement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReglementServiceTest {
	@Autowired
	ReglementServiceImpl reglementService;

	@Test
	public void testAddReglement() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateReglement = dateFormat.parse("30/09/2000");
		Reglement r = new Reglement(20, 30, true, dateReglement);
		Reglement reglement = reglementService.addReglement(r);
		System.out.print("reglement "+reglement);
		assertNotNull(reglement.getIdReglement());
		reglementService.deleteReglement(reglement.getIdReglement());

	}

}*/
