package org.example.Services;

import org.example.Models.Bicicleta;
import org.example.Models.Carrera;
import org.example.Models.Ciclista;
import org.example.Models.Equipo;
import org.example.Repositorio.Repositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarreraServiceTest {
    private CarreraService carreraService;
    private Repositorio repositorio;

    @BeforeEach
    void setUp() {
        repositorio = new Repositorio();
        carreraService = new CarreraService(repositorio);
    }

    @Test
    void testDeterminarGanadorConDatosReales() {
        Carrera carrera = repositorio.getCarreras().get(0);
        Equipo ganador = carreraService.determinarGanador(carrera);

        assertNotNull(ganador);
        assertTrue(carrera.getEquipos().contains(ganador));
    }

    @Test
    void testDeterminarGanadorConDatosSimplificados() {
        // Configuración simplificada
        Carrera carrera = new Carrera("Carrera Test");
        Equipo equipo1 = new Equipo("Equipo Rapido");
        Equipo equipo2 = new Equipo("Equipo Lento");

        // Bicicletas (la más ligera es más rápida)
        Bicicleta biciRapida = new Bicicleta("Carbono", 6.0);
        Bicicleta biciLenta = new Bicicleta("Acero", 10.0);

        // Ciclistas (misma edad para eliminar ese factor)
        Ciclista c1 = new Ciclista("Ciclista Rapido", 30, equipo1, biciRapida);
        Ciclista c2 = new Ciclista("Ciclista Lento", 30, equipo2, biciLenta);

        equipo1.agregarCiclista(c1);
        equipo2.agregarCiclista(c2);

        carrera.agregarEquipo(equipo1);
        carrera.agregarEquipo(equipo2);

        // Ejecutamos múltiples veces porque hay un factor aleatorio
        int victoriasEquipo1 = 0;
        for (int i = 0; i < 100; i++) {
            Equipo ganador = carreraService.determinarGanador(carrera);
            if (ganador == equipo1) {
                victoriasEquipo1++;
            }
        }

        // El equipo rápido debería ganar más del 75% de las veces
        assertTrue(victoriasEquipo1 > 75);
    }

    @Test
    void testDeterminarGanadorConCarreraVacia() {
        Carrera carreraVacia = new Carrera("Carrera sin equipos");

        assertThrows(IllegalArgumentException.class, () -> {
            carreraService.determinarGanador(carreraVacia);
        });
    }

    @Test
    void testDeterminarGanadorConUnSoloEquipo() {
        Carrera carrera = new Carrera("Carrera con un equipo");
        Equipo equipoUnico = new Equipo("Equipo Unico");

        // Agregar un ciclista al equipo
        Bicicleta bici = new Bicicleta("Carbono", 7.0);
        Ciclista ciclista = new Ciclista("Unico", 30, equipoUnico, bici);
        equipoUnico.agregarCiclista(ciclista);

        carrera.agregarEquipo(equipoUnico);

        Equipo ganador = carreraService.determinarGanador(carrera);
        assertEquals(equipoUnico, ganador);
    }
}