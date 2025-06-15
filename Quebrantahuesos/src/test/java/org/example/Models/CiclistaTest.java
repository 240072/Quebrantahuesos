package org.example.Models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class CiclistaTest {
    private Ciclista ciclista;
    private Equipo equipo;
    private Bicicleta bici1;
    private Bicicleta bici2;

    @BeforeEach
    void setUp() {
        equipo = new Equipo("Team Pirineos");
        ciclista = new Ciclista("Alejandro", "Valverde", 42, 85, equipo);
        bici1 = new Bicicleta("Specialized S-Works", 6.8, "Carbono", 11);
        bici2 = new Bicicleta("Trek Emonda", 7.2, "Carbono", 10);
    }

    @Test
    void testCreacionCiclista() {
        assertNotNull(ciclista);
        assertEquals("Alejandro Valverde", ciclista.getNombreCompleto());
        assertEquals(85, ciclista.getHabilidad());
        assertEquals(equipo, ciclista.getEquipo());
    }

    @Test
    void testAgregarBicicleta() {
        ciclista.agregarBicicleta(bici1);
        assertEquals(1, ciclista.getBicicletas().size());
        assertEquals(ciclista, bici1.getPropietario());
    }

    @Test
    void testCalcularRendimiento() {
        ciclista.agregarBicicleta(bici1);
        double rendimiento = ciclista.calcularRendimiento(bici1);
        assertEquals(85 * 0.7 + bici1.getCalidad() * 0.3, rendimiento, 0.01);
    }

    @Test
    void testGetMejorBicicleta() {
        ciclista.agregarBicicleta(bici1);
        ciclista.agregarBicicleta(bici2);
        assertEquals(bici1, ciclista.getMejorBicicleta());
    }

    @Test
    void testConstructorConEquipoNull() {
        Ciclista ciclistaSinEquipo = new Ciclista("Prueba", "Test", 30, 80, null);
        assertNull(ciclistaSinEquipo.getEquipo());
    }

}