package org.example;

import org.example.Models.Ciclista;
import org.example.Models.Equipo;
import org.example.Repositorio.Repositorio;
import org.example.Services.CarreraService;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Repositorio repositorio = new Repositorio();
            CarreraService carreraService = new CarreraService(repositorio);

            Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion !=4){
            System.out.println("1.- Mostrar Equipos");
            System.out.println("2.- Mostrar Ciclistas");
            System.out.println("3.- Simular Carrera");
            System.out.println("4.- Salir");
            System.out.println("Introduce opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1 -> {
                    List<Equipo> equipos = repositorio.getEquipos();
                    for(Equipo equipo : equipos){
                        System.out.println(equipo);
                    }
                }
                case 2 -> {
                    List<Ciclista> ciclistas = repositorio.getCiclistas();
                    for(Ciclista ciclista : ciclistas){
                        System.out.println(ciclista);
                    }
                }
                case 3 -> {
                    System.out.println("Bienvenido al Simulador de Carreras de Ciclismo");
                    System.out.println("Selecciona una carrera para comenzar:");
                    System.out.println("1. Quebrantahuesos");
                    System.out.println("2. Treparriscos");
                    System.out.println("3. Pirenaica");
                    System.out.print("Opción: ");

                    int opcionCarrera = scanner.nextInt();

                    switch (opcionCarrera) {
                        case 1 -> carreraService.simularCarrera(repositorio.getCarreras().get(0));
                        case 2 -> carreraService.simularCarrera(repositorio.getCarreras().get(1));
                        case 3 -> carreraService.simularCarrera(repositorio.getCarreras().get(2));
                        default -> System.out.println("Opción no válida");
                    }
                }
                case 4 -> System.out.println("Fin de programa");
                default -> System.out.println("Opción no contemplada");
            }
        }
            scanner.close();
    }

}