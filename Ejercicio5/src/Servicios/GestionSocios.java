/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import modelos.Socio;

/**
 *
 * @author isard
 */
public class GestionSocios {
    private Socio[] socios;
    private int contador;

    public GestionSocios() {
        socios = new Socio[100];
        contador = 0;
    }

    public void agregarSocio(Socio socio) {
        if (socio == null) {
            System.out.println("El socio no es válido.");
            return;
        }

        if (contador >= socios.length) {
            System.out.println("No hay espacio para más socios.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            if (socios[i].getId().equalsIgnoreCase(socio.getId())) {
                System.out.println("Ya existe un socio con ese ID.");
                return;
            }
        }

        socios[contador] = socio;
        contador++;
        System.out.println("Socio agregado correctamente.");
    }

    public void listarSocios() {
        if (contador == 0) {
            System.out.println("No hay socios registrados.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            System.out.println(socios[i]);
        }
    }

    public double calcularRecaudacionTotal() {
        double total = 0;

        for (int i = 0; i < contador; i++) {
            total += socios[i].calcularCuota();
        }

        return total;
    }

    public Socio[] getSocios() {
        Socio[] copia = new Socio[contador];

        for (int i = 0; i < contador; i++) {
            copia[i] = socios[i];
        }

        return copia;
    }

    public void reemplazarSocios(Socio[] nuevosSocios) {
        socios = new Socio[100];
        contador = 0;

        if (nuevosSocios == null) {
            return;
        }

        for (Socio socio : nuevosSocios) {
            if (socio != null && contador < socios.length) {
                boolean existe = false;

                for (int i = 0; i < contador; i++) {
                    if (socios[i].getId().equalsIgnoreCase(socio.getId())) {
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    socios[contador++] = socio;
                }
            }
        }
    }
}
