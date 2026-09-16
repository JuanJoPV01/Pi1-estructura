package com.ejercicio24;

import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosGrupo6 {

    // --- 26. ASIGNACIÓN DE ASIENTOS EN CINE ---
    public static void ejercicio26(Scanner sc) {
        System.out.println("\n=== EJERCICIO 26: SISTEMA DE ASIENTOS EN CINE ===");
        char[][] sala = new char[5][5]; // 'L' = Libre, 'X' = Reservado
        for (char[] fila : sala) Arrays.fill(fila, 'L');

        // Reservas de prueba
        sala[1][2] = 'X';
        sala[3][4] = 'X';

        mostrarMapaCine(sala);

        System.out.print("\nIngrese Fila (0-4) y Columna (0-4) para reservar/liberar (ej: 2 3): ");
        int f = sc.nextInt();
        int c = sc.nextInt();

        if (f >= 0 && f < 5 && c >= 0 && c < 5) {
            if (sala[f][c] == 'L') {
                sala[f][c] = 'X';
                System.out.println("✅ Asiento [" + f + "][" + c + "] reservado con éxito.");
            } else {
                sala[f][c] = 'L';
                System.out.println("🔄 Asiento [" + f + "][" + c + "] liberado.");
            }
            mostrarMapaCine(sala);
        } else {
            System.out.println("Coordenadas fuera de rango.");
        }
    }

    private static void mostrarMapaCine(char[][] sala) {
        System.out.println("\n--- MAPA DE LA SALA ---");
        System.out.println("   0 1 2 3 4 (Cols)");
        for (int i = 0; i < sala.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < sala[i].length; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.println();
        }
    }

    // --- 27. REGISTRO DE LLAMADAS TELEFÓNICAS ---
    public static void ejercicio27(Scanner sc) {
        System.out.println("\n=== EJERCICIO 27: REGISTRO DE LLAMADAS TELEFÓNICAS ===");
        System.out.print("Ingrese la cantidad de llamadas a registrar: ");
        int cantidad = sc.nextInt();
        int[] duraciones = new int[cantidad]; // Duración en minutos
        int totalMinutos = 0;
        int idxMasLarga = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Duración de llamada #" + (i + 1) + " (minutos): ");
            duraciones[i] = sc.nextInt();
            totalMinutos += duraciones[i];

            if (duraciones[i] > duraciones[idxMasLarga]) {
                idxMasLarga = i;
            }
        }

        System.out.println("\n--- REPORTE DE LLAMADAS ---");
        System.out.println("Total de llamadas registradas: " + cantidad);
        System.out.println("Total de minutos consumidos:  " + totalMinutos + " min");
        System.out.println("📞 Llamada más larga:         Llamada #" + (idxMasLarga + 1) + " (" + duraciones[idxMasLarga] + " min)");
    }

    // --- 28. CONTROL DE ENTREGAS DE PAQUETES ---
    public static void ejercicio28(Scanner sc) {
        System.out.println("\n=== EJERCICIO 28: CONTROL DE ENTREGAS DE PAQUETES ===");
        String[] guiaPaquetes = {"PKG-001", "PKG-002", "PKG-003", "PKG-004", "PKG-005"};
        boolean[] entregados = {true, false, true, false, false};

        System.out.println("--- ESTADO DE PAQUETES ---");
        for (int i = 0; i < guiaPaquetes.length; i++) {
            System.out.printf("[%d] %-8s -> %s\n", i, guiaPaquetes[i], (entregados[i] ? "[ENTREGADO]" : "[PENDIENTE]"));
        }

        System.out.print("\nIngrese el índice del paquete para marcar como entregado (0-4): ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < guiaPaquetes.length) {
            entregados[idx] = true;
            System.out.println("✅ Paquete " + guiaPaquetes[idx] + " marcado como ENTREGADO.");
        } else {
            System.out.println("Índice de paquete inválido.");
        }

        System.out.println("\n--- PAQUETES PENDIENTES DE ENTREGA ---");
        int pendientes = 0;
        for (int i = 0; i < guiaPaquetes.length; i++) {
            if (!entregados[i]) {
                System.out.println("📦 " + guiaPaquetes[i]);
                pendientes++;
            }
        }
        System.out.println("Total de pendientes: " + pendientes);
    }

    // --- 29. SISTEMA DE TURNOS EN UN BANCO ---
    public static void ejercicio29(Scanner sc) {
        System.out.println("\n=== EJERCICIO 29: SISTEMA DE TURNOS BANCARIOS ===");
        String[] turnos = {"T-001", "T-002", "T-003", "T-004", "T-005"};
        int turnoActualIdx = 0;

        System.out.println("Turnos en cola de atención: " + Arrays.toString(turnos));

        System.out.println("\n🔔 Atendiendo a: " + turnos[turnoActualIdx]);
        turnoActualIdx++;

        System.out.println("--- PRÓXIMOS TURNOS EN ESPERA ---");
        for (int i = turnoActualIdx; i < turnos.length; i++) {
            System.out.println("En espera -> " + turnos[i]);
        }
    }

    // --- 30. REGISTRO DE USO DE TRANSPORTE PÚBLICO ---
    public static void ejercicio30(Scanner sc) {
        System.out.println("\n=== EJERCICIO 30: REGISTRO DE TRANSPORTE PÚBLICO ===");
        System.out.print("Ingrese la cantidad de viajes realizados en el día: ");
        int nViajes = sc.nextInt();
        int[] pasajeros = new int[nViajes];
        int sumaPasajeros = 0;
        int idxMayorOcupacion = 0;

        for (int i = 0; i < nViajes; i++) {
            System.out.print("Número de pasajeros en viaje #" + (i + 1) + ": ");
            pasajeros[i] = sc.nextInt();
            sumaPasajeros += pasajeros[i];

            if (pasajeros[i] > pasajeros[idxMayorOcupacion]) {
                idxMayorOcupacion = i;
            }
        }

        double promedio = (double) sumaPasajeros / nViajes;

        System.out.println("\n--- ESTADÍSTICAS DE TRANSPORTE ---");
        System.out.println("Total de pasajeros transportados: " + sumaPasajeros);
        System.out.printf("Promedio de pasajeros por viaje:   %.2f\n", promedio);
        System.out.println("🚌 Viaje con mayor ocupación:       Viaje #" + (idxMayorOcupacion + 1) + " con " + pasajeros[idxMayorOcupacion] + " pasajeros.");
    }
}