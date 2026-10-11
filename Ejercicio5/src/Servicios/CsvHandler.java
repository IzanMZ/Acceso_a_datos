/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import modelos.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 *
 * @author isard
 */
public class CsvHandler {
    private static final String ARCHIVO = "socios.csv";

    public static void guardarSocios(Socio[] socios) {
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(
                    new FileOutputStream(ARCHIVO),
                    StandardCharsets.UTF_8))) {

            pw.println(
                "TIPO,PLAN,ID,NOMBRE,CUOTA_BASE,CUOTA_FINAL,DATO1,DATO2"
            );

            for (Socio socio : socios) {
                if (socio == null) {
                    continue;
                }

                String dato1 = "";
                String dato2 = "";

                if (socio instanceof SocioVip) {
                    SocioVip vip = (SocioVip) socio;
                    dato1 = String.valueOf(vip.getMesesAntiguedad());
                    dato2 = String.valueOf(vip.isAccesoTaquilla());

                } else if (socio instanceof SocioBase) {
                    SocioBase base = (SocioBase) socio;
                    dato1 = String.valueOf(base.getMesesAntiguedad());

                } else if (socio instanceof SocioTemporal) {
                    SocioTemporal temporal = (SocioTemporal) socio;
                    dato1 = temporal.getFechaFinSuscripcion().toString();
                }

                pw.printf(
                    Locale.US,
                    "%s,%s,%s,%s,%.2f,%.2f,%s,%s%n",
                    socio.getTipo(),
                    socio.getPlan(),
                    limpiar(socio.getId()),
                    limpiar(socio.getNombre()),
                    socio.getCuotaBase(),
                    socio.calcularCuota(),
                    dato1,
                    dato2
                );
            }

            System.out.println("Datos guardados en " + ARCHIVO);

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static Socio[] cargarSocios() {
        Socio[] socios = new Socio[100];
        int contador = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(ARCHIVO),
                    StandardCharsets.UTF_8))) {

            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    if (linea.startsWith("TIPO,")) {
                        continue;
                    }
                }

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] campos = linea.split(",", -1);

                if (campos.length < 6) {
                    System.out.println("Línea CSV no válida: " + linea);
                    continue;
                }

                try {
                    String tipo = campos[0];
                    Plan plan = Plan.valueOf(campos[1]);
                    String id = campos[2];
                    String nombre = campos[3];
                    double cuotaBase = Double.parseDouble(campos[4]);
                    String dato1 = campos.length > 6 ? campos[6] : "";
                    String dato2 = campos.length > 7 ? campos[7] : "";

                    Socio socio;

                    switch (tipo) {
                        case "BASE":
                            socio = new SocioBase(
                                id, nombre, plan, cuotaBase,
                                Integer.parseInt(dato1)
                            );
                            break;

                        case "TEMPORAL":
                            socio = new SocioTemporal(
                                id, nombre, plan, cuotaBase,
                                java.time.LocalDate.parse(dato1)
                            );
                            break;

                        case "VIP":
                            socio = new SocioVip(
                                id, nombre, plan, cuotaBase,
                                Integer.parseInt(dato1),
                                Boolean.parseBoolean(dato2)
                            );
                            break;

                        default:
                            System.out.println(
                                "Tipo de socio desconocido: " + tipo
                            );
                            continue;
                    }

                    if (contador < socios.length) {
                        socios[contador++] = socio;
                    } else {
                        System.out.println("Se ha alcanzado el límite de socios.");
                        break;
                    }

                } catch (RuntimeException e) {
                    System.out.println(
                        "Error en la línea: " + linea
                    );
                }
            }

            System.out.println("Socios cargados: " + contador);

        } catch (IOException e) {
            System.out.println(
                "No se pudieron cargar los datos: " + e.getMessage()
            );
        }

        Socio[] resultado = new Socio[contador];

        for (int i = 0; i < contador; i++) {
            resultado[i] = socios[i];
        }

        return resultado;
    }

    private static String limpiar(String texto) {
  
        return texto.replace(",", " ");
    }
} 

