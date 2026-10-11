
package ejercicio3;

import java.util.Locale;

public class Estudiante {

    private int matricula;
    private String nombre;
    private String fechaInscripcion;
    private String curso;
    private double notaMedia;

    // Constructor con todos los atributos
    public Estudiante(int matricula, String nombre, String fechaInscripcion,
                      String curso, double notaMedia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.fechaInscripcion = fechaInscripcion;
        this.curso = curso;
        this.notaMedia = notaMedia;
    }

    // Constructor a partir de una línea del fichero
    public Estudiante(String linea) {
        String[] datos = linea.split(";");

        this.matricula = Integer.parseInt(datos[0]);
        this.nombre = datos[1];
        this.fechaInscripcion = datos[2];
        this.curso = datos[3];
        this.notaMedia = Double.parseDouble(datos[4].replace(",", "."));
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", fechaInscripcion='" + fechaInscripcion + '\'' +
                ", curso='" + curso + '\'' +
                ", notaMedia=" + String.format(Locale.US, "%.2f", notaMedia) +
                '}';
    }

    // Devuelve los atributos separados por ;
    // y usando la coma como separador decimal
    public String toStringWithSeparators() {
        return matricula + ";" +
                nombre + ";" +
                fechaInscripcion + ";" +
                curso + ";" +
                String.format(Locale.US, "%.2f", notaMedia).replace(".", ",");
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getCurso() {
        return curso;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
}

