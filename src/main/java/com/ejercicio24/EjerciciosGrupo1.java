package com.ejercicio24;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosGrupo1 {

    // --- 1. ANALIZADOR DE CALIFICACIONES ---
    public static void ejercicio1(Scanner sc) {
        System.out.println("\n=== EJERCICIO 1: ANALIZADOR DE CALIFICACIONES ===");
        System.out.print("Ingrese cantidad de notas (N): ");
        int n = sc.nextInt();
        double[] notas = new double[n];
        double suma = 0;

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nota [" + (i + 1) + "] (0-100): ");
                notas[i] = sc.nextDouble();
            } while (notas[i] < 0 || notas[i] > 100);
            suma += notas[i];
        }

        double promedio = suma / n;

        // Mediana
        double[] ordenadas = notas.clone();
        Arrays.sort(ordenadas);
        double mediana = (n % 2 == 0) ? (ordenadas[n / 2 - 1] + ordenadas[n / 2]) / 2.0 : ordenadas[n / 2];

        // Moda
        double moda = ordenadas[0];
        int maxFrecuencia = 0;
        for (int i = 0; i < n; i++) {
            int conteo = 0;
            for (int j = 0; j < n; j++) {
                if (notas[j] == notas[i]) conteo++;
            }
            if (conteo > maxFrecuencia) {
                maxFrecuencia = conteo;
                moda = notas[i];
            }
        }

        // Porcentajes
        int aprobados = 0;
        for (double nota : notas) if (nota >= 60) aprobados++;
        int reprobados = n - aprobados;

        System.out.println("\n--- RESULTADOS ---");
        System.out.printf("Promedio: %.2f | Mediana: %.2f | Moda: %.2f\n", promedio, mediana, moda);
        System.out.printf("Aprobados: %.1f%% | Reprobados: %.1f%%\n", (aprobados * 100.0 / n), (reprobados * 100.0 / n));

        // Histograma
        int[] histograma = new int[10];
        for (double nota : notas) {
            int idx = (int) (nota / 10);
            if (idx >= 10) idx = 9;
            histograma[idx]++;
        }
        System.out.println("\n--- HISTOGRAMA ---");
        for (int i = 0; i < 10; i++) {
            System.out.printf("[%d0-%d9]: ", i, (i == 9 ? 100 : i * 10 + 9));
            for (int k = 0; k < histograma[i]; k++) System.out.print("*");
            System.out.println(" (" + histograma[i] + ")");
        }
    }

    // --- 2. COMPRESOR Y DESCOMPRESOR DE TEXTO ---
    public static void ejercicio2(Scanner sc) {
        System.out.println("\n=== EJERCICIO 2: COMPRESOR DE TEXTO ===");
        sc.nextLine();
        System.out.print("Ingrese texto a comprimir (ej. aaabbc): ");
        String texto = sc.nextLine();

        // Guardar cada letra en un arreglo
        char[] letras = texto.toCharArray();
        StringBuilder comprimido = new StringBuilder();

        int i = 0;
        while (i < letras.length) {
            char actual = letras[i];
            int conteo = 0;
            while (i < letras.length && letras[i] == actual) {
                conteo++;
                i++;
            }
            comprimido.append(actual).append(conteo);
        }

        System.out.println("Texto Comprimido: " + comprimido);

        // Descompresión
        StringBuilder descomprimido = new StringBuilder();
        String compStr = comprimido.toString();
        for (int j = 0; j < compStr.length(); j += 2) {
            char c = compStr.charAt(j);
            int rep = Character.getNumericValue(compStr.charAt(j + 1));
            for (int k = 0; k < rep; k++) descomprimido.append(c);
        }
        System.out.println("Texto Descomprimido: " + descomprimido);
    }

    // --- 3. JUEGO DEL AHORCADO ---
    public static void ejercicio3(Scanner sc) {
        System.out.println("\n=== EJERCICIO 3: JUEGO DEL AHORCADO ===");
        sc.nextLine();
        String[] jugadores = {"Jugador 1", "Jugador 2"};
        int[] puntajes = new int[jugadores.length];

        for (int j = 0; j < jugadores.length; j++) {
            System.out.println("\nTurno de: " + jugadores[j]);
            char[] palabraOculta = "JAVA".toCharArray();
            char[] progreso = {'_', '_', '_', '_'};
            int errores = 0;
            int maxErrores = 5;

            while (errores < maxErrores && new String(progreso).contains("_")) {
                System.out.println("Palabra: " + Arrays.toString(progreso) + " | Errores: " + errores + "/" + maxErrores);
                System.out.print("Ingrese una letra: ");
                char letra = Character.toUpperCase(sc.next().charAt(0));

                boolean acierto = false;
                for (int i = 0; i < palabraOculta.length; i++) {
                    if (palabraOculta[i] == letra) {
                        progreso[i] = letra;
                        acierto = true;
                    }
                }
                if (!acierto) errores++;
            }

            if (!new String(progreso).contains("_")) {
                System.out.println("¡Adivinaste la palabra!");
                puntajes[j] = 100 - (errores * 10);
            } else {
                System.out.println("Agotaste tus intentos.");
                puntajes[j] = 0;
            }
        }

        System.out.println("\n--- REGISTRO DE PUNTAJES ---");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i] + ": " + puntajes[i] + " pts");
        }
    }

    // --- 4. SISTEMA DE INVENTARIO CON HISTORIAL ---
    public static void ejercicio4() {
        System.out.println("\n=== EJERCICIO 4: SISTEMA DE INVENTARIO ===");
        String[] productos = {"Laptop", "Teclado", "Mouse"};
        int[] existenciasIniciales = {10, 25, 50};

        // Matriz de historial: columna 0 = Entradas, columna 1 = Salidas
        int[][] historialMovimientos = {
                {5, -2},  // Laptop
                {10, -5}, // Teclado
                {20, -10} // Mouse
        };

        System.out.println("--- REPORTES Y MOVIMIENTOS ---");
        for (int i = 0; i < productos.length; i++) {
            int entradas = historialMovimientos[i][0];
            int salidas = historialMovimientos[i][1];
            int stockFinal = existenciasIniciales[i] + entradas + salidas;

            System.out.printf("Producto: %-10s | Stock Inicial: %d | Entradas: +%d | Salidas: %d | Stock Final: %d\n",
                    productos[i], existenciasIniciales[i], entradas, salidas, stockFinal);
        }
    }

    // --- 5. AGENDA TELEFÓNICA CON BÚSQUEDA Y EXPORTACIÓN ---
    public static void ejercicio5(Scanner sc) {
        System.out.println("\n=== EJERCICIO 5: AGENDA TELEFÓNICA ===");
        sc.nextLine();

        // Arreglos paralelos
        String[] nombres = {"Juan Puello", "Carlos Perez", "Maria Gomez"};
        String[] telefonos = {"3001234567", "3109876543", "3205554433"};
        String[] correos = {"juan@mail.com", "carlos@mail.com", "maria@mail.com"};

        System.out.print("Ingrese término de búsqueda (prefijo de nombre o correo): ");
        String busqueda = sc.nextLine().toLowerCase();

        System.out.println("\n--- RESULTADOS DE BÚSQUEDA ---");
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].toLowerCase().contains(busqueda) || correos[i].toLowerCase().contains(busqueda)) {
                System.out.printf("Nombre: %-15s | Tel: %-10s | Correo: %s\n", nombres[i], telefonos[i], correos[i]);
            }
        }

        // Exportar a archivo de texto
        try (PrintWriter writer = new PrintWriter(new FileWriter("agenda.txt"))) {
            writer.println("--- LISTA DE CONTACTOS ---");
            for (int i = 0; i < nombres.length; i++) {
                writer.printf("%s, %s, %s\n", nombres[i], telefonos[i], correos[i]);
            }
            System.out.println("\n¡Lista exportada exitosamente a 'agenda.txt'!");
        } catch (Exception e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}