package org.example.Models;

public class Bicicleta {
    private String modelo;
    private double peso; // kg
    private String material;
    private int cambios;
    private Ciclista propietario;
    private int calidad; // Escala de 1-10 calculada automáticamente

    public Bicicleta(String modelo, double peso, String material, int cambios) {this.modelo = modelo;
        this.peso = peso;
        this.material = material;
        this.cambios = cambios;
        this.calidad = calcularCalidad();
}

private int calcularCalidad() {
    int calidadBase = 5;
    calidadBase += (peso < 7) ? 2 : (peso < 7.5) ? 1 : 0;
    calidadBase += (material.equals("Carbono")) ? 2 : 0;
    calidadBase += (cambios >= 11) ? 1 : 0;
    return Math.min(10, calidadBase);
}

// Getters y setters

    public String getModelo() {
        return modelo;
    }

    public double getPeso() {
        return peso;
    }

    public String getMaterial() {
        return material;
    }

    public int getCambios() {
        return cambios;
    }

    public Ciclista getPropietario() {
        return propietario;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setPropietario(Ciclista propietario) {
        this.propietario = propietario;
    }
}
