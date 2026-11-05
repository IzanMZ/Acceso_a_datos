/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

/**
 *
 * @author isard
 */
public class PaqueteTuristico {

    private String destino;
    private int duracionDias;
    private double precio;
    private String[] incluye;

    public PaqueteTuristico(String destino, int duracionDias,
                            double precio, String[] incluye) {
        this.destino = destino;
        this.duracionDias = duracionDias;
        this.precio = precio;
        this.incluye = incluye;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String[] getIncluye() {
        return incluye;
    }

    public void setIncluye(String[] incluye) {
        this.incluye = incluye;
    }
}
