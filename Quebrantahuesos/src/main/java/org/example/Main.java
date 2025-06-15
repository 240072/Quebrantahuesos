package org.example;

import org.example.Models.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // 1. Inicialización de la organización
            Organizacion quebrantahuesosOrg = new Organizacion("Quebrantahuesos", 1988);

            // 2. Creación de equipos (PRIMERO LOS EQUIPOS)
            Equipo teamPirineoAragones = new Equipo("Equipo Pirineo Aragonés");
            Equipo teamPirineoFrances = new Equipo("Equipo Pirineo Francés");

            // 3. Registro de equipos en la organización
            quebrantahuesosOrg.registrarEquipo(teamPirineoAragones);
            quebrantahuesosOrg.registrarEquipo(teamPirineoFrances);

            // 4. Creación de bicicletas
            Bicicleta bici1 = new Bicicleta("Specialized S-Works", 6.8, "Carbono", 11);
            Bicicleta bici2 = new Bicicleta("Trek Emonda", 7.2, "Carbono", 10);
            Bicicleta bici3 = new Bicicleta("Canyon Ultimate", 7.0, "Carbono", 11);
            Bicicleta bici4 = new Bicicleta("Bianchi Oltre", 7.1, "Carbono", 10);
            Bicicleta bici5 = new Bicicleta("Pinarello Dogma", 6.9, "Carbono", 12);

            // 5. Creación de ciclistas (ASEGURANDO QUE TIENEN EQUIPO)
            Ciclista ciclista1 = new Ciclista("Manolo", "Ascaso", 32, 88, teamPirineoAragones);
            ciclista1.agregarBicicleta(bici1);
            ciclista1.agregarBicicleta(bici3);

            Ciclista ciclista2 = new Ciclista("Eustaquio", "Valverde", 42, 85, teamPirineoAragones);
            ciclista2.agregarBicicleta(bici2);

            Ciclista ciclista3 = new Ciclista("Pierre", "Moreau", 29, 86, teamPirineoFrances);
            ciclista3.agregarBicicleta(bici4);

            Ciclista ciclista4 = new Ciclista("François", "Lambert", 32, 87, teamPirineoFrances);
            ciclista4.agregarBicicleta(bici5);

            // 6. Crear carrera y agregar participantes
            Carrera quebrantahuesos2023 = new Carrera("Quebrantahuesos 2025", 200, 4000);
            quebrantahuesos2023.agregarParticipante(ciclista1);
            quebrantahuesos2023.agregarParticipante(ciclista2);
            quebrantahuesos2023.agregarParticipante(ciclista3);
            quebrantahuesos2023.agregarParticipante(ciclista4);

            // 7. Simular carrera y mostrar resultados
            quebrantahuesos2023.simularCarrera();
            quebrantahuesos2023.mostrarResultados();

            // 8. Mostrar información de la organización
            quebrantahuesosOrg.mostrarInformacion();

        } catch (Exception e) {
            System.err.println("Error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}