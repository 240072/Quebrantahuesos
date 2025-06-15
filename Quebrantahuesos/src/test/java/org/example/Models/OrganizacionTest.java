package org.example.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizacionTest {
    private Organizacion organizacion;
    private Equipo equipo;

    @BeforeEach
    void setUp() {
        organizacion = new Organizacion("Quebrantahuesos Org", 1988);
        equipo = new Equipo("Test Team");
    }

    @Test
    void testCreacionOrganizacion() {
        assertEquals("Quebrantahuesos Org", organizacion.getNombre());
        assertEquals(1988, organizacion.getAñoFundacion());
        assertTrue(organizacion.getEquiposRegistrados().isEmpty());
    }

    @Test
    void testRegistrarEquipo() {
        organizacion.registrarEquipo(equipo);
        assertEquals(1, organizacion.getEquiposRegistrados().size());
        assertEquals(equipo, organizacion.getEquiposRegistrados().get(0));
    }

    @Test
    void testMostrarInformacion() {
        organizacion.registrarEquipo(equipo);
        new Ciclista("Test", "Ciclista", 30, 80, equipo);
        assertDoesNotThrow(organizacion::mostrarInformacion);
    }

}