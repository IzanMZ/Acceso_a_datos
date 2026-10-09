
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author isard
 */
public class IngresoEstudantes {

    public static void insertarEstudiante(Scanner teclado, String Fichero) {

        System.out.print("Introduce la matrícula: ");
        int matricula = Integer.parseInt(teclado.nextLine());

        // Comprobar que la matrícula no existe
        if (buscarEstudiante(matricula, Fichero) != null) {
            System.out.println("Ya existe otro estudiante con esa matrícula.");
            return;
        }

        System.out.print("Introduce el nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce la fecha de inscripción: ");
        String fecha = teclado.nextLine();

        System.out.print("Introduce el curso: ");
        String curso = teclado.nextLine();

        System.out.print("Introduce la nota media: ");
        double notaMedia = Double.parseDouble(
                teclado.nextLine().replace(",", ".")
        );

        Estudiante estudiante = new Estudiante(
                matricula,
                nombre,
                fecha,
                curso,
                notaMedia
        );

        // Añadir al final del fichero
        try (BufferedWriter escritor =
                     new BufferedWriter(new FileWriter(Fichero, true))) {

            escritor.write(estudiante.toStringWithSeparators());
            escritor.newLine();

            System.out.println(
                    "Se ha insertado un estudiante en el fichero de texto."
            );

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero.");
        }
    }


    public static void consultarTodos(String Fichero) {

        int contador = 0;

        try (BufferedReader lector =
                     new BufferedReader(new FileReader(Fichero))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (!linea.trim().isEmpty()) {
                    Estudiante estudiante = new Estudiante(linea);
                    System.out.println(estudiante);
                    contador++;
                }
            }

            if (contador == 0) {
                System.out.println("El fichero de texto está vacío.");
            } else {
                System.out.println("Total de alumnos consultados: " + contador);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }


    public static void consultarPorMatricula(
            Scanner teclado, String Fichero) {

        System.out.print("Introduce la matrícula: ");
        int matricula = Integer.parseInt(teclado.nextLine());

        Estudiante estudiante = buscarEstudiante(matricula, Fichero);

        if (estudiante == null) {
            System.out.println(
                    "No existe ningún estudiante con esa matrícula " +
                    "en el fichero de texto."
            );
        } else {
            System.out.println(estudiante);
        }
    }


    public static void actualizarEstudiante(
            Scanner teclado, String Fichero) {

        System.out.print("Introduce la matrícula: ");
        int matricula = Integer.parseInt(teclado.nextLine());

        ArrayList<Estudiante> estudiantes = leerEstudiantes(Fichero);

        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getMatricula() == matricula) {

                System.out.print("Introduce el nuevo curso: ");
                String nuevoCurso = teclado.nextLine();

                System.out.print("Introduce la nueva nota media: ");
                double nuevaNota = Double.parseDouble(
                        teclado.nextLine().replace(",", ".")
                );

                estudiante.setCurso(nuevoCurso);
                estudiante.setNotaMedia(nuevaNota);

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(
                    "No existe ningún estudiante con esa matrícula " +
                    "en el fichero de texto."
            );
            return;
        }

        // Reescribir el fichero con los datos actualizados
        escribirEstudiantes(estudiantes, Fichero);

        System.out.println("Estudiante actualizado correctamente.");
    }


    public static void eliminarEstudiante(
            Scanner teclado, String Fichero) {

        System.out.print("Introduce la matrícula: ");
        int matricula = Integer.parseInt(teclado.nextLine());

        ArrayList<Estudiante> estudiantes = leerEstudiantes(Fichero);

        boolean encontrado = false;

        for (int i = 0; i < estudiantes.size(); i++) {

            if (estudiantes.get(i).getMatricula() == matricula) {
                estudiantes.remove(i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(
                    "No existe ningún estudiante con esa matrícula " +
                    "en el fichero de texto."
            );
            return;
        }

        // Reescribir el fichero sin el estudiante eliminado
        escribirEstudiantes(estudiantes, Fichero);

        System.out.println("Estudiante eliminado correctamente.");
    }


    public static Estudiante buscarEstudiante(
            int matricula, String Fichero) {

        try (BufferedReader lector =
                     new BufferedReader(new FileReader(Fichero))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (!linea.trim().isEmpty()) {

                    Estudiante estudiante = new Estudiante(linea);

                    if (estudiante.getMatricula() == matricula) {
                        return estudiante;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }

        return null;
    }


    public static ArrayList<Estudiante> leerEstudiantes(
            String Fichero) {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        try (BufferedReader lector =
                     new BufferedReader(new FileReader(Fichero))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (!linea.trim().isEmpty()) {
                    estudiantes.add(new Estudiante(linea));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }

        return estudiantes;
    }


    public static void escribirEstudiantes(
            ArrayList<Estudiante> estudiantes, String Fichero) {

        try (BufferedWriter escritor =
                     new BufferedWriter(new FileWriter(Fichero))) {

            for (Estudiante estudiante : estudiantes) {
                escritor.write(estudiante.toStringWithSeparators());
                escritor.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }
    }
}

