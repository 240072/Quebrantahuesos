package org.example.Models;


public class Bicicleta {
    private String material;
    private double peso; // en kg

    public Bicicleta(String material, double peso) {
        this.material = material;
        this.peso = peso;
    }

    // Getters
    public String getMaterial() {
        return material;
    }

    public double getPeso() {
        return peso;
    }
}
