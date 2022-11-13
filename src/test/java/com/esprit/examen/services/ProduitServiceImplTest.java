package com.esprit.examen.services;
import java.util.ArrayList;
import java.util.List;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProduitServiceImplTest {
    @Mock
    ProduitRepository produitRepository;
    @InjectMocks
    ProduitServiceImpl produitService;

    Produit prod1 = new Produit("123","Dell",1600);

    Long getId()
    {
        for (Produit po: produitRepository.findAll()) {
            return po.getIdProduit();
        }
        return 0L;
    }
    @Test
    @Order(0)
    void TestaddProduit() {
        Produit prod = new Produit();
        List<Produit> LProduit = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
        	prod.setIdProduit(i);
        	prod.setLibelleProduit("asus");
        	prod.setCodeProduit("d-62211");
        	prod.setPrix(1500);

            Produit pr=produitRepository.save(prod1);
            LProduit.add(pr);
        }
        assertEquals(10,LProduit.size());
    }
    @Test
    @Order(3)
    void TestdeleteAllProduit() {
        produitRepository.deleteAll();
        assertEquals(0,produitRepository.findAll().spliterator().estimateSize());
    }
    @Test
    @Order(2)
    void TestretrieveProduit() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(prod1));

        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(prod1))
        ;
        Produit pr = produitService.retrieveProduit(2L);
        Assertions.assertNotNull(pr);


    }
    @Test
    @Order(4)
    void TestgetAllProduit(){
        Iterable<Produit> Lprod = produitRepository.findAll();
        Assertions.assertNotNull(Lprod);
    }
}
	
	



