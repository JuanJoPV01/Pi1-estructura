package com.ejercicio24;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   EJERCICIO 19: ANALIZADOR DE DATOS CLIMÁTICOS   ");
        System.out.println("==================================================\n");

        // Matriz bidimensional 12 meses x 2 columnas (Col 0: Temp °C, Col 1: Humedad %)
        double[][] clima = {
                {28.5, 75}, {29.0, 72}, {30.1, 70}, {31.0, 68},
                {30.5, 78}, {29.8, 80}, {29.2, 82}, {29.5, 81},
                {30.0, 79}, {28.8, 83}, {28.2, 85}, {28.0, 77}
        };

        double sumaTemp = 0, sumaHum = 0;
        System.out.println("Mes\t\tTemperatura (°C)\tHumedad (%)");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 12; i++) {
            sumaTemp += clima[i][0];
            sumaHum += clima[i][1];
            System.out.printf("Mes %2d\t\t%.1f°C\t\t\t%.1f%%\n", (i + 1), clima[i][0], clima[i][1]);
        }

        double promTemp = sumaTemp / 12;
        double promHum = sumaHum / 12;

        System.out.println("\n--------------------------------------------------");
        System.out.printf("PROMEDIO ANUAL -> Temperatura: %.2f°C | Humedad: %.2f%%\n", promTemp, promHum);

        System.out.println("\n--- ANOMALÍAS DETECTADAS (Temperatura > 30.5°C) ---");
        boolean hayAnomalias = false;
        for (int i = 0; i < 12; i++) {
            if (clima[i][0] > 30.5) {
                System.out.printf("⚠️  Mes %d: Valor fuera de rango con %.1f°C\n", (i + 1), clima[i][0]);
                hayAnomalias = true;
            }
        }
        if (!hayAnomalias) {
            System.out.println("No se registraron anomalías en el año.");
        }
    }
}