package org.example.Services;

import org.example.Models.Carrera;
import org.example.Models.Ciclista;
import org.example.Models.Equipo;
import org.example.Repositorio.Repositorio;

import java.util.*;

public class CarreraService {
    private Repositorio repositorio;

    public CarreraService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void simularCarrera(Carrera carrera) {
        System.out.println("\n¡Comienza la " + carrera.getNombre() + "!");
        System.out.println("Equipos participantes:");

        for (Equipo equipo : carrera.getEquipos()) {
            System.out.println("- " + equipo.getNombre());
        }

        // Simular carrera
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Determinar ganador
        Equipo ganador = determinarGanador(carrera);
        System.out.println("\n¡El equipo ganador es " + ganador.getNombre() + "!");

        // Mostrar mejor ciclista
        Ciclista mejorCiclista = ganador.getCiclistas().stream()
                .max((c1, c2) -> Double.compare(c1.calcularVelocidad(), c2.calcularVelocidad()))
                .orElse(null);

        if (mejorCiclista != null) {
            System.out.println("El mejor ciclista fue " + mejorCiclista.getNombre() +
                    " con una bicicleta de " + mejorCiclista.getBicicleta().getMaterial() +
                    " (" + mejorCiclista.getBicicleta().getPeso() + "kg)");
        }
    }

    public Equipo determinarGanador(Carrera carrera) {
        if (carrera == null || carrera.getEquipos() == null || carrera.getEquipos().isEmpty()) {
            throw new IllegalArgumentException("La carrera no tiene equipos participantes");
        }

        Random random = new Random();

        return carrera.getEquipos().stream()
                .max((e1, e2) -> {
                    try {
                        double velocidad1 = e1.calcularPromedioVelocidad() * (0.9 + 0.2 * random.nextDouble());
                        double velocidad2 = e2.calcularPromedioVelocidad() * (0.9 + 0.2 * random.nextDouble());
                        return Double.compare(velocidad1, velocidad2);
                    } catch (Exception e) {
                        return 0; // En caso de error, considera equipos iguales
                    }
                })
                .orElseThrow(() -> new IllegalStateException("No se pudo determinar un ganador"));
    }
}

