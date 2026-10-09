/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author isard
 */
public class Piezas {
     private String nombrePieza;
    private String categoria;
    private String codigoIdentificador;
    private double precio;

    public Piezas(String nombrePieza, String Categoria, String CodigoIdentificador, double Precio) {
        this.nombrePieza = nombrePieza;
        this.categoria = Categoria;
        this.codigoIdentificador = CodigoIdentificador;
        this.precio = Precio;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String CodigoIdentificador) {
        this.codigoIdentificador = CodigoIdentificador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double Precio) {
        this.precio = Precio;
    }
    
    
}
