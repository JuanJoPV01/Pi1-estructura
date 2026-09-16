package com.ejercicio24;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EjerciciosGrupo2 {

    // --- 6. ANALIZADOR DE ARCHIVOS NUMÉRICOS ---
    public static void ejercicio6(Scanner sc) {
        System.out.println("\n=== EJERCICIO 6: ANALIZADOR DE ARCHIVOS NUMÉRICOS ===");
        String archivoEntrada = "numeros.txt";
        String archivoSalida = "numeros_ordenados.txt";

        // Generar archivo con datos de prueba si no existe
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoEntrada))) {
            pw.println("45\n12\n89\n3\n27\n64\n15\n92\n8");
            System.out.println("Archivo de prueba '" + archivoEntrada + "' preparado.");
        } catch (Exception e) {
            System.out.println("Error al crear archivo de prueba: " + e.getMessage());
        }

        // Leer datos desde archivo a un arreglo
        int[] numeros = new int[100];
        int contador = 0;

        try (Scanner fileScanner = new Scanner(new File(archivoEntrada))) {
            while (fileScanner.hasNextInt() && contador < numeros.length) {
                numeros[contador++] = fileScanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Copiar exactos a arreglo ajustado
        int[] datos = Arrays.copyOf(numeros, contador);

        // Estadísticas
        int min = datos[0], max = datos[0], suma = 0;
        for (int num : datos) {
            if (num < min) min = num;
            if (num > max) max = num;
            suma += num;
        }
        double promedio = (double) suma / contador;

        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Mínimo: " + min + " | Máximo: " + max + " | Promedio: " + String.format("%.2f", promedio));

        // Ordenar y guardar en nuevo archivo
        Arrays.sort(datos);
        try (PrintWriter pwSalida = new PrintWriter(new FileWriter(archivoSalida))) {
            for (int num : datos) pwSalida.println(num);
            System.out.println("Números ordenados guardados en '" + archivoSalida + "'");
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo ordenado: " + e.getMessage());
        }
    }

    // --- 7. SIMULADOR DE VENTAS ---
    public static void ejercicio7(Scanner sc) {
        System.out.println("\n=== EJERCICIO 7: SIMULADOR DE VENTAS ===");
        String[] productos = {"Empanada", "Gaseosa", "Café", "Sandwich"};
        double[] precios = {2500.0, 3000.0, 1500.0, 6000.0};
        int[] cantidades = new int[productos.length];

        System.out.println("--- REGISTRO DE CANTIDADES VENDIDAS ---");
        for (int i = 0; i < productos.length; i++) {
            System.out.print("Cantidad vendida de " + productos[i] + " ($" + precios[i] + "): ");
            cantidades[i] = sc.nextInt();
        }

        double totalGeneral = 0;
        int indiceMasVendido = 0;

        System.out.println("\n--- REPORTE DE VENTAS ---");
        for (int i = 0; i < productos.length; i++) {
            double totalProducto = precios[i] * cantidades[i];
            totalGeneral += totalProducto;
            System.out.printf("%-10s | Cantidad: %2d | Total: $%.2f\n", productos[i], cantidades[i], totalProducto);

            if (cantidades[i] > cantidades[indiceMasVendido]) {
                indiceMasVendido = i;
            }
        }

        System.out.printf("\nTotal General de Ventas: $%.2f\n", totalGeneral);
        System.out.println("⭐ Producto más vendido: " + productos[indiceMasVendido] + " (" + cantidades[indiceMasVendido] + " unidades)");
    }

    // --- 8. GENERADOR DE CONTRASEÑAS ---
    public static void ejercicio8(Scanner sc) {
        System.out.println("\n=== EJERCICIO 8: GENERADOR DE CONTRASEÑAS ===");
        char[] mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] minus = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digitos = "0123456789".toCharArray();
        char[] simbolos = "!@#$%^&*()_+-=".toCharArray();

        int longitud;
        do {
            System.out.print("Ingrese longitud deseada (mínimo 4): ");
            longitud = sc.nextInt();
        } while (longitud < 4);

        Random rand = new Random();
        char[] password = new char[longitud];
        boolean valida;

        do {
            for (int i = 0; i < longitud; i++) {
                int tipo = rand.nextInt(4);
                switch (tipo) {
                    case 0 -> password[i] = mayus[rand.nextInt(mayus.length)];
                    case 1 -> password[i] = minus[rand.nextInt(minus.length)];
                    case 2 -> password[i] = digitos[rand.nextInt(digitos.length)];
                    case 3 -> password[i] = simbolos[rand.nextInt(simbolos.length)];
                }
            }

            // Validar que contenga al menos un carácter de cada tipo
            boolean tieneMayus = false, tieneMinus = false, tieneDigito = false, tieneSimbolo = false;
            for (char c : password) {
                if (new String(mayus).indexOf(c) >= 0) tieneMayus = true;
                if (new String(minus).indexOf(c) >= 0) tieneMinus = true;
                if (new String(digitos).indexOf(c) >= 0) tieneDigito = true;
                if (new String(simbolos).indexOf(c) >= 0) tieneSimbolo = true;
            }
            valida = tieneMayus && tieneMinus && tieneDigito && tieneSimbolo;
        } while (!valida);

        System.out.println("Contraseña Generada: " + new String(password));
    }

    // --- 9. CONVERSOR DE BASE NUMÉRICA ---
    public static void ejercicio9(Scanner sc) {
        System.out.println("\n=== EJERCICIO 9: CONVERSOR DE BASE NUMÉRICA ===");
        System.out.print("Ingrese un número entero en Base 10: ");
        int numero = sc.nextInt();

        System.out.println("Base 2  (Binario):     " + convertirBase(numero, 2));
        System.out.println("Base 8  (Octal):       " + convertirBase(numero, 8));
        System.out.println("Base 16 (Hexadecimal): " + convertirBase(numero, 16));
    }

    private static String convertirBase(int num, int base) {
        if (num == 0) return "0";
        char[] digitosHex = "0123456789ABCDEF".toCharArray();
        char[] resultadoAux = new char[32];
        int idx = 0;

        int temp = Math.abs(num);
        while (temp > 0) {
            resultadoAux[idx++] = digitosHex[temp % base];
            temp /= base;
        }

        // Invertir arreglo
        StringBuilder sb = new StringBuilder();
        if (num < 0) sb.append("-");
        for (int i = idx - 1; i >= 0; i--) {
            sb.append(resultadoAux[i]);
        }
        return sb.toString();
    }

    // --- 10. ANALIZADOR DE TEXTO ---
    public static void ejercicio10(Scanner sc) {
        System.out.println("\n=== EJERCICIO 10: ANALIZADOR DE TEXTO ===");
        sc.nextLine(); // Limpiar buffer
        System.out.print("Ingrese un párrafo: ");
        String texto = sc.nextLine();

        // Limpieza y separación en arreglo
        String limpio = texto.toLowerCase().replaceAll("[^a-záéíóúñ0-9 ]", "");
        String[] palabras = limpio.split("\\s+");

        if (palabras.length == 0 || palabras[0].isEmpty()) {
            System.out.println("No se ingresaron palabras válidas.");
            return;
        }

        String[] unicas = new String[palabras.length];
        int[] conteos = new int[palabras.length];
        int totalUnicas = 0;

        for (String p : palabras) {
            int pos = -1;
            for (int i = 0; i < totalUnicas; i++) {
                if (unicas[i].equals(p)) {
                    pos = i;
                    break;
                }
            }
            if (pos != -1) {
                conteos[pos]++;
            } else {
                unicas[totalUnicas] = p;
                conteos[totalUnicas] = 1;
                totalUnicas++;
            }
        }

        System.out.println("\n--- TOP 5 PALABRAS MÁS FRECUENTES ---");
        int limite = Math.min(5, totalUnicas);
        for (int i = 0; i < limite; i++) {
            int maxPos = 0;
            for (int j = 1; j < totalUnicas; j++) {
                if (conteos[j] > conteos[maxPos]) {
                    maxPos = j;
                }
            }
            System.out.println((i + 1) + ". " + unicas[maxPos] + " -> " + conteos[maxPos] + " repetición(es)");
            conteos[maxPos] = -1; // Desactivar para encontrar el siguiente mayor
        }
    }
}