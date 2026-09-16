package com.ejercicio24;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EjerciciosGrupo3 {

    // --- 11. SUDOKU VALIDATOR ---
    public static void ejercicio11() {
        System.out.println("\n=== EJERCICIO 11: SUDOKU VALIDATOR ===");
        int[][] tablero = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        boolean valido = true;

        // Validar filas y columnas
        for (int i = 0; i < 9; i++) {
            boolean[] vistoFila = new boolean[10];
            boolean[] vistoCol = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int f = tablero[i][j];
                int c = tablero[j][i];
                if (vistoFila[f] || vistoCol[c]) valido = false;
                vistoFila[f] = true;
                vistoCol[c] = true;
            }
        }

        // Validar subcuadrículas 3x3
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                boolean[] vistoBloque = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int num = tablero[r + i][c + j];
                        if (vistoBloque[num]) valido = false;
                        vistoBloque[num] = true;
                    }
                }
            }
        }

        System.out.println("Tablero analizado:");
        for (int[] fila : tablero) {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println("\nResultado de Validación: " + (valido ? "VALIDACIÓN EXITOSA (Sudoku correcto)" : "ERRORES DETECTADOS"));
    }

    // --- 12. SIMULADOR DE TORNEO ---
    public static void ejercicio12(Scanner sc) {
        System.out.println("\n=== EJERCICIO 12: SIMULADOR DE TORNEO ===");
        String[] equipos = {"Real Madrid", "Barcelona", "Bayern", "PSG"};
        int[] puntos = new int[equipos.length];
        Random rand = new Random();

        System.out.println("--- ENFRENTAMIENTOS ---");
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                int g1 = rand.nextInt(4);
                int g2 = rand.nextInt(4);
                System.out.printf("%-12s %d - %d %s\n", equipos[i], g1, g2, equipos[j]);

                if (g1 > g2) puntos[i] += 3;
                else if (g2 > g1) puntos[j] += 3;
                else {
                    puntos[i] += 1;
                    puntos[j] += 1;
                }
            }
        }

        // Ordenar posiciones (Burbuja simple en paralelo)
        for (int i = 0; i < puntos.length - 1; i++) {
            for (int j = 0; j < puntos.length - i - 1; j++) {
                if (puntos[j] < puntos[j + 1]) {
                    int tempP = puntos[j];
                    puntos[j] = puntos[j + 1];
                    puntos[j + 1] = tempP;

                    String tempE = equipos[j];
                    equipos[j] = equipos[j + 1];
                    equipos[j + 1] = tempE;
                }
            }
        }

        System.out.println("\n--- TABLA FINAL DE POSICIONES ---");
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%d. %-12s | %d Pts\n", (i + 1), equipos[i], puntos[i]);
        }
    }

    // --- 13. HISTORIAL DE TEMPERATURAS ---
    public static void ejercicio13(Scanner sc) {
        System.out.println("\n=== EJERCICIO 13: HISTORIAL DE TEMPERATURAS ===");
        double[] temps = new double[15]; // Simulación de 15 días
        Random rand = new Random();
        double suma = 0;

        for (int i = 0; i < temps.length; i++) {
            temps[i] = 18 + rand.nextInt(17); // Entre 18°C y 34°C
            suma += temps[i];
        }

        int diaFrio = 0, diaCalido = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < temps[diaFrio]) diaFrio = i;
            if (temps[i] > temps[diaCalido]) diaCalido = i;
        }

        System.out.printf("Promedio Mensual: %.2f°C\n", (suma / temps.length));
        System.out.printf("Día más frío:  Día %d con %.1f°C\n", (diaFrio + 1), temps[diaFrio]);
        System.out.printf("Día más cálido: Día %d con %.1f°C\n", (diaCalido + 1), temps[diaCalido]);

        System.out.println("\n--- GRÁFICO DE BARRAS DE TEMPERATURA ---");
        for (int i = 0; i < temps.length; i++) {
            System.out.printf("Día %2d [%.1f°C]: ", (i + 1), temps[i]);
            int barras = (int) temps[i];
            for (int b = 0; b < barras; b++) System.out.print("█");
            System.out.println();
        }
    }

    // --- 14. ANALIZADOR DE SECUENCIAS NUMÉRICAS ---
    public static void ejercicio14(Scanner sc) {
        System.out.println("\n=== EJERCICIO 14: ANALIZADOR DE SECUENCIAS ===");
        System.out.print("Ingrese cantidad de elementos en el arreglo (min 3): ");
        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento [" + i + "]: ");
            num[i] = sc.nextInt();
        }

        // Detectar Ordenamiento
        boolean asc = true, desc = true;
        for (int i = 0; i < n - 1; i++) {
            if (num[i] > num[i + 1]) asc = false;
            if (num[i] < num[i + 1]) desc = false;
        }

        System.out.println("\n--- ANÁLISIS DE ORDEN ---");
        if (asc) System.out.println("Estado: Ordenado Ascendente");
        else if (desc) System.out.println("Estado: Ordenado Descendente");
        else System.out.println("Estado: Desordenado");

        // Progresión Aritmética
        boolean aritmetica = true;
        int diff = num[1] - num[0];
        for (int i = 1; i < n - 1; i++) {
            if (num[i + 1] - num[i] != diff) {
                aritmetica = false;
                break;
            }
        }

        // Progresión Geométrica
        boolean geometrica = (num[0] != 0);
        double razon = geometrica ? (double) num[1] / num[0] : 0;
        if (geometrica) {
            for (int i = 1; i < n - 1; i++) {
                if (num[i] == 0 || (double) num[i + 1] / num[i] != razon) {
                    geometrica = false;
                    break;
                }
            }
        }

        System.out.println("\n--- ANÁLISIS DE PROGRESIÓN ---");
        if (aritmetica) System.out.println("Forma una Progresión ARITMÉTICA con diferencia = " + diff);
        else if (geometrica) System.out.println("Forma una Progresión GEOMÉTRICA con razón = " + razon);
        else System.out.println("No forma una progresión aritmética ni geométrica.");
    }

    // --- 15. BÚSQUEDA DE RUTAS EN UNA MATRIZ (DFS) ---
    public static void ejercicio15(Scanner sc) {
        System.out.println("\n=== EJERCICIO 15: BÚSQUEDA DE RUTAS EN MATRIZ ===");
        // 0 = Libre, 1 = Obstáculo
        int[][] mapa = {
                {0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        boolean[][] visitado = new boolean[5][5];
        System.out.println("Buscando camino desde (0,0) hasta (4,4)...");

        if (buscarCamino(mapa, 0, 0, visitado)) {
            System.out.println("\n--- RUTA ENCONTRADA (Marcada con 'X') ---");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (visitado[i][j]) System.out.print("X ");
                    else System.out.print(mapa[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No existe un camino válido hacia la salida.");
        }
    }

    private static boolean buscarCamino(int[][] mapa, int f, int c, boolean[][] vis) {
        if (f < 0 || f >= 5 || c < 0 || c >= 5 || mapa[f][c] == 1 || vis[f][c]) return false;
        vis[f][c] = true;
        if (f == 4 && c == 4) return true;

        // Intentar Abajo, Derecha, Arriba, Izquierda
        if (buscarCamino(mapa, f + 1, c, vis)) return true;
        if (buscarCamino(mapa, f, c + 1, vis)) return true;
        if (buscarCamino(mapa, f - 1, c, vis)) return true;
        if (buscarCamino(mapa, f, c - 1, vis)) return true;

        vis[f][c] = false; // Backtracking
        return false;
    }
}