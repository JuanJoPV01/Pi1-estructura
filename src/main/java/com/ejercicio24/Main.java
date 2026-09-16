package com.ejercicio24;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=================================");
            System.out.println("   MENÚ DE ACTIVIDADES (1 AL 10) ");
            System.out.println("=================================");
            System.out.println("1. Analizador de Calificaciones    6. Analizador Archivos Numéricos");
            System.out.println("2. Compresor Simple de Texto       7. Simulador de Ventas");
            System.out.println("3. Juego del Ahorcado              8. Generador de Contraseñas");
            System.out.println("4. Sistema de Inventario           9. Conversor de Base Numérica");
            System.out.println("5. Agenda Telefónica               10. Analizador de Texto");
            System.out.println("0. Salir");
            System.out.print("Selecciona el ejercicio a ejecutar (0-10): ");

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
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}