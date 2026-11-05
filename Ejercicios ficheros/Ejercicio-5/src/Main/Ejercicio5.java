/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import modelos.*;
import Servicios.GestionSocios;
import Servicios.CsvHandler;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author isard
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
  
        
    private static Scanner numer = new Scanner(System.in);
    private static GestionSocios gestion = new GestionSocios();

    public static void main(String[] args) {

        int opcion;

        do {
  
            System.out.println("1. Agregar socio");
            System.out.println("2. Listar socios");
            System.out.println("3. Calcular recaudación total");
            System.out.println("4. Guardar datos a CSV");
            System.out.println("5. Cargar datos desde CSV");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(numer.nextLine());

                switch (opcion) {
                    case 1:
                        agregarSocio();
                        break;

                    case 2:
                        gestion.listarSocios();
                        break;

                    case 3:
                        System.out.printf(
                                "Recaudación mensual: %.2f €%n",
                                gestion.calcularRecaudacionTotal()
                        );
                        break;

                    case 4:
                        CsvHandler.guardarSocios(gestion.getSocios());
                        break;

                    case 5:
                        Socio[] cargados = CsvHandler.cargarSocios();
                        gestion.reemplazarSocios(cargados);
                        break;

                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                opcion = 0;
                System.out.println("Debes introducir un número.");
            } catch (IllegalArgumentException e) {
                opcion = 0;
                System.out.println("Datos incorrectos: " + e.getMessage());
            }

        } while (opcion != 6);

        numer.close();
    }

    private static void agregarSocio() {

        System.out.println("\n Nuevo socio ");

        System.out.print("ID: ");
        String id = numer.nextLine().trim();

        System.out.print("Nombre: ");
        String nombre = numer.nextLine().trim();

        System.out.println("Planes disponibles:");
        for (Plan p : Plan.values()) {
            System.out.println("- " + p);
        }

        System.out.print("Plan: ");
        Plan plan = Plan.valueOf(numer.nextLine().trim().toUpperCase());

        System.out.print("Cuota base: ");
        double cuotaBase = Double.parseDouble(numer.nextLine());

        System.out.println("Tipo de socio:");
        System.out.println("1. Base");
        System.out.println("2. Temporal");
        System.out.println("3. VIP");
        System.out.print("Selecciona: ");

        int tipo = Integer.parseInt(numer.nextLine());

        Socio socio;

        switch (tipo) {
            case 1:
                System.out.print("Meses de antigüedad: ");
                int mesesBase = Integer.parseInt(numer.nextLine());

                socio = new SocioBase(
                        id, nombre, plan, cuotaBase, mesesBase
                );
                break;

            case 2:
                System.out.print(
                        "Fecha de fin (AAAA-MM-DD): "
                );
                LocalDate fecha = LocalDate.parse(numer.nextLine());

                socio = new SocioTemporal(
                        id, nombre, plan, cuotaBase, fecha
                );
                break;

            case 3:
                System.out.print("Meses de antigüedad: ");
                int mesesVIP = Integer.parseInt(numer.nextLine());

                System.out.print("¿Tiene acceso a taquilla? (s/n): ");
                boolean taquilla = numer.nextLine().trim()
                        .equalsIgnoreCase("s");

                socio = new SocioVip(
                        id, nombre, plan, cuotaBase,
                        mesesVIP, taquilla
                );
                break;

            default:
                System.out.println("Tipo de socio no válido.");
                return;
        }

        gestion.agregarSocio(socio);

        System.out.printf(
                "Cuota mensual calculada: %.2f €%n",
                socio.calcularCuota()
        );
    }
}



