package org.example.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EquipoTest {
    private Equipo equipo;
    private Ciclista ciclista;

    @BeforeEach
    void setUp() {
        equipo = new Equipo("Team Pirineos");
        ciclista = new Ciclista("Ciclista", "Test", 30, 80, equipo);
    }

    @Test
    void testCreacionEquipo() {
        assertEquals("Team Pirineos", equipo.getNombre());
        assertEquals(1, equipo.getCiclistas().size());
    }

    @Test
    void testAgregarCiclista() {
        Ciclista nuevoCiclista = new Ciclista("Nuevo", "Ciclista", 25, 75, equipo);
        assertEquals(2, equipo.getCiclistas().size());
    }

    @Test
    void testRemoverCiclista() {
        equipo.removerCiclista(ciclista);
        assertTrue(equipo.getCiclistas().isEmpty());
    }

    @Test
    void testAgregarCiclistaNull() {
        equipo.agregarCiclista(null);
        assertEquals(1, equipo.getCiclistas().size()); // Solo el ciclista del setUp
    }
}