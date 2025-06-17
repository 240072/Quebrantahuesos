package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class EquipoTestMockito {
    @Test
    void testCalcularPromedioVelocidad() {
        // Crear mocks
        Ciclista ciclista1Mock = mock(Ciclista.class);
        Ciclista ciclista2Mock = mock(Ciclista.class);

        // Configurar mocks
        when(ciclista1Mock.calcularVelocidad()).thenReturn(10.0);
        when(ciclista2Mock.calcularVelocidad()).thenReturn(20.0);

        // Crear equipo real con ciclistas mockeados
        Equipo equipo = new Equipo("Movistar");
        equipo.agregarCiclista(ciclista1Mock);
        equipo.agregarCiclista(ciclista2Mock);

        // Calcular promedio
        double promedio = equipo.calcularPromedioVelocidad();
        assertEquals(15.0, promedio, 0.001);

        // Verificar interacciones
        verify(ciclista1Mock).calcularVelocidad();
        verify(ciclista2Mock).calcularVelocidad();
    }
}