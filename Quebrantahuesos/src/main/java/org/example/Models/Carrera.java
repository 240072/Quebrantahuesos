package org.example.Models;

import java.time.Duration;
import java.util.*;

public class Carrera {
    private final String nombre;
    private final double distancia; // km
    private final double desnivel; // metros
    private final List<Ciclista> participantes = new ArrayList<>();
    private final Map<Ciclista, Duration> resultados = new LinkedHashMap<>();

    public Carrera(String nombre, double distancia, double desnivel) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la carrera no puede estar vacío");
        }
        this.nombre = nombre.trim();
        this.distancia = Math.max(0, distancia);
        this.desnivel = Math.max(0, desnivel);
    }

    public void agregarParticipante(Ciclista ciclista) {
        if (ciclista != null && !participantes.contains(ciclista)) {
            participantes.add(ciclista);
        }
    }

    public void simularCarrera() {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes para simular la carrera");
            return;
        }

        Random rand = new Random();
        resultados.clear();

        for (Ciclista ciclista : participantes) {
            if (ciclista == null) continue;

            Bicicleta bici = ciclista.getMejorBicicleta();
            double rendimientoBase = ciclista.calcularRendimiento(bici);

            // Factores aleatorios (clima, estado físico del día, etc.)
            double factorAleatorio = 0.8 + (1.2 - 0.8) * rand.nextDouble();
            double rendimientoFinal = rendimientoBase * factorAleatorio;

            // Calcular tiempo (a menor peso de bicicleta, mejor tiempo)
            double tiempoBase = distancia * 60 * (2 - (rendimientoFinal / 100)); // minutos
            tiempoBase *= (1 + (desnivel / 10000)); // Afecta el desnivel

            // Convertir a Duration
            int minutos = (int) tiempoBase;
            int segundos = (int) ((tiempoBase - minutos) * 60);
            Duration tiempo = Duration.ofMinutes(minutos).plusSeconds(segundos);

            resultados.put(ciclista, tiempo);
        }

        // Ordenar resultados por tiempo
        List<Map.Entry<Ciclista, Duration>> listaOrdenada = new ArrayList<>(resultados.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        // Reconstruir el mapa ordenado
        resultados.clear();
        for (Map.Entry<Ciclista, Duration> entry : listaOrdenada) {
            resultados.put(entry.getKey(), entry.getValue());
        }
    }

    public void mostrarResultados() {
        System.out.println("\n=== RESULTADOS " + nombre.toUpperCase() + " ===");
        System.out.printf("Distancia: %.1fkm | Desnivel: %.0fm%n", distancia, desnivel);
        System.out.println("----------------------------------------");

        if (resultados.isEmpty()) {
            System.out.println("No hay resultados disponibles");
            return;
        }

        int posicion = 1;
        for (Map.Entry<Ciclista, Duration> entry : resultados.entrySet()) {
            Ciclista ciclista = entry.getKey();
            Duration tiempo = entry.getValue();

            if (ciclista == null) continue;

            long horas = tiempo.toHours();
            long minutos = tiempo.toMinutesPart();
            long segundos = tiempo.toSecondsPart();

            String nombreEquipo = (ciclista.getEquipo() != null) ? ciclista.getEquipo().getNombre() : "Sin equipo";
            Bicicleta bici = ciclista.getMejorBicicleta();
            String modeloBici = (bici != null) ? bici.getModelo() : "Sin bicicleta";
            double pesoBici = (bici != null) ? bici.getPeso() : 0.0;

            System.out.printf("%d. %s (%s) - %02d:%02d:%02d | Bici: %s (%.1fkg)%n",
                    posicion++,
                    ciclista.getNombreCompleto(),
                    nombreEquipo,
                    horas, minutos, segundos,
                    modeloBici,
                    pesoBici);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getDesnivel() {
        return desnivel;
    }

    public List<Ciclista> getParticipantes() {
        return participantes;
    }

    public Map<Ciclista, Duration> getResultados() {
        return resultados;
    }
}
