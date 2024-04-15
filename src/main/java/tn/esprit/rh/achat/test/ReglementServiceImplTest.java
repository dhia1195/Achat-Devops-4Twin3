package tn.esprit.rh.achat.test;


import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.*;
import tn.esprit.rh.achat.services.ReglementServiceImpl;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
public class ReglementServiceImplTest {
    @Mock
    private FactureRepository factureRepository;

    @Mock
    private ReglementRepository reglementRepository;

    @InjectMocks
    private ReglementServiceImpl reglementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testRetrieveAllReglements() {
        // Mock data
        List<Reglement> mockReglements = new ArrayList<>();
        mockReglements.add(new Reglement(1L, 100f, 50f, true, new Date(), null));
        mockReglements.add(new Reglement(2L, 200f, 150f, false, new Date(), null));

        // Mock behavior
        when(reglementRepository.findAll()).thenReturn(mockReglements);

        // Test
        List<Reglement> retrievedReglements = reglementService.retrieveAllReglements();

        // Verify
        assertNotNull(retrievedReglements);
        assertEquals(2, retrievedReglements.size());
        assertEquals(mockReglements, retrievedReglements);
    }

    @Test
    public void testRetrieveReglement() {
        Long reglementId = 1L;
        List<Reglement> mockReglements = new ArrayList<>();
        mockReglements.add(new Reglement(1L, 100f, 50f, true, new Date(), null));
        mockReglements.add(new Reglement(2L, 200f, 150f, false, new Date(), null));
        Reglement expectedReglement=mockReglements.get(0);
        when(reglementRepository.findById(reglementId)).thenReturn(java.util.Optional.of(expectedReglement));

        Reglement retrievedReglement = reglementService.retrieveReglement(reglementId);

        assertNotNull(retrievedReglement);
        assertEquals(expectedReglement, retrievedReglement);
        verify(reglementRepository, times(1)).findById(reglementId);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        Long factureId = 1L;
        List<Reglement> expectedReglements = new ArrayList<>();
        List<Reglement> mockReglements = new ArrayList<>();
        Facture fa1 = new Facture();
        Facture fa2 = new Facture();
        mockReglements.add(new Reglement(1L, 100f, 50f, true, new Date(), fa1));
        mockReglements.add(new Reglement(2L, 200f, 150f, false, new Date(), fa2));
        expectedReglements.add(mockReglements.get(0));
        when(reglementRepository.retrieveReglementByFacture(factureId)).thenReturn(expectedReglements);

        List<Reglement> retrievedReglements = reglementService.retrieveReglementByFacture(factureId);

        assertNotNull(retrievedReglements);
        assertEquals(expectedReglements, retrievedReglements);
        verify(reglementRepository, times(1)).retrieveReglementByFacture(factureId);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        List<Reglement> mockReglements = new ArrayList<>();
        mockReglements.add(new Reglement(1L, 100f, 50f, true, new Date(124, 3, 16), null));
        mockReglements.add(new Reglement(2L, 200f, 150f, false, new Date(124, 3, 4), null));
        mockReglements.add(new Reglement(3L, 200f, 150f, false, new Date(124, 3, 10), null));

        Date startDate = new Date(124, 3, 9);
        Date endDate = new Date(124, 3, 20);
        float expectedChiffreAffaire = 300f;
        when(reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(expectedChiffreAffaire);

        float chiffreAffaire = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        assertEquals(300f, chiffreAffaire, 0.001f);
        verify(reglementRepository, times(1)).getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }
}


