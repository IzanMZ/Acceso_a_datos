
package ejercicio3;

import java.util.Scanner;

public class GestorEstudaintes {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String Fichero = "estudiantes.txt";

        int opcion;

        do {

            System.out.println();
            System.out.println("===== GESTIÓN DE ESTUDIANTES =====");
            System.out.println("0. Salir del programa.");
            System.out.println("1. Insertar estudiante.");
            System.out.println("2. Consultar todos los estudiantes.");
            System.out.println("3. Consultar un estudiante por matrícula.");
            System.out.println("4. Actualizar estudiante por matrícula.");
            System.out.println("5. Eliminar estudiante por matrícula.");
            System.out.print("Introduce una opción: ");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                case 1:
                    IngresoEstudantes.insertarEstudiante(teclado, Fichero);
                    break;

                case 2:
                    IngresoEstudantes.consultarTodos(Fichero);
                    break;

                case 3:
                    IngresoEstudantes.consultarPorMatricula(
                            teclado, Fichero);
                    break;

                case 4:
                    IngresoEstudantes.actualizarEstudiante(
                            teclado, Fichero);
                    break;

                case 5:
                    IngresoEstudantes.eliminarEstudiante(
                            teclado, Fichero);
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}

