/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.pkg6;

import java.util.ArrayList;

/**
 *
 * @author isard
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Comic> comics = new ArrayList<>();
        comics.add(new Comic("Batman", "DC Comics", 15.50, "CLAVE01"));
        comics.add(new Comic("Spider-Man", "Marvel", 12.75, "CLAVE02"));
        comics.add(new Comic("Superman", "DC Comics", 18.00, "CLAVE03"));
        GuardarComic.guardar(comics);
    }
}


