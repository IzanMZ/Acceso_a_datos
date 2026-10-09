/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio1;

import java.util.Scanner;

/**
 *
 * @author isard
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner numer = new Scanner(System.in);
        OperacionesTaller creacion = new OperacionesTaller();
        int opcion;

        do {
            System.out.println("1. crear fichero ");
            System.out.println("2. leer fichero ");
            System.out.println("3. escribir fichero ");
            System.out.println("4. mostrar piezas de gama alta ");
            System.out.println("5. Salir ");
            opcion = numer.nextInt();

            switch (opcion) {
                case 1:
                    creacion.crearFichero(numer);
                    break;

                case 2 :
                    creacion.leerFichero(numer);
                    break;
                    
                case 3: 
                    creacion.escribirFichero(numer);
                    break;
                case 4: 
                    creacion.piezasGamaAlta(numer);
                    break;
                    
                case 5 : 
                    System.out.println("Adios");
                    
                default:
                    throw new AssertionError();
            }
            
            
            
            
            
        } while (opcion != 5);

    }

}
