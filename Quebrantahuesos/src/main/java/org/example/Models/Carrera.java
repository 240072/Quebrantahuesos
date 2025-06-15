package org.example.Models;

import java.util.*;

public class Carrera {
    private String nombre;
    private List<Equipo> equipos;

    public Carrera(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    // Métodos
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }
}
