package org.example.Services;

import org.example.Repositorio.Repositorio;
import org.example.Models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarreraServiceTestMockito {
    @Mock
    private Repositorio repositorioMock;

    @InjectMocks
    private CarreraService carreraService;

    @Test
    void testDeterminarGanadorUsandoMockDeBicicleta() {
        // 1. Configuración de Mocks
        Bicicleta biciMock = mock(Bicicleta.class);
        when(biciMock.getPeso()).thenReturn(6.8);

        Ciclista ciclistaMock = mock(Ciclista.class);
        when(ciclistaMock.calcularVelocidad()).thenReturn(12.5);
        when(ciclistaMock.getBicicleta()).thenReturn(biciMock);

        Equipo equipoMock = mock(Equipo.class);
        when(equipoMock.getNombre()).thenReturn("Equipo Mock");
        when(equipoMock.getCiclistas()).thenReturn(List.of(ciclistaMock));

        // ¡Corrección clave! Mockea el método calcularPromedioVelocidad()
        when(equipoMock.calcularPromedioVelocidad()).thenReturn(12.5);

        Carrera carrera = new Carrera("Test Race");
        carrera.agregarEquipo(equipoMock);

        // 2. Ejecución
        Equipo ganador = carreraService.determinarGanador(carrera);

        // 3. Verificación
        assertEquals(equipoMock, ganador);
        verify(equipoMock, atLeastOnce()).calcularPromedioVelocidad();
    }
}