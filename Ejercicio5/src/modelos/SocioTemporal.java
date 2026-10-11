/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;

/**
 *
 * @author isard
 */
    public class SocioTemporal extends Socio {

        private LocalDate fechaFinSuscripcion;

        public SocioTemporal(String id, String nombre, Plan plan,
                double cuotaBase,
                LocalDate fechaFinSuscripcion) {
            super(id, nombre, plan, cuotaBase);

            if (fechaFinSuscripcion == null) {
                throw new IllegalArgumentException(
                        "La fecha de fin es obligatoria."
                );
            }

            this.fechaFinSuscripcion = fechaFinSuscripcion;
        }

        @Override
        public double calcularCuota() {
            return cuotaBase * 1.10;
        }

        public LocalDate getFechaFinSuscripcion() {
            return fechaFinSuscripcion;
        }

        @Override
        public String getTipo() {
            return "TEMPORAL";
        }

        @Override
        public String toString() {
            return super.toString()
                    + " | Fecha fin: " + fechaFinSuscripcion;
        }
    }

