package com.esprit.examen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ReglementServiceImplTest {
    @Mock
    ReglementRepository Repo;

    @InjectMocks
    
    ReglementServiceImpl Service;
    Reglement reglement = Reglement.builder().montantPaye(204).montantRestant(50).build();
    List<Reglement> listReglements = new ArrayList<Reglement>() {
        {
            add(Reglement.builder().montantPaye(25).montantRestant(30).build());
            add(Reglement.builder().montantPaye(66).montantRestant(50).build());
        }
    };

    @Test
    void testRetrieveReglement() {
        Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
        @SuppressWarnings("test")
        Reglement r1 = Service.retrieveReglement(new Long(2));
        Assertions.assertNotNull(r1);
    }

    @Test
    void testAllRetrieveReglement() {
        Mockito.when(Repo.findAll()).thenReturn(listReglements);
        List<Reglement> listR1 = Service.retrieveAllReglements();
        Assertions.assertNotNull(listR1);
    }

    @Test
    void testAddReglement() {
        Mockito.when(Repo.save(reglement)).thenReturn(reglement);
        Reglement r1 = Service.addReglement(reglement);
        Assertions.assertNotNull(r1);

    }

    @Test
    void testDeleteProduit() {
        Service.deleteReglement(reglement.getIdReglement());
        Mockito.verify(Repo, Mockito.times(1)).deleteById(reglement.getIdReglement());
    }


}