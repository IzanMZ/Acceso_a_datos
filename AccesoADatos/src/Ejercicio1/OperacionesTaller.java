/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author isard
 */
public class OperacionesTaller implements Comprobacion {

    public static void crearFichero(Scanner numer) {

        String nombre;

        System.out.println("Dime el nombre del fichero");
        nombre = numer.next();

        File archivo = new File(nombre);

        try {
            if (archivo.createNewFile()) {
                System.out.println("El fichero " + nombre + " se creo correctamente");
            } else {
                System.out.println("El fichero " + nombre + " ya existe");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void leerFichero(Scanner numer) {
        System.out.println("Dime el nombre del fichero a buscar");
        String nombreArchivo = numer.next();
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            System.out.print("El fichero no existe");
        }

        try {
            BufferedReader fich = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            boolean vacio = true;

            while ((linea = fich.readLine()) != null) {
                vacio = false;
                System.out.println(linea);
            }

            fich.close();
            if (vacio) {
                System.out.println("El fichero esta vacio, no hay datos");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }

    }

    public static void escribirFichero(Scanner numer) {

        System.out.println("Dime el nombre del fichero");
        String nombreArchivo = numer.next();

        File archivo = new File(nombreArchivo);

        System.out.println("Dime el nombre de la pieza");
        String nombrePieza = numer.next();

        System.out.println("Dime el nombre de la categoria");
        String categoria = numer.next();

        System.out.println("Dime el codigo Identificador");
        String codigoIdentificador = numer.next();

        System.out.println("Dime el precio de la pieza");
        double precio = Double.parseDouble(numer.next());

        Piezas piezas = new Piezas(
                nombrePieza,
                categoria,
                codigoIdentificador,
                precio
        );

        try {
            FileWriter fl = new FileWriter(archivo, true);

            fl.write(piezas.getCategoria() + ":"
                    + piezas.getCodigoIdentificador() + ":"
                    + piezas.getNombrePieza() + ":"
                    + String.format("%.2f", piezas.getPrecio()));

            fl.write("\n");
            fl.close();

            System.out.println("Datos guardados correctamente");

        } catch (Exception e) {
            System.out.println("Error al escribir en el fichero: "
                    + e.getMessage());
        }
    }

    @Override
    public void piezasGamaAlta(Scanner numer) {

        System.out.println("Dime el nombre del fichero");
        String nombreArchivo = numer.next();

        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            System.out.println("El fichero no existe");
            return;
        }

        try {
            BufferedReader fich = new BufferedReader(new FileReader(archivo));

            String linea;
            boolean hayPiezas = false;

            while ((linea = fich.readLine()) != null) {

                String[] datos = linea.split(":");

                if (datos.length == 4) {

                    double precio = Double.parseDouble(datos[3].replace(",", "."));


                    if (precio >= 50) {
                        System.out.println(linea);
                        hayPiezas = true;
                    }
                }
            }

            fich.close();

            if (!hayPiezas) {
                System.out.println("No hay piezas que superen dicho precio");
            }

        } catch (Exception e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

}
