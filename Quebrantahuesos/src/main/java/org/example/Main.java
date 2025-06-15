package org.example;

import org.example.Repository.Repositorio;
import org.example.Services.CarreraService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Repositorio repositorio = new Repositorio();
            CarreraService carreraService = new CarreraService(repositorio);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenido al Simulador de Carreras de Ciclismo");
            System.out.println("Selecciona una carrera para comenzar:");
            System.out.println("1. Quebrantahuesos");
            System.out.println("2. Treparriscos");
            System.out.println("3. Pirenaica");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    carreraService.simularCarrera(repositorio.getCarreras().get(0));
                    break;
                case 2:
                    carreraService.simularCarrera(repositorio.getCarreras().get(1));
                    break;
                case 3:
                    carreraService.simularCarrera(repositorio.getCarreras().get(2));
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            scanner.close();
    }

}