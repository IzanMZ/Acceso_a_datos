/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author isard
 */
public class GuardarComic {

    public static void guardar(ArrayList<Comic> comics) {
        try ( ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("coleccion.dat"))) {
            salida.writeInt(comics.size());
            for (Comic comic : comics) {
                salida.writeObject(comic);
            }
            System.out.println("Comics guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}
