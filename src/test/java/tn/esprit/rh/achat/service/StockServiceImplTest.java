package tn.esprit.rh.achat.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {
        // Given
        when(stockRepository.findAll()).thenReturn(Arrays.asList(new Stock(), new Stock()));

        // When
        List<Stock> stocks = stockService.retrieveAllStocks();

        // Then
        assertEquals(2, stocks.size());
        verify(stockRepository, times(1)).findAll();
    }

    @Test
    public void testAddStock() {
        // Given
        Stock stock = new Stock();

        // When
        stockService.addStock(stock);

        // Then
        verify(stockRepository, times(1)).save(stock);
    }

    @Test
    public void testDeleteStock() {
        // Given
        Long stockId = 1L;

        // When
        stockService.deleteStock(stockId);

        // Then
        verify(stockRepository, times(1)).deleteById(stockId);
    }

    @Test
    public void testUpdateStock() {
        // Given
        Stock stock = new Stock();

        // When
        stockService.updateStock(stock);

        // Then
        verify(stockRepository, times(1)).save(stock);
    }

    @Test
    public void testRetrieveStock() {
        // Given
        Long stockId = 1L;
        Stock mockStock = new Stock();
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(mockStock));

        // When
        Stock stock = stockService.retrieveStock(stockId);

        // Then
        assertEquals(mockStock, stock);
        verify(stockRepository, times(1)).findById(stockId);
    }
}
