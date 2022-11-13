package com.esprit.examen.services;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.esprit.examen.entities.CategorieProduit;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategorieProduitServiceImplTest {
	 @Autowired
	    
	    ICategorieProduitService cs;

 @Test
 public void retrieveAllCategorieProduits() {
 	List<CategorieProduit> listCategorieProduits = cs.retrieveAllCategorieProduits();
     Assertions.assertEquals(0, listCategorieProduits.size());
 }
 
	private String codeCategorie;
	private String libelleCategorie;

 @Test
 public void testaddCategorieProduit(){
 List<CategorieProduit> CategorieProduits = cs.retrieveAllCategorieProduits();
 int expected = CategorieProduits.size();
 CategorieProduit c = new CategorieProduit();
 c.setCodeCategorie("codeCategorie");
 c.setLibelleCategorie("libelleCategorie");
 

 CategorieProduit savedCategorieProduit= cs.addCategorieProduit(c);
 assertEquals(expected+1, cs.retrieveAllCategorieProduits().size());
 assertNotNull(savedCategorieProduit.getLibelleCategorie());
 cs.deleteCategorieProduit(savedCategorieProduit.getIdCategorieProduit());

 }



 @Test
 public void testupdateCategorieProduit() {
 CategorieProduit c = new CategorieProduit();
 c.setLibelleCategorie("libelleCategorie");
 c.setLibelleCategorie("libelleCategorie");
 c.setCodeCategorie("codeCategorie");
 CategorieProduit savedCategorieProduit= cs.addCategorieProduit(c);
 savedCategorieProduit.setLibelleCategorie("libelleCategorie");;
 cs.updateCategorieProduit(savedCategorieProduit);
 assertEquals(c.getLibelleCategorie(),savedCategorieProduit.getLibelleCategorie());
 cs.deleteCategorieProduit(savedCategorieProduit.getIdCategorieProduit());
 }

 @Test
 public void testdeleteCategorieProduit() {
 CategorieProduit c = new CategorieProduit();
 c.setLibelleCategorie("libelleCategorie");
 c.setLibelleCategorie("libelleCategorie");
 c.setCodeCategorie("codeCategorie");
 CategorieProduit savedService= cs.addCategorieProduit(c);
 cs.deleteCategorieProduit(savedService.getIdCategorieProduit());
 assertNotNull(savedService.getIdCategorieProduit());

 }


}
