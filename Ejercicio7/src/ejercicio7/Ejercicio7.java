/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7;

import java.io.File;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author isard
 */
public class Ejercicio7 {

    public class Main {

        public static void main(String[] args) {

            Scanner numer = new Scanner(System.in);
            int opcion = 0;

            do {
                System.out.println("menu");
                System.out.println("1. Generar XML");
                System.out.println("2. Leer XML");
                System.out.println("3. Salir");


                try {
                    opcion = Integer.parseInt(numer.nextLine());

                    switch (opcion) {

                        case 1:
                            generarXML(numer);
                            break;

                        case 2:
                            leerXML();
                            break;

                        case 3:
                            System.out.println("Saliendo del programa...");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número válido.");
                }

            } while (opcion != 3);

            numer.close();
        }

        public static void generarXML(Scanner sc) {

            try {
                System.out.print("Introduce el ISBN: ");
                String isbn = sc.nextLine();

                System.out.print("Introduce el título: ");
                String titulo = sc.nextLine();

                System.out.print("Introduce el autor: ");
                String autor = sc.nextLine();

                Libro libro = new Libro(isbn, titulo, autor);

                JAXBContext contexto = JAXBContext.newInstance(Libro.class);
                Marshaller marshaller = contexto.createMarshaller();

                marshaller.setProperty(
                        Marshaller.JAXB_FORMATTED_OUTPUT, true);

                marshaller.marshal(libro, new File("mi_libro.xml"));

                System.out.println("¡Archivo XML generado con éxito!");

            } catch (Exception e) {
                System.out.println("Error al generar XML: " + e.getMessage());
            }
        }

        public static void leerXML() {

            try {
                File archivo = new File("mi_libro.xml");

                if (!archivo.exists()) {
                    System.out.println("El archivo XML no existe.");
                    return;
                }

                JAXBContext contexto = JAXBContext.newInstance(Libro.class);
                Unmarshaller unmarshaller = contexto.createUnmarshaller();

                Libro libro = (Libro) unmarshaller.unmarshal(archivo);

                System.out.println("datos del libro cargado");
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());

            } catch (Exception e) {
                System.out.println("Error al leer XML: " + e.getMessage());
            }
        }
    }
}
