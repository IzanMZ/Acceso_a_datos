/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import Intefaces.Descontable;

/**
 *
 * @author isard
 */
    public class SocioBase extends Socio implements Descontable {

        protected int mesesAntiguedad;

        public SocioBase(String id, String nombre, Plan plan,
                double cuotaBase, int mesesAntiguedad) {
            super(id, nombre, plan, cuotaBase);

            if (mesesAntiguedad < 0) {
                throw new IllegalArgumentException(
                        "La antigüedad no puede ser negativa."
                );
            }

            this.mesesAntiguedad = mesesAntiguedad;
        }

        @Override
        public double calcularDescuento() {
            return cuotaBase * 0.05;
        }

        @Override
        public double calcularCuota() {
            return Math.max(
                    0,
                    cuotaBase - (2 * mesesAntiguedad) - calcularDescuento()
            );
        }

        public int getMesesAntiguedad() {
            return mesesAntiguedad;
        }

        @Override
        public String getTipo() {
            return "BASE";
        }
    }

