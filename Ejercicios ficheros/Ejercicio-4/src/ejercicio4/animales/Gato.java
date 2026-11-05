/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.animales;

import ejercicio4.animales.Mascota;

/**
 *
 * @author Estudiante-26_27
 */
public class Gato extends Mascota{

    public Gato(String nombre, int edad, String raza) {
        super(nombre, edad, raza);
    }
    
    @Override
    public void emmitirSonido(){
        System.out.println("Maullido");
    
    }

    public  void hacerTruco(){
        System.out.println("Cazar raton");
    
    }
}
