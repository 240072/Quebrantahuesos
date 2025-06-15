package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private final String nombre;
    private final List<Ciclista> ciclistas = new ArrayList<>();

    public Equipo(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del equipo no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void agregarCiclista(Ciclista ciclista) {
        if (ciclista != null && !ciclistas.contains(ciclista)) {
            ciclistas.add(ciclista);
            if (ciclista.getEquipo() != this) {
                ciclista.asignarEquipo(this);
            }
        }
    }

    public void removerCiclista(Ciclista ciclista) {
        ciclistas.remove(ciclista);
    }

    // Getters
    public String getNombre() { return nombre; }
    public List<Ciclista> getCiclistas() { return new ArrayList<>(ciclistas); }
}
