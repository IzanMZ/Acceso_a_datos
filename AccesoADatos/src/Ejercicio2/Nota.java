/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author isard
 */
public class Nota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      
        Scanner numer = new Scanner(System.in);
        OperacionesNotas creacion = new OperacionesNotas();

        creacion.crearFichero();

        int opcion;

        do {
            System.out.println("1. salir del programa");
            System.out.println("2. Escribir notas");
            System.out.println("3. Leer notas");
            System.out.println("4. Consultar estadisticas");
            System.out.println("5. Buscar palabra clave");
            System.out.println("6. Copia en mayuscula");
            System.out.println("7. Copia en minuscula");

            opcion = numer.nextInt();

     
            numer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Adios");
                    break;

                case 2 :
                    creacion.escribirNotas(numer);
                    break;
                    
                case 3: 
                    creacion.leerNotas(numer);
                    break;
                case 4: 
                     creacion.consultasEstadisticas();
                    break;
                    
               case 5:
                    creacion.buscarPalabra(numer);
                    break;
                case 6: 
                     creacion.palabraMayuscula();
                    break;
                    
                case 7:
                     creacion.palabraMinuscula();
                    break;
                    
                    
                default:
                    throw new AssertionError();
            }
            
            
            
            
            
        } while (opcion != 1);

        
        
    }
    
}
