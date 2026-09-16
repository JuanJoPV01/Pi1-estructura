package com.ejercicio24;

import java.util.Scanner;

public class EjerciciosGrupo5 {

    // --- 21. CONTROL DE TURNOS EN PELUQUERÍA ---
    public static void ejercicio21(Scanner sc) {
        System.out.println("\n=== EJERCICIO 21: CONTROL DE TURNOS DE PELUQUERÍA ===");
        String[] horarios = {"08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "02:00 PM", "03:00 PM"};
        boolean[] ocupados = new boolean[horarios.length];

        // Simulación de turno ocupado
        ocupados[1] = true;

        System.out.println("--- ESTADO DE HORARIOS ---");
        for (int i = 0; i < horarios.length; i++) {
            System.out.println("[" + i + "] " + horarios[i] + " -> " + (ocupados[i] ? "[OCUPADO]" : "[LIBRE]"));
        }

        System.out.print("Seleccione el índice del horario a reservar (0-5): ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < horarios.length) {
            if (!ocupados[idx]) {
                ocupados[idx] = true;
                System.out.println("✅ Cita agendada exitosamente a las " + horarios[idx]);
            } else {
                System.out.println("❌ El horario seleccionado ya se encuentra ocupado.");
            }
        } else {
            System.out.println("Índice de horario inválido.");
        }
    }

    // --- 22. SISTEMA DE PARQUEADERO ---
    public static void ejercicio22(Scanner sc) {
        System.out.println("\n=== EJERCICIO 22: SISTEMA DE PARQUEADERO ===");
        boolean[] puestos = new boolean[10]; // false = Libre, true = Ocupado
        puestos[0] = true;
        puestos[4] = true;

        int libres = 0;
        System.out.println("--- DISPONIBILIDAD DE ESPACIOS ---");
        for (int i = 0; i < puestos.length; i++) {
            System.out.println("Puesto #" + i + ": " + (puestos[i] ? "[OCUPADO]" : "[LIBRE]"));
            if (!puestos[i]) libres++;
        }
        System.out.println("Total de espacios disponibles: " + libres);

        System.out.print("Ingrese el número de puesto para modificar estado (0-9): ");
        int p = sc.nextInt();

        if (p >= 0 && p < puestos.length) {
            puestos[p] = !puestos[p];
            System.out.println("Puesto #" + p + " ahora está: " + (puestos[p] ? "OCUPADO (Ingreso)" : "LIBRE (Salida)"));
        } else {
            System.out.println("Número de puesto no válido.");
        }
    }

    // --- 23. SIMULADOR DE SEMÁFORO INTELIGENTE ---
    public static void ejercicio23() {
        System.out.println("\n=== EJERCICIO 23: SIMULADOR DE SEMÁFORO ===");
        String[] estados = {"ROJO (Detenerse)", "VERDE (Avanzar)", "AMARILLO (Precaución)"};
        int[] tiempos = {2, 2, 1}; // Segundos de simulación

        System.out.println("--- SECUENCIA DE FUNCIONAMIENTO ---");
        for (int i = 0; i < estados.length; i++) {
            System.out.println("🚦 Estado actual: " + estados[i] + " por " + tiempos[i] + "s");
            try {
                Thread.sleep(1000); // Pausa de ejecución en consola
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Secuencia de tráfico completada exitosamente.");
    }

    // --- 24. REGISTRO DE PEDIDOS EN UNA CAFETERÍA ---
    public static void ejercicio24(Scanner sc) {
        System.out.println("\n=== EJERCICIO 24: REGISTRO DE PEDIDOS EN CAFETERÍA ===");
        String[] menu = {"Café Americano", "Capuchino", "Mochaccino", "Té Verde"};
        int[] conteo = new int[menu.length];

        System.out.print("Ingrese la cantidad de pedidos a registrar: ");
        int total = sc.nextInt();

        for (int i = 0; i < total; i++) {
            System.out.println("\nMenú: [0] Café Americano | [1] Capuchino | [2] Mochaccino | [3] Té Verde");
            System.out.print("Selección para pedido #" + (i + 1) + ": ");
            int opcion = sc.nextInt();

            if (opcion >= 0 && opcion < menu.length) {
                conteo[opcion]++;
            } else {
                System.out.println("Opción fuera de rango, no registrada.");
            }
        }

        int masSolicitado = 0;
        System.out.println("\n--- REPORTE DE PEDIDOS DEL DÍA ---");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("- " + menu[i] + ": " + conteo[i] + " pedido(s)");
            if (conteo[i] > conteo[masSolicitado]) {
                masSolicitado = i;
            }
        }
        System.out.println("⭐ Producto más solicitado: " + menu[masSolicitado] + " con " + conteo[masSolicitado] + " solicitudes.");
    }

    // --- 25. CONTROL DE SALA DE CÓMPUTO ---
    public static void ejercicio25(Scanner sc) {
        System.out.println("\n=== EJERCICIO 25: CONTROL DE SALA DE CÓMPUTO ===");
        String[] pcs = new String[8]; // Guardará el nombre del usuario o null si libre
        pcs[1] = "Juan";
        pcs[5] = "Maria";

        int disponibles = 0;
        System.out.println("--- ESTADO DE COMPUTADORES ---");
        for (int i = 0; i < pcs.length; i++) {
            if (pcs[i] == null) {
                System.out.println("PC #" + (i + 1) + ": [DISPONIBLE]");
                disponibles++;
            } else {
                System.out.println("PC #" + (i + 1) + ": [OCUPADO por " + pcs[i] + "]");
            }
        }
        System.out.println("Total de equipos libres: " + disponibles);

        System.out.print("\nIngrese el número de PC a asignar (1-8): ");
        int pcNum = sc.nextInt() - 1;
        sc.nextLine(); // Limpiar buffer

        if (pcNum >= 0 && pcNum < pcs.length) {
            if (pcs[pcNum] == null) {
                System.out.print("Ingrese nombre del usuario: ");
                String usuario = sc.nextLine();
                pcs[pcNum] = usuario;
                System.out.println("✅ PC #" + (pcNum + 1) + " asignado a " + usuario);
            } else {
                System.out.println("❌ El equipo ya está siendo utilizado.");
            }
        } else {
            System.out.println("Número de PC no válido.");
        }
    }
}