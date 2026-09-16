package com.ejercicio24;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=============================================");
            System.out.println("   MENÚ DE ACTIVIDADES (1 AL 15) ");
            System.out.println("=============================================");
            System.out.println("1. Analizador Calificaciones     9. Conversor de Base");
            System.out.println("2. Compresor de Texto           10. Analizador de Texto");
            System.out.println("3. Juego del Ahorcado           11. Sudoku Validator");
            System.out.println("4. Sistema de Inventario        12. Simulador de Torneo");
            System.out.println("5. Agenda Telefónica            13. Historial Temperaturas");
            System.out.println("6. Analizador Archivos Num.     14. Secuencias Numéricas");
            System.out.println("7. Simulador de Ventas          15. Búsqueda Rutas Matriz");
            System.out.println("8. Generador Contraseñas         0. Salir");
            System.out.print("Selecciona el ejercicio a ejecutar (0-15): ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> EjerciciosGrupo1.ejercicio1(sc);
                case 2 -> EjerciciosGrupo1.ejercicio2(sc);
                case 3 -> EjerciciosGrupo1.ejercicio3(sc);
                case 4 -> EjerciciosGrupo1.ejercicio4();
                case 5 -> EjerciciosGrupo1.ejercicio5(sc);
                case 6 -> EjerciciosGrupo2.ejercicio6(sc);
                case 7 -> EjerciciosGrupo2.ejercicio7(sc);
                case 8 -> EjerciciosGrupo2.ejercicio8(sc);
                case 9 -> EjerciciosGrupo2.ejercicio9(sc);
                case 10 -> EjerciciosGrupo2.ejercicio10(sc);
                case 11 -> EjerciciosGrupo3.ejercicio11();
                case 12 -> EjerciciosGrupo3.ejercicio12(sc);
                case 13 -> EjerciciosGrupo3.ejercicio13(sc);
                case 14 -> EjerciciosGrupo3.ejercicio14(sc);
                case 15 -> EjerciciosGrupo3.ejercicio15(sc);
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}