package com.ejercicio24; // Asegúrate de mantener la primera línea con tu paquete tal como aparece en tu IDE

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== 1. PARTE 1: ARREGLOS (UNIDIMENSIONALES) ======");


        int[] arreglos = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arreglos.length; i++) {
            arreglos[i] = rand.nextInt(50) + 1;
        }


        System.out.println("\n--- Recorrido For Clásico ---");
        for (int i = 0; i < arreglos.length; i++) {
            System.out.println("Índice [" + i + "]: " + arreglos[i]);
        }


        System.out.println("\n--- Recorrido For-Each ---");
        for (int val : arreglos) {
            System.out.print(val + " ");
        }
        System.out.println("\n");


        int[] imparesACero = arreglos.clone();
        for (int i = 0; i < imparesACero.length; i++) {
            if (imparesACero[i] % 2 != 0) {
                imparesACero[i] = 0;
            }
        }
        System.out.println("Original:          " + Arrays.toString(arreglos));
        System.out.println("Impares por cero:  " + Arrays.toString(imparesACero));


        int[] multIndice = arreglos.clone();
        for (int i = 0; i < multIndice.length; i++) {
            multIndice[i] = multIndice[i] * i;
        }
        System.out.println("Multiplicado x pos: " + Arrays.toString(multIndice));


        int objetivo = arreglos[2];
        int posEncontrada = busquedaLineal(arreglos, objetivo);
        System.out.println("\nBúsqueda lineal del valor " + objetivo + ": Encontrado en índice " + posEncontrada);


        System.out.println("\n====== 2. PARTE 2: MATRICES (BIDIMENSIONALES) ======");


        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        System.out.println("\n--- Matriz en formato Tabla ---");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }


        System.out.print("\n--- Recorrido por Columnas ---\nValores: ");
        for (int col = 0; col < matriz[0].length; col++) {
            for (int fila = 0; fila < matriz.length; fila++) {
                System.out.print(matriz[fila][col] + " ");
            }
        }
        System.out.println("\n");


        int sumaTotal = 0;
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                sumaTotal += elemento;
            }
        }
        System.out.println("Suma total de la matriz: " + sumaTotal);


        int[] auxFila = matriz[0];
        matriz[0] = matriz[matriz.length - 1];
        matriz[matriz.length - 1] = auxFila;

        System.out.println("\n--- Matriz tras intercambiar Fila 1 y Fila 3 ---");
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
    }


    public static int busquedaLineal(int[] arr, int objetivo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}