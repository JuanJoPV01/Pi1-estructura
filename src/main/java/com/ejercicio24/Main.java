package com.ejercicio24;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=============================================");
            System.out.println("   MENÚ DE ACTIVIDADES (1 AL 25) ");
            System.out.println("=============================================");
            System.out.println("1. Analizador Calificaciones     14. Secuencias Numéricas");
            System.out.println("2. Compresor de Texto           15. Búsqueda Rutas Matriz");
            System.out.println("3. Juego del Ahorcado           16. Conecta 4");
            System.out.println("4. Sistema de Inventario        17. Simulador Cajero Auto.");
            System.out.println("5. Agenda Telefónica            18. Mezclador Canciones");
            System.out.println("6. Analizador Archivos Num.     19. Datos Climáticos");
            System.out.println("7. Simulador de Ventas          20. Editor Imagen Escala Grises");
            System.out.println("8. Generador Contraseñas        21. Turnos Peluquería");
            System.out.println("9. Conversor de Base            22. Sistema de Parqueadero");
            System.out.println("10. Analizador de Texto         23. Semáforo Inteligente");
            System.out.println("11. Sudoku Validator            24. Registro Pedidos Cafetería");
            System.out.println("12. Simulador de Torneo         25. Sala de Cómputo");
            System.out.println("13. Historial Temperaturas       0. Salir");
            System.out.print("Selecciona el ejercicio a ejecutar (0-25): ");

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
                case 16 -> EjerciciosGrupo4.ejercicio16(sc);
                case 17 -> EjerciciosGrupo4.ejercicio17(sc);
                case 18 -> EjerciciosGrupo4.ejercicio18(sc);
                case 19 -> EjerciciosGrupo4.ejercicio19();
                case 20 -> EjerciciosGrupo4.ejercicio20();
                case 21 -> EjerciciosGrupo5.ejercicio21(sc);
                case 22 -> EjerciciosGrupo5.ejercicio22(sc);
                case 23 -> EjerciciosGrupo5.ejercicio23();
                case 24 -> EjerciciosGrupo5.ejercicio24(sc);
                case 25 -> EjerciciosGrupo5.ejercicio25(sc);
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}