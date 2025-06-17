package org.example.Repositorio;

import org.example.Models.Carrera;
import org.example.Models.Ciclista;
import org.example.Models.Equipo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {
    private Repositorio repositorio;

    @BeforeEach
    void setUp() {
        repositorio = new Repositorio();
    }

    @Test
    void testDatosInicializados() {
        assertFalse(repositorio.getCiclistas().isEmpty());
        assertFalse(repositorio.getBicicletas().isEmpty());
        assertFalse(repositorio.getEquipos().isEmpty());
        assertFalse(repositorio.getCarreras().isEmpty());
    }

    @Test
    void testRelacionesEntreClases() {
        // Verificar que los ciclistas tienen equipos y bicicletas asignadas
        for (Ciclista ciclista : repositorio.getCiclistas()) {
            assertNotNull(ciclista.getEquipo());
            assertNotNull(ciclista.getBicicleta());
        }

        // Verificar que los equipos tienen ciclistas
        for (Equipo equipo : repositorio.getEquipos()) {
            assertFalse(equipo.getCiclistas().isEmpty());
        }

        // Verificar que las carreras tienen equipos
        for (Carrera carrera : repositorio.getCarreras()) {
            assertFalse(carrera.getEquipos().isEmpty());
        }
    }

}