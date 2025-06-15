package org.example.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BicicletaTest {
    private Bicicleta bici;
    private Ciclista ciclista;

    @BeforeEach
    void setUp() {
        bici = new Bicicleta("Specialized S-Works", 6.8, "Carbono", 11);
        ciclista = new Ciclista("Ciclista", "Test", 30, 80, new Equipo("Test Team"));
    }

    @Test
    void testCreacionBicicleta() {
        assertEquals("Specialized S-Works", bici.getModelo());
        assertEquals(6.8, bici.getPeso(), 0.01);
        assertEquals("Carbono", bici.getMaterial());
        assertEquals(11, bici.getCambios());
        assertNull(bici.getPropietario());
    }

    @Test
    void testCalcularCalidad() {
        assertEquals(10, bici.getCalidad()); // Peso <7 (+2), Carbono (+2), cambios >=11 (+1)

        Bicicleta bici2 = new Bicicleta("Otra", 7.6, "Acero", 9);
        assertEquals(5, bici2.getCalidad()); // Peso >7.5 (0), Acero (0), cambios <11 (0)
    }

    @Test
    void testSetPropietario() {
        bici.setPropietario(ciclista);
        assertEquals(ciclista, bici.getPropietario());
    }
}