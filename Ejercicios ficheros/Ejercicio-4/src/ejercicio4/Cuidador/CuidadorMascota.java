package ejercicio4.Cuidador;

import ejercicio4.animales.Mascota;
import java.util.ArrayList;

public class CuidadorMascota implements Entrenador {

    private static int contadorId = 1;

    private String nombre;
    private int id;
    private ArrayList<Mascota> mascotas;

    public CuidadorMascota(String nombre) {
        this.nombre = nombre;
        this.id = contadorId++;
        this.mascotas = new ArrayList<>();
    }

    public void asignarMascota(Mascota mascota) {

        if (mascotas.size() >= 4) {
            System.out.println(
                "Límite alcanzado: el cuidador no puede recibir más mascotas"
            );
        } else {
            mascotas.add(mascota);
        }
    }

    @Override
    public void entrenarMascota(Mascota mascota) {
        System.out.println("Entrenando a " + mascota.getNombre());
        mascota.hacerTruco();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
}