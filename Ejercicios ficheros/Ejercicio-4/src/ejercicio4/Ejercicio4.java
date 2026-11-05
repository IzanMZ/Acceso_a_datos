/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import ejercicio4.Cuidador.CuidadorMascota;
import ejercicio4.animales.Gato;
import ejercicio4.animales.Huron;
import ejercicio4.animales.Loro;
import ejercicio4.animales.Mascota;
import ejercicio4.animales.Perro;

/**
 *
 * @author Estudiante-26_27
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        /*Crear mascotas*/
        Perro perro = new Perro("Toby", 3, "Labrador");
        Gato gato = new Gato("Michi", 2, "Siamés");
        Loro loro = new Loro("Pepe", 5, "Loro gris");
        Huron huron = new Huron("Nico", 1, "Hurón albino");

        Mascota[] mascotasPrueba = {
            perro, gato, loro, huron
        };

        for (Mascota mascota : mascotasPrueba) {
            System.out.println("\n" + mascota);
            mascota.emmitirSonido();
            mascota.hacerTruco();
        }

        /*Crear refugio*/
        Refugio refugio = new Refugio();

        /*Crear  cuidadores*/
        CuidadorMascota cuidador1 = new CuidadorMascota("Carlos");
        CuidadorMascota cuidador2 = new CuidadorMascota("Laura");

        /*Agregar cuidador al refugio*/
        refugio.agregarCuidador(cuidador1);
        refugio.agregarCuidador(cuidador2);

        /*Agregar mascotas al refugio*/
        refugio.agregarMascota(perro);
        refugio.agregarMascota(gato);
        refugio.agregarMascota(loro);
        refugio.agregarMascota(huron);

        /*Asignacion automatica de mascotas*/
        System.out.println("Asiganado mascotas");
        refugio.asignarMascotas();

        /*Entrenar mascotas*/
        System.out.println("Entrenando mascotas");
        refugio.entrenarTodas();

        /*Ver como esta el refugio*/
        System.out.println("Estado refugio");
        refugio.mostrarMascotasPorCuidador();

        /*Limite del cuidador*/
        Gato gato1 = new Gato("Mau",4, "esfing");
        Loro loro1 = new Loro("Alfredo", 5, "Loro canario");
        Huron huron1 = new Huron("Marcos", 1, "Normal");
        cuidador1.asignarMascota(gato1);
        cuidador1.asignarMascota(loro1);
        cuidador1.asignarMascota(huron1);
    }

}
