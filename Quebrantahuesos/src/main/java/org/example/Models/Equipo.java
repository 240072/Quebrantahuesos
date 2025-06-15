package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Ciclista> ciclistas;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.ciclistas = new ArrayList<>();
    }

    // Métodos
    public void agregarCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public double calcularPromedioVelocidad() {
        return ciclistas.stream()
                .mapToDouble(Ciclista::calcularVelocidad)
                .average()
                .orElse(0);
    }
}
