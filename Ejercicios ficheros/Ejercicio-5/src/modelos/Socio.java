/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author isard
 */
public abstract class Socio {

    protected String id;
    protected String nombre;
    protected Plan plan;
    protected double cuotaBase;

    public Socio(String id, String nombre, Plan plan, double cuotaBase) {
        if (cuotaBase <= 0) {
            throw new IllegalArgumentException(
                    "La cuota base debe ser mayor que cero."
            );
        }

        if (id == null || id.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()
                || plan == null) {
            throw new IllegalArgumentException(
                    "Los datos del socio son obligatorios."
            );
        }

        this.id = id;
        this.nombre = nombre;
        this.plan = plan;
        this.cuotaBase = cuotaBase;
    }

    public abstract double calcularCuota();

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Plan getPlan() {
        return plan;
    }

    public double getCuotaBase() {
        return cuotaBase;
    }

    public String getTipo() {
        return "BASE";
    }

    @Override
    public String toString() {
        return getTipo() + " | " + id + " | " + nombre + " | " + plan
                + " | Base: " + cuotaBase + " €"
                + " | Cuota: " + calcularCuota() + " €";
    }

}
