package org.example.Models;

public class Ciclista {
    private String nombre;
    private int edad;
    private Equipo equipo;
    private Bicicleta bicicleta;

    public Ciclista(String nombre, int edad, Equipo equipo, Bicicleta bicicleta) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
        this.bicicleta = bicicleta;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public double calcularVelocidad() {
        // La velocidad depende de la edad (experiencia) y el peso de la bicicleta
        double factorEdad = 1.0 - (Math.max(0, edad - 30) * 0.01); // A partir de 30 años pierde 1% por año
        double velocidad = (10.0 / bicicleta.getPeso()) * factorEdad;
        return velocidad;
    }
}
