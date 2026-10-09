/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author isard
 */
public class OperacionesNotas {

    public static void crearFichero() {
        File archivo = new File("notas.txt");
    }

    public static void escribirNotas(Scanner numer) {

        try ( BufferedWriter escritor = new BufferedWriter(new FileWriter("notas.txt", true))) {
            System.out.println("Introduzaca las notas");
            System.out.println("Coloque fin para terminar");
            String linea;
            do {
                linea = numer.nextLine();

                if (!linea.equalsIgnoreCase("fin")) {
                    escritor.write(linea);
                    escritor.newLine();
                }
            } while (!linea.equalsIgnoreCase("fin"));
            System.out.println("notas guardadas correctamente");
        } catch (Exception e) {
            System.out.println("Error al escribir en las notas " + e.getMessage());
        }

    }

    public static void leerNotas(Scanner numer) {

        File archivo = new File("notas.txt");

        if (!archivo.exists()) {
            System.out.print("El fichero no existe");
        }

        try {
            BufferedReader fich = new BufferedReader(new FileReader("notas.txt"));
            String linea;

            while ((linea = fich.readLine()) != null) {

                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero notas.txt no existe ");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }

    }

    public static void consultasEstadisticas() {
        int caracteres = 0;
        int lineas = 0;

        try ( BufferedReader lector = new BufferedReader(new FileReader("notas.txt"))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                caracteres += linea.length();
                lineas++;
            }

            System.out.println("Numero totald e caracteres " + caracteres);
            System.out.println("Numero de lineas " + lineas);

        } catch (FileNotFoundException ex) {
            System.out.println("El fichero nota.txt noe existe");
        } catch (Exception e) {
            System.out.println("Error al leer el fichero");
        }
    }

    public static void buscarPalabra(Scanner numer) {

        String palabraBuscar;

        do {
            System.out.println("Introduce una palabra para buscar:");
            palabraBuscar = numer.nextLine();

            if (palabraBuscar.contains(" ")) {
                System.out.println("Error: la palabra no puede tener espacios.");
            }

        } while (palabraBuscar.contains(" "));

        try ( BufferedReader lector = new BufferedReader(new FileReader("notas.txt"))) {

            String linea;
            int numeroLinea = 0;
            boolean encontrada = false;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;

                if (linea.contains(palabraBuscar)) {
                    System.out.println("La palabra está en la línea " + numeroLinea);
                    encontrada = true;
                }
            }

            if (!encontrada) {
                System.out.println("La palabra no está en el fichero.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero notas.txt no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }

    public static void palabraMayuscula() {

        try ( BufferedReader lector = new BufferedReader(new FileReader("notas.txt"));  BufferedWriter escritor = new BufferedWriter(new FileWriter("notasMayuscula.txt"))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                escritor.write(linea.toUpperCase());
                escritor.newLine();
            }
            System.out.println("Copia mayuscula creado con exito");

        } catch (FileNotFoundException ex) {
            System.out.println("El fichero nota.txt noe existe");
        } catch (Exception e) {
            System.out.println("Error al crear la copia");
        }

    }

    public static void palabraMinuscula() {

        try ( BufferedReader lector = new BufferedReader(new FileReader("notas.txt"));  BufferedWriter escritor = new BufferedWriter(new FileWriter("notasMinuscula.txt"))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                escritor.write(linea.toLowerCase());
                escritor.newLine();
            }
            System.out.println("Copia minuscula creado con exito");

        } catch (FileNotFoundException ex) {
            System.out.println("El fichero nota.txt noe existe");
        } catch (Exception e) {
            System.out.println("Error al crear la copia");
        }

    }

}
