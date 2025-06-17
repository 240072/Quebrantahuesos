package org.example.Repositorio;

import org.example.Models.*;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Ciclista> ciclistas;
    private List<Bicicleta> bicicletas;
    private List<Equipo> equipos;
    private List<Carrera> carreras;

    public Repositorio() {
        this.ciclistas = new ArrayList<>();
        this.bicicletas = new ArrayList<>();
        this.equipos = new ArrayList<>();
        this.carreras = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        // Crear bicicletas
        Bicicleta b1 = new Bicicleta("Carbono", 7.2);
        Bicicleta b2 = new Bicicleta("Aluminio", 8.5);
        Bicicleta b3 = new Bicicleta("Titanio", 6.8);
        Bicicleta b4 = new Bicicleta("Carbono", 7.0);
        Bicicleta b5 = new Bicicleta("Aluminio", 9.1);

        bicicletas.add(b1);
        bicicletas.add(b2);
        bicicletas.add(b3);
        bicicletas.add(b4);
        bicicletas.add(b5);

        // Crear equipos
        Equipo pirineoSur = new Equipo("Pirineo Sur");
        Equipo jaca = new Equipo("Jaca");
        Equipo sabi = new Equipo("Sabiñánigo");
        Equipo canfranc = new Equipo("Canfranc");
        Equipo formigal = new Equipo("Formigal");
        Equipo oloron = new Equipo("Oloron");
        Equipo pau = new Equipo("Pau");

        equipos.add(pirineoSur);
        equipos.add(jaca);
        equipos.add(sabi);
        equipos.add(canfranc);
        equipos.add(formigal);
        equipos.add(oloron);
        equipos.add(pau);

        // Crear ciclistas y asignar a equipos
        Ciclista c1 = new Ciclista("Alejandro Valverde", 42, pirineoSur, b1);
        Ciclista c2 = new Ciclista("Alejandro García", 29, pirineoSur, b2);
        Ciclista c3 = new Ciclista("Carlos Fernández", 16, pirineoSur, b3);
        Ciclista c4 = new Ciclista("David González", 27, pirineoSur, b4);
        Ciclista c5 = new Ciclista("Diego Rodríguez", 26, pirineoSur, b5);
        Ciclista c6 = new Ciclista("Emilio Martínez", 33, jaca, b5);
        Ciclista c7 = new Ciclista("Fernando Sánchez", 42, jaca, b4);
        Ciclista c8 = new Ciclista("Francisco Pérez", 19, jaca, b3);
        Ciclista c9 = new Ciclista("Gabriel Gómez", 24, jaca, b1);
        Ciclista c10 = new Ciclista("Gonzalo Martín", 27, sabi, b1);
        Ciclista c11 = new Ciclista("Javier Jiménez", 37, sabi, b2);
        Ciclista c12 = new Ciclista("Jorge Ruiz", 31, sabi, b5);
        Ciclista c13 = new Ciclista("José Hernández", 20, sabi, b5);
        Ciclista c14 = new Ciclista("Juan Díaz", 26, canfranc, b3);
        Ciclista c15 = new Ciclista("Luis Moreno", 22, canfranc, b4);
        Ciclista c16 = new Ciclista("Manuel Muñoz", 30, canfranc, b1);
        Ciclista c17 = new Ciclista("Miguel Romero", 35, formigal, b5);
        Ciclista c18 = new Ciclista("Pablo Alonso", 33, formigal, b1);
        Ciclista c19 = new Ciclista("Pedro Rubio", 21, formigal, b4);
        Ciclista c20 = new Ciclista("Rafael Navarro", 28, formigal, b5);
        Ciclista c21 = new Ciclista("Jean Dubois", 46, oloron, b2);
        Ciclista c22 = new Ciclista("Pierre Lefebvre", 19, oloron, b2);
        Ciclista c23 = new Ciclista("Antoine Moreau", 22, oloron, b3);
        Ciclista c24 = new Ciclista("Louis Laurent", 17, pau, b5);
        Ciclista c25 = new Ciclista("Lucas Fournier", 38, pau, b4);
        Ciclista c26 = new Ciclista("Gabriel Girard", 29, pau, b1);
        Ciclista c27 = new Ciclista("Hugo Dupont", 50, pau, b2);

        ciclistas.add(c1);
        ciclistas.add(c2);
        ciclistas.add(c3);
        ciclistas.add(c4);
        ciclistas.add(c5);
        ciclistas.add(c6);
        ciclistas.add(c7);
        ciclistas.add(c8);
        ciclistas.add(c9);
        ciclistas.add(c10);
        ciclistas.add(c11);
        ciclistas.add(c12);
        ciclistas.add(c13);
        ciclistas.add(c14);
        ciclistas.add(c15);
        ciclistas.add(c16);
        ciclistas.add(c17);
        ciclistas.add(c18);
        ciclistas.add(c19);
        ciclistas.add(c20);
        ciclistas.add(c21);
        ciclistas.add(c22);
        ciclistas.add(c23);
        ciclistas.add(c24);
        ciclistas.add(c25);
        ciclistas.add(c26);
        ciclistas.add(c27);


        pirineoSur.agregarCiclista(c1);
        pirineoSur.agregarCiclista(c2);
        pirineoSur.agregarCiclista(c3);
        pirineoSur.agregarCiclista(c4);
        pirineoSur.agregarCiclista(c5);

        jaca.agregarCiclista(c6);
        jaca.agregarCiclista(c7);
        jaca.agregarCiclista(c8);
        jaca.agregarCiclista(c9);

        sabi.agregarCiclista(c10);
        sabi.agregarCiclista(c11);
        sabi.agregarCiclista(c12);
        sabi.agregarCiclista(c13);

        canfranc.agregarCiclista(c14);
        canfranc.agregarCiclista(c15);
        canfranc.agregarCiclista(c16);

        formigal.agregarCiclista(c17);
        formigal.agregarCiclista(c18);
        formigal.agregarCiclista(c19);
        formigal.agregarCiclista(c20);

        oloron.agregarCiclista(c21);
        oloron.agregarCiclista(c22);
        oloron.agregarCiclista(c23);

        pau.agregarCiclista(c24);
        pau.agregarCiclista(c25);
        pau.agregarCiclista(c26);
        pau.agregarCiclista(c27);



        // Crear carreras
        Carrera quebrantahuesos = new Carrera("QUEBRANTAHUESOS");
        quebrantahuesos.agregarEquipo(pirineoSur);
        quebrantahuesos.agregarEquipo(canfranc);
        quebrantahuesos.agregarEquipo(formigal);
        quebrantahuesos.agregarEquipo(pau);
        quebrantahuesos.agregarEquipo(sabi);
        quebrantahuesos.agregarEquipo(oloron);


        Carrera treparriscos = new Carrera("TREPARRISCOS");
        treparriscos.agregarEquipo(pirineoSur);
        treparriscos.agregarEquipo(jaca);
        treparriscos.agregarEquipo(sabi);
        treparriscos.agregarEquipo(formigal);
        treparriscos.agregarEquipo(oloron);
        treparriscos.agregarEquipo(canfranc);
        treparriscos.agregarEquipo(pau);



        Carrera pirenaica = new Carrera("PIRENAICA");
        pirenaica.agregarEquipo(pirineoSur);
        pirenaica.agregarEquipo(oloron);
        pirenaica.agregarEquipo(canfranc);
        pirenaica.agregarEquipo(formigal);
        pirenaica.agregarEquipo(jaca);
        pirenaica.agregarEquipo(sabi);
        pirenaica.agregarEquipo(pau);


        carreras.add(quebrantahuesos);
        carreras.add(treparriscos);
        carreras.add(pirenaica);
    }

    // Getters
    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }
}
