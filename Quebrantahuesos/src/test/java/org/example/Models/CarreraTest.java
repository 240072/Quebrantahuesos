package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CarreraTest {
    @Test
    void testConstructorYAgregarEquipo() {
        Carrera carrera = new Carrera("Tour de Francia");
        assertEquals("Tour de Francia", carrera.getNombre());
        assertTrue(carrera.getEquipos().isEmpty());

        Equipo equipo = new Equipo("Movistar");
        carrera.agregarEquipo(equipo);

        assertEquals(1, carrera.getEquipos().size());
        assertEquals(equipo, carrera.getEquipos().get(0));
    }

    @Test
    void testMultiplesEquipos() {
        Carrera carrera = new Carrera("Vuelta a España");
        Equipo movistar = new Equipo("Movistar");
        Equipo ineos = new Equipo("INEOS");

        carrera.agregarEquipo(movistar);
        carrera.agregarEquipo(ineos);

        assertEquals(2, carrera.getEquipos().size());
        assertTrue(carrera.getEquipos().contains(movistar));
        assertTrue(carrera.getEquipos().contains(ineos));
    }
  
}