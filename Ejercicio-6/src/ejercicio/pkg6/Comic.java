/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg6;

import java.io.Serializable;

/**
 *
 * @author isard
 */
public class Comic implements Serializable {

    private String titulo;
    private String editorial;
    private double precio;
    private transient String claveValoracion;

    public Comic(String titulo, String editorial, double precio, String claveValoracion) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.precio = precio;
        this.claveValoracion = claveValoracion;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + 
                " | Editorial: " + editorial + 
                " | Precio: " + precio + " €";
    }
}
