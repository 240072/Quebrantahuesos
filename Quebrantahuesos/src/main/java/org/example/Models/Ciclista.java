package org.example.Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ciclista {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final int habilidad; // Escala de 1-100
    private Equipo equipo;
    private final List<Bicicleta> bicicletas = new ArrayList<>();

    public Ciclista(String nombre, String apellido, int edad, int habilidad, Equipo equipo) {
        if (nombre == null || apellido == null) {
            throw new IllegalArgumentException("Nombre y apellido no pueden ser nulos");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidad = Math.max(1, Math.min(100, habilidad)); // Asegurar rango 1-100

        if (equipo != null) {
            this.equipo = equipo;
            equipo.agregarCiclista(this);
        } else {
            System.out.println("Advertencia: " + getNombreCompleto() + " creado sin equipo");
        }
    }

    public void asignarEquipo(Equipo equipo) {
        if (this.equipo != null) {
            this.equipo.removerCiclista(this);
        }
        this.equipo = equipo;
        if (equipo != null) {
            equipo.agregarCiclista(this);
        }
    }

    public void agregarBicicleta(Bicicleta bici) {
        if (bici != null) {
            bicicletas.add(bici);
            bici.setPropietario(this);
        }
    }

    public double calcularRendimiento(Bicicleta bici) {
        if (bici == null) {
            return habilidad * 0.7; // Solo consideramos habilidad si no hay bici
        }
        return (habilidad * 0.7) + (bici.getCalidad() * 0.3);
    }

    public Bicicleta getMejorBicicleta() {
        if (bicicletas.isEmpty()) {
            return null;
        }
        return bicicletas.stream()
                .max(Comparator.comparingInt(Bicicleta::getCalidad))
                .orElse(null);
    }

    // Getters
    public String getNombreCompleto() { return nombre + " " + apellido; }
    public int getHabilidad() { return habilidad; }
    public Equipo getEquipo() { return equipo; }
    public List<Bicicleta> getBicicletas() { return new ArrayList<>(bicicletas); }
}
