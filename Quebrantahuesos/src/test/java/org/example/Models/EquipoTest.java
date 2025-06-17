package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EquipoTest {
    @Test
    void testConstructorYAgregarCiclista() {
        Equipo equipo = new Equipo("Movistar");
        assertEquals("Movistar", equipo.getNombre());
        assertTrue(equipo.getCiclistas().isEmpty());

        Bicicleta bici = new Bicicleta("Carbono", 7.2);
        Ciclista ciclista = new Ciclista("Prueba", 30, equipo, bici);

        equipo.agregarCiclista(ciclista);
        assertEquals(1, equipo.getCiclistas().size());
        assertEquals(ciclista, equipo.getCiclistas().get(0));
    }

    @Test
    void testCalcularPromedioVelocidad() {
        Equipo equipo = new Equipo("Test Team");
        Bicicleta bici1 = new Bicicleta("Carbono", 7.0);
        Bicicleta bici2 = new Bicicleta("Aluminio", 8.0);

        Ciclista c1 = new Ciclista("C1", 25, equipo, bici1);
        Ciclista c2 = new Ciclista("C2", 30, equipo, bici2);

        equipo.agregarCiclista(c1);
        equipo.agregarCiclista(c2);

        double promedio = equipo.calcularPromedioVelocidad();
        double expected = (c1.calcularVelocidad() + c2.calcularVelocidad()) / 2;

        assertEquals(expected, promedio, 0.001);
    }
  
}