package ejercicio4;

import ejercicio4.animales.Mascota;
import ejercicio4.Cuidador.CuidadorMascota;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Refugio {

    private ArrayList<Mascota> mascotas;
    private ArrayList<CuidadorMascota> cuidadores;

    public Refugio() {
        mascotas = new ArrayList<>();
        cuidadores = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void agregarCuidador(CuidadorMascota cuidador) {
        cuidadores.add(cuidador);
    }

    public void asignarMascotas() {

        int posicionCuidador = 0;

        for (Mascota mascota : mascotas) {

            while (posicionCuidador < cuidadores.size()
                    && cuidadores.get(posicionCuidador)
                            .getMascotas().size() >= 4) {

                posicionCuidador++;
            }

            if (posicionCuidador < cuidadores.size()) {

                cuidadores.get(posicionCuidador)
                        .asignarMascota(mascota);

            } else {

                System.out.println(
                        "No hay cuidadores disponibles para asignar a "
                        + mascota.getNombre()
                );
            }
        }
    }

    public void entrenarTodas() {

        for (CuidadorMascota cuidador : cuidadores) {

            for (Mascota mascota : cuidador.getMascotas()) {

                cuidador.entrenarMascota(mascota);
            }
        }
    }

    public void mostrarMascotasPorCuidador() {
        for (CuidadorMascota cuidador : cuidadores) {
            System.out.println("\nCuidador: " + cuidador.getNombre() + " | ID: " + cuidador.getId());
            for (Mascota mascota : cuidador.getMascotas()) {
                System.out.println(" - " + mascota);
            }
        }

        try (PrintWriter escritor = new PrintWriter(new FileWriter("estado_refugio.txt"))) {
            escritor.println("===== ESTADO DEL REFUGIO =====");
            escritor.println();
            for (CuidadorMascota cuidador : cuidadores) {
                escritor.println("Cuidador: " + cuidador.getNombre());
                escritor.println("ID: " + cuidador.getId());
                escritor.println("Mascotas asignadas: " + cuidador.getMascotas().size());
                escritor.println("--------------------------------");
                for (Mascota mascota : cuidador.getMascotas()) {
                    escritor.println("Nombre: " + mascota.getNombre());
                    escritor.println("Edad: " + mascota.getEdad());
                    escritor.println("Raza: " + mascota.getRaza());
                    escritor.println();
                }
                escritor.println();
            }
            System.out.println("Estado guardado correctamente en "
                    + "estado_refugio.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

}
