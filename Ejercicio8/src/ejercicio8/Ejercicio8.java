/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio8;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
/**
 *
 * @author isard
 */
public class Ejercicio8 {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {

        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();

        paquetes.add(new PaqueteTuristico(
                "París", 5, 850.50,
                new String[]{"Vuelo", "Hotel 4*", "Desayuno"}
        ));

        paquetes.add(new PaqueteTuristico(
                "Roma", 4, 620.00,
                new String[]{"Vuelo", "Hotel 3*", "Visitas guiadas"}
        ));

        paquetes.add(new PaqueteTuristico(
                "Maldivas", 7, 1500.75,
                new String[]{"Vuelo", "Hotel 5*", "Pensión Completa"}
        ));

        
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

 
        String json = gson.toJson(paquetes);

        try (FileWriter writer = new FileWriter("ofertas.json")) {
            writer.write(json);
            System.out.println("Archivo ofertas.json creado correctamente.");
        } catch (IOException e) {
            e.getMessage();
        }

   
        try (FileReader reader = new FileReader("ofertas.json")) {

            Type tipoLista = new TypeToken<ArrayList<PaqueteTuristico>>() {
            }.getType();

            ArrayList<PaqueteTuristico> recuperados =
                    gson.fromJson(reader, tipoLista);

   
            
            System.out.println("\nPaquetes turísticos importados:");

            for (PaqueteTuristico paquete : recuperados) {
                System.out.println(
                        "Destino: " + paquete.getDestino()
                        + " | Precio: " + paquete.getPrecio() + " €"
                );
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}

