package com.ejercicio24;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EjerciciosGrupo4 {

    // --- 16. JUEGO DE CONECTA 4 ---
    public static void ejercicio16(Scanner sc) {
        System.out.println("\n=== EJERCICIO 16: CONECTA 4 (DEMO DE TABLERO) ===");
        char[][] tablero = new char[6][7];
        for (char[] fila : tablero) Arrays.fill(fila, '.');

        char turno = 'X';
        System.out.println("Insertando fichas de prueba...");

        // Insertar en columna 3
        tablero[5][3] = 'X';
        tablero[4][3] = 'O';
        tablero[3][3] = 'X';

        System.out.println("\n--- ESTADO DEL TABLERO (6x7) ---");
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6 (Columnas)");
    }

    // --- 17. SIMULADOR DE CAJERO AUTOMÁTICO ---
    public static void ejercicio17(Scanner sc) {
        System.out.println("\n=== EJERCICIO 17: SIMULADOR DE CAJERO AUTOMÁTICO ===");
        int[] denominaciones = {100000, 50000, 20000, 10000};
        int[] cantidades = {10, 20, 30, 50}; // Billetes disponibles

        int saldoTotal = 0;
        for (int i = 0; i < denominaciones.length; i++) {
            saldoTotal += denominaciones[i] * cantidades[i];
        }

        System.out.println("Saldo total disponible en cajero: $" + saldoTotal);
        System.out.print("Ingrese monto a retirar: $");
        int retiro = sc.nextInt();

        if (retiro > saldoTotal || retiro % 10000 != 0) {
            System.out.println("Monto inválido o superior al saldo disponible.");
            return;
        }

        System.out.println("\n--- DESGLOSE DE BILLETES ENTREGADOS ---");
        int restante = retiro;
        for (int i = 0; i < denominaciones.length; i++) {
            int necesarios = restante / denominaciones[i];
            int aEntregar = Math.min(necesarios, cantidades[i]);
            if (aEntregar > 0) {
                System.out.printf("Billetes de $%d: %d\n", denominaciones[i], aEntregar);
                cantidades[i] -= aEntregar;
                restante -= aEntregar * denominaciones[i];
            }
        }

        if (restante > 0) {
            System.out.println("No se pudo entregar el monto exacto por falta de billetes menores.");
        } else {
            System.out.println("Retiro completado exitosamente.");
        }
    }

    // --- 18. MEZCLADOR DE CANCIONES ---
    public static void ejercicio18(Scanner sc) {
        System.out.println("\n=== EJERCICIO 18: MEZCLADOR DE CANCIONES ===");
        String[] titulos = {"De Música Ligera", "Cali Pachanguero", "La Camisa Negra", "Bachata Rosa"};
        String[] artistas = {"Soda Stereo", "Grupo Niche", "Juanes", "Juan Luis Guerra"};
        int[] duracionSeg = {212, 310, 216, 255};

        // Playlist aleatoria sin repetir
        int[] indices = {0, 1, 2, 3};
        Random rand = new Random();
        for (int i = indices.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = indices[i];
            indices[i] = indices[j];
            indices[j] = temp;
        }

        System.out.println("--- PLAYLIST ALEATORIA MEZCLADA ---");
        for (int idx : indices) {
            int min = duracionSeg[idx] / 60;
            int seg = duracionSeg[idx] % 60;
            System.out.printf("- %s - %s (%d:%02d)\n", titulos[idx], artistas[idx], min, seg);
        }
    }

    // --- 19. ANALIZADOR DE DATOS CLIMÁTICOS ---
    public static void ejercicio19() {
        System.out.println("\n=== EJERCICIO 19: ANALIZADOR DE DATOS CLIMÁTICOS ===");
        // Matriz 12 meses x 2 columnas (Col 0: Temp °C, Col 1: Humedad %)
        double[][] clima = {
                {28.5, 75}, {29.0, 72}, {30.1, 70}, {31.0, 68},
                {30.5, 78}, {29.8, 80}, {29.2, 82}, {29.5, 81},
                {30.0, 79}, {28.8, 83}, {28.2, 85}, {28.0, 77}
        };

        double sumaTemp = 0, sumaHum = 0;
        System.out.println("Mes\t\tTemp (°C)\tHumedad (%)");
        for (int i = 0; i < 12; i++) {
            sumaTemp += clima[i][0];
            sumaHum += clima[i][1];
            System.out.printf("Mes %2d\t\t%.1f\t\t%.1f%%\n", (i + 1), clima[i][0], clima[i][1]);
        }

        double promTemp = sumaTemp / 12;
        double promHum = sumaHum / 12;

        System.out.printf("\nPromedio Anual -> Temp: %.2f°C | Humedad: %.2f%%\n", promTemp, promHum);

        System.out.println("\n--- ANOMALÍAS DETECTADAS (Temp > 30.5°C) ---");
        for (int i = 0; i < 12; i++) {
            if (clima[i][0] > 30.5) {
                System.out.printf("Anomalía en Mes %d: Temp elevadamente alta (%.1f°C)\n", (i + 1), clima[i][0]);
            }
        }
    }

    // --- 20. EDITOR DE IMÁGENES EN ESCALA DE GRISES ---
    public static void ejercicio20() {
        System.out.println("\n=== EJERCICIO 20: EDITOR DE IMAGEN (MATRIZ 4x4) ===");
        int[][] imagen = {
                {50,  100, 150, 200},
                {80,  120, 160, 220},
                {30,  90,  140, 180},
                {10,  40,  70,  110}
        };

        System.out.println("Imagen Original (0-255):");
        imprimirMatriz(imagen);

        // a. Inversión de colores
        int[][] invertida = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invertida[i][j] = 255 - imagen[i][j];
            }
        }
        System.out.println("\nImagen Invertida:");
        imprimirMatriz(invertida);

        // b. Aclarar (+50 a cada píxel)
        int[][] aclarada = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                aclarada[i][j] = Math.min(255, imagen[i][j] + 50);
            }
        }
        System.out.println("\nImagen Aclarada:");
        imprimirMatriz(aclarada);
    }

    private static void imprimirMatriz(int[][] m) {
        for (int[] fila : m) {
            for (int p : fila) {
                System.out.printf("%4d ", p);
            }
            System.out.println();
        }
    }
}