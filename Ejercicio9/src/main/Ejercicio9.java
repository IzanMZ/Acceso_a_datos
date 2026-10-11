/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Sax.LectorInventarioSAX;
import java.util.Scanner;
import modelo.Producto;
import dom.GestorInventarioDOM;

/**
 *
 * @author isard
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("Gestion de los productos");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar todos los productos (DOM)");
            System.out.println("3. Buscar productos por categoría (SAX)");
            System.out.println("4. Mostrar productos con poco stock (SAX)");
            System.out.println("5. Actualizar stock (DOM)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine().trim());

                if (opcion < 0 || opcion > 5) {
                    System.out.println(
                            "La opción de menú debe estar comprendida entre 0 y 5.");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        anadirProducto();
                        break;

                    case 2:
                        GestorInventarioDOM.mostrarProductos();
                        break;

                    case 3:
                        System.out.print("Introduzca la categoría: ");
                        String categoria = teclado.nextLine();
                        LectorInventarioSAX.buscarPorCategoria(categoria);
                        break;

                    case 4:
                        System.out.print("Introduzca el stock máximo: ");
                        int limite = Integer.parseInt(
                                teclado.nextLine().trim());

                        if (limite < 0) {
                            System.out.println(
                                    "El stock máximo no puede ser negativo.");
                        } else {
                            LectorInventarioSAX.buscarPorStock(limite);
                        }
                        break;

                    case 5:
                        actualizarStock();
                        break;

                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Error: debe introducir un número válido.");
                opcion = -1;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                opcion = -1;
            }

        } while (opcion != 0);

        teclado.close();
    }

    private static void anadirProducto() {
        try {
            System.out.println("Nuevo precio");

            System.out.print("Código: ");
            String codigo = teclado.nextLine().trim();

            System.out.print("Nombre: ");
            String nombre = teclado.nextLine().trim();

            System.out.print("Categoría: ");
            String categoria = teclado.nextLine().trim();

            System.out.print("Marca: ");
            String marca = teclado.nextLine().trim();

            System.out.print("Precio (€): ");
            double precio = Double.parseDouble(
                    teclado.nextLine().trim().replace(',', '.'));

            System.out.print("Stock: ");
            int stock = Integer.parseInt(
                    teclado.nextLine().trim());

            if (codigo.isEmpty() || nombre.isEmpty()
                    || categoria.isEmpty() || marca.isEmpty()
                    || precio < 0 || stock < 0
                    || !Double.isFinite(precio)) {
                System.out.println(
                        "Error: los datos no son válidos.");
                return;
            }

            Producto producto = new Producto(
                    codigo, nombre, categoria, marca, precio, stock);

            GestorInventarioDOM.anadirProducto(producto);

        } catch (NumberFormatException e) {
            System.out.println(
                    "Error: el precio o el stock no tienen un formato válido.");
        }
    }

    private static void actualizarStock() {
        try {
            System.out.print("Introduzca el código del producto: ");
            String codigo = teclado.nextLine().trim();

            System.out.print("Introduzca el nuevo stock: ");
            int stock = Integer.parseInt(
                    teclado.nextLine().trim());

            if (codigo.isEmpty() || stock < 0) {
                System.out.println(
                        "Error: el código y el stock deben ser válidos.");
                return;
            }

            GestorInventarioDOM.actualizarStock(codigo, stock);

        } catch (NumberFormatException e) {
            System.out.println(
                    "Error: el stock debe ser un número entero.");
        }
    }
}
