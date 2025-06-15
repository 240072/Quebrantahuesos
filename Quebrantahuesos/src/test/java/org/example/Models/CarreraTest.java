package org.example.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


class CarreraTest {
    private Carrera carrera;
    private Ciclista ciclista1;
    private Ciclista ciclista2;

    @BeforeEach
    void setUp() {
        carrera = new Carrera("Quebrantahuesos 2023", 200, 4000);

        Equipo equipo1 = new Equipo("Team 1");
        Equipo equipo2 = new Equipo("Team 2");

        ciclista1 = new Ciclista("Ciclista", "Uno", 30, 90, equipo1);
        ciclista2 = new Ciclista("Ciclista", "Dos", 32, 85, equipo2);

        Bicicleta bici1 = new Bicicleta("Bici 1", 6.8, "Carbono", 11);
        Bicicleta bici2 = new Bicicleta("Bici 2", 7.2, "Carbono", 10);

        ciclista1.agregarBicicleta(bici1);
        ciclista2.agregarBicicleta(bici2);

        carrera.agregarParticipante(ciclista1);
        carrera.agregarParticipante(ciclista2);
    }

    @Test
    void testCreacionCarrera() {
        assertEquals("Quebrantahuesos 2023", carrera.getNombre());
        assertEquals(200, carrera.getDistancia(), 0.01);
        assertEquals(4000, carrera.getDesnivel(), 0.01);
        assertEquals(2, carrera.getParticipantes().size());
    }

    @Test
    void testSimularCarrera() {
        carrera.simularCarrera();
        assertEquals(2, carrera.getResultados().size());

        Duration tiempo1 = carrera.getResultados().get(ciclista1);
        Duration tiempo2 = carrera.getResultados().get(ciclista2);

        assertNotNull(tiempo1);
        assertNotNull(tiempo2);
        assertTrue(tiempo1.compareTo(tiempo2) < 0); // ciclista1 tiene mayor habilidad
    }

    @Test
    void testMostrarResultadosSinParticipantes() {
        Carrera carreraVacia = new Carrera("Carrera vacía", 100, 1000);
        assertDoesNotThrow(carreraVacia::mostrarResultados);
    }
}