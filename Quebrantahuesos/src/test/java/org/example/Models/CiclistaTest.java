package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CiclistaTest {
    @Test
    void testConstructorYGetters() {
        Bicicleta bici = new Bicicleta("Carbono", 7.2);
        Equipo equipo = new Equipo("Movistar");
        Ciclista ciclista = new Ciclista("Alejandro Valverde", 42, equipo, bici);

        assertEquals("Alejandro Valverde", ciclista.getNombre());
        assertEquals(42, ciclista.getEdad());
        assertEquals(equipo, ciclista.getEquipo());
        assertEquals(bici, ciclista.getBicicleta());
    }

    @Test
    void testCalcularVelocidad() {
        Bicicleta biciLiviana = new Bicicleta("Carbono", 6.8);
        Bicicleta biciPesada = new Bicicleta("Acero", 10.2);
        Equipo equipo = new Equipo("Test Team");

        Ciclista ciclistaJoven = new Ciclista("Joven", 25, equipo, biciLiviana);
        Ciclista ciclistaVeterano = new Ciclista("Veterano", 40, equipo, biciLiviana);
        Ciclista ciclistaConBiciPesada = new Ciclista("Pesada", 30, equipo, biciPesada);

        assertTrue(ciclistaJoven.calcularVelocidad() > ciclistaVeterano.calcularVelocidad());
        assertTrue(ciclistaJoven.calcularVelocidad() > ciclistaConBiciPesada.calcularVelocidad());
    }
}