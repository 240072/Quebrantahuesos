package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BicicletaTest {
    @Test
    void testConstructorYGetters() {
        Bicicleta bici = new Bicicleta("Carbono", 7.2);

        assertEquals("Carbono", bici.getMaterial());
        assertEquals(7.2, bici.getPeso(), 0.001);
    }

    @Test
    void testBicicletasIgualesPeso() {
        Bicicleta bici1 = new Bicicleta("Carbono", 7.2);
        Bicicleta bici2 = new Bicicleta("Carbono", 7.2);

        assertEquals(bici1.getPeso(), bici2.getPeso(), 0.001);
    }

    @Test
    void testBicicletasDiferentesMaterial() {
        Bicicleta bici1 = new Bicicleta("Carbono", 7.2);
        Bicicleta bici2 = new Bicicleta("Aluminio", 7.2);

        assertNotEquals(bici1.getMaterial(), bici2.getMaterial());
    }
}