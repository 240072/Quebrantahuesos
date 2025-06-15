package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private String nombre;
    private int añoFundacion;
    private List<Equipo> equiposRegistrados = new ArrayList<>();

    public Organizacion(String nombre, int añoFundacion) {
        this.nombre = nombre;
        this.añoFundacion = añoFundacion;
    }

    public void registrarEquipo(Equipo equipo) {
        equiposRegistrados.add(equipo);
    }

    public void mostrarInformacion() {
        System.out.println("\n=== INFORMACIÓN DE LA ORGANIZACIÓN ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Año de fundación: " + añoFundacion);
        System.out.println("Equipos registrados: " + equiposRegistrados.size());
        System.out.println("Ciclistas participantes: " +
                equiposRegistrados.stream().mapToInt(e -> e.getCiclistas().size()).sum());
    }

    public String getNombre() {
        return nombre;
    }

    public int getAñoFundacion() {
        return añoFundacion;
    }

    public List<Equipo> getEquiposRegistrados() {
        return equiposRegistrados;
    }
}
