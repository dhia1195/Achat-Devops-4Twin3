package tn.esprit.rh.achat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
public class ProduitServiceImplTest {

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllProduits() {
        // Given
        when(produitRepository.findAll()).thenReturn(Arrays.asList(new Produit(), new Produit()));

        // When
        List<Produit> produits = produitService.retrieveAllProduits();

        // Then
        assertEquals(2, produits.size());
        verify(produitRepository, times(1)).findAll();
    }


    @Test
    public void testAddProduit() {
        // Given
        Produit produit = new Produit();

        // When
        produitService.addProduit(produit);

        // Then
        verify(produitRepository, times(1)).save(produit);
    }

    @Test
    public void testDeleteProduit() {
        // Given
        Long id = 1L;

        // When
        produitService.deleteProduit(id);

        // Then
        verify(produitRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateProduit() {
        // Given
        Produit produit = new Produit();

        // When
        produitService.updateProduit(produit);

        // Then
        verify(produitRepository, times(1)).save(produit);
    }

    @Test
    public void testRetrieveProduit() {
        // Given
        Long id = 1L;
        Produit mockProduit = new Produit();
        when(produitRepository.findById(id)).thenReturn(Optional.of(mockProduit));

        // When
        Produit produit = produitService.retrieveProduit(id);

        // Then
        assertEquals(mockProduit, produit);
        verify(produitRepository, times(1)).findById(id);
    }

    @Test
    public void testAssignProduitToStock() {
        // Given
        Long idProduit = 1L;
        Long idStock = 2L;
        Produit produit = new Produit();
        Stock stock = new Stock();
        when(produitRepository.findById(idProduit)).thenReturn(Optional.of(produit));
        when(stockRepository.findById(idStock)).thenReturn(Optional.of(stock));

        // When
        produitService.assignProduitToStock(idProduit, idStock);

        // Then
        assertEquals(stock, produit.getStock());
        verify(produitRepository, times(1)).save(produit);
    }
}
