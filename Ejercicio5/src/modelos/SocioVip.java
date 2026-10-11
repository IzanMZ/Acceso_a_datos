/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author isard
 */
    
public class SocioVip extends SocioBase {

    private boolean accesoTaquilla;

    public SocioVip(String id, String nombre, Plan plan,
                    double cuotaBase, int mesesAntiguedad,
                    boolean accesoTaquilla) {
        super(id, nombre, plan, cuotaBase, mesesAntiguedad);
        this.accesoTaquilla = accesoTaquilla;
    }

    @Override
    public double calcularDescuento() {
        return cuotaBase * 0.10;
    }

    @Override
    public double calcularCuota() {
        return cuotaBase + 15 - calcularDescuento();
    }

    public boolean isAccesoTaquilla() {
        return accesoTaquilla;
    }

    @Override
    public String getTipo() {
        return "VIP";
    }

    @Override
    public String toString() {
        return super.toString()
            + " | Acceso a taquilla: "
            + (accesoTaquilla ? "Sí" : "No");
    }
}

