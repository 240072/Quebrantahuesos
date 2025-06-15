package org.example;

import org.example.Models.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testFlujoCompleto() {
        // 1. Crear organización
        Organizacion org = new Organizacion("Quebrantahuesos", 1988);

        // 2. Crear equipos
        Equipo team1 = new Equipo("Team Pirineos");
        Equipo team2 = new Equipo("Team Montañas");

        // 3. Registrar equipos
        org.registrarEquipo(team1);
        org.registrarEquipo(team2);

        // 4. Crear bicicletas
        Bicicleta bici1 = new Bicicleta("Bici 1", 6.8, "Carbono", 11);
        Bicicleta bici2 = new Bicicleta("Bici 2", 7.2, "Carbono", 10);

        // 5. Crear ciclistas
        Ciclista ciclista1 = new Ciclista("Ciclista", "Uno", 30, 90, team1);
        ciclista1.agregarBicicleta(bici1);

        Ciclista ciclista2 = new Ciclista("Ciclista", "Dos", 32, 85, team2);
        ciclista2.agregarBicicleta(bici2);

        // 6. Crear carrera
        Carrera carrera = new Carrera("Test Race", 100, 2000);
        carrera.agregarParticipante(ciclista1);
        carrera.agregarParticipante(ciclista2);

        // 7. Simular carrera
        carrera.simularCarrera();

        // 8. Verificar resultados
        assertNotNull(carrera.getResultados());
        assertEquals(2, carrera.getResultados().size());

        // 9. Verificar que el ciclista con mayor habilidad ganó
        assertTrue(carrera.getResultados().get(ciclista1).compareTo(carrera.getResultados().get(ciclista2)) < 0);
    }
}