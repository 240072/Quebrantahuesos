package org.example.Models;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BicicletaTestMockito {
    @Test
    void testGetters() {
        Bicicleta biciMock = spy(new Bicicleta("Carbono", 7.2)); // Spy permite mockear parcialmente
        when(biciMock.getMaterial()).thenReturn("Titanio"); // Override específico

        assertEquals("Titanio", biciMock.getMaterial()); // Mockeado
        assertEquals(7.2, biciMock.getPeso(), 0.001); // Implementación real
    }

}