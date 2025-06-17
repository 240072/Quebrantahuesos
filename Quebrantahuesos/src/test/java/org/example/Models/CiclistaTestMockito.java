package org.example.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class CiclistaTestMockito {
    @Test
    void testCalcularVelocidad() {
        // Crear mocks
        Bicicleta biciMock = mock(Bicicleta.class);
        Equipo equipoMock = mock(Equipo.class);

        // Configurar mocks
        when(biciMock.getPeso()).thenReturn(7.0);

        // Crear objeto real con dependencias mockeadas
        Ciclista ciclista = new Ciclista("Alejandro Valverde", 35, equipoMock, biciMock);

        // Calcular velocidad esperada: (10 / 7.0) * (1 - (35-30)*0.01)
        double velocidadEsperada = (10.0 / 7.0) * 0.95;
        double velocidadCalculada = ciclista.calcularVelocidad();

        assertEquals(velocidadEsperada, velocidadCalculada, 0.001);

        // Verificar interacciones
        verify(biciMock, atLeastOnce()).getPeso();
    }
  
}