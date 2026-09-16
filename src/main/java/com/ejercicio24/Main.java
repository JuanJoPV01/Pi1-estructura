package com.ejercicio24;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=================================");
            System.out.println("   MENÚ DE ACTIVIDADES (1 AL 5)  ");
            System.out.println("=================================");
            System.out.println("1. Analizador de Calificaciones");
            System.out.println("2. Compresor Simple de Texto");
            System.out.println("3. Juego del Ahorcado");
            System.out.println("4. Sistema de Inventario");
            System.out.println("5. Agenda Telefónica");
            System.out.println("0. Salir");
            System.out.print("Selecciona el ejercicio a ejecutar (0-5): ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    EjerciciosGrupo1.ejercicio1(sc);
                    break;
                case 2:
                    EjerciciosGrupo1.ejercicio2(sc);
                    break;
                case 3:
                    EjerciciosGrupo1.ejercicio3(sc);
                    break;
                case 4:
                    EjerciciosGrupo1.ejercicio4();
                    break;
                case 5:
                    EjerciciosGrupo1.ejercicio5(sc);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}