/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sax;

import modelo.Producto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author isard
 */


public class LectorInventarioSAX {

    private static final String ARCHIVO = "inventario.xml";

    private static List<Producto> leerProductos() throws Exception {
        File fichero = new File(ARCHIVO);

        if (!fichero.exists()) {
            System.out.println("El fichero inventario.xml no existe");
            return null;
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        ManejadorInventario manejador = new ManejadorInventario();
        parser.parse(fichero, manejador);

        return manejador.getProductos();
    }

    public static void buscarPorCategoria(String categoriaBuscada) {
        try {
            List<Producto> productos = leerProductos();

            if (productos == null) {
                return;
            }

            boolean encontrado = false;

            for (Producto p : productos) {
                if (p.getCategoria().equalsIgnoreCase(categoriaBuscada.trim())) {
                    if (!encontrado) {
                        System.out.println("Productos encontrados:");
                    }

                    System.out.printf("%s - %s - %s - %.2f €%n",
                            p.getCodigo(), p.getNombre(),
                            p.getMarca(), p.getPrecio());

                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No existen productos de esa categoría");
            }

        } catch (Exception e) {
            System.out.println("Error al leer el XML: " + e.getMessage());
        }
    }

    public static void buscarPorStock(int limite) {
        try {
            List<Producto> productos = leerProductos();

            if (productos == null) {
                return;
            }

            boolean encontrado = false;

            for (Producto p : productos) {
                if (p.getStock() <= limite) {
                    if (!encontrado) {
                        System.out.println("Productos con stock insuficiente:");
                    }

                    System.out.printf("%s - %s - Stock: %d%n",
                            p.getCodigo(), p.getNombre(), p.getStock());

                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No existen productos con ese nivel de stock");
            }

        } catch (Exception e) {
            System.out.println("Error al leer el XML: " + e.getMessage());
        }
    }

    private static class ManejadorInventario extends DefaultHandler {

        private final List<Producto> productos = new ArrayList<>();

        private String codigo;
        private String nombre;
        private String categoria;
        private String marca;
        private String precio;
        private String stock;
        private StringBuilder contenido;

        @Override
        public void startElement(String uri, String localName,
                String qName, Attributes atributos) {

            contenido = new StringBuilder();

            if (qName.equals("producto")) {
                codigo = atributos.getValue("codigo");
                nombre = "";
                categoria = "";
                marca = "";
                precio = "";
                stock = "";
            }
        }

        @Override
        public void characters(char[] ch, int inicio, int longitud) {
            contenido.append(ch, inicio, longitud);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            String texto = contenido.toString().trim();

            switch (qName) {
                case "nombre":
                    nombre = texto;
                    break;
                case "categoria":
                    categoria = texto;
                    break;
                case "marca":
                    marca = texto;
                    break;
                case "precio":
                    precio = texto;
                    break;
                case "stock":
                    stock = texto;
                    break;
                case "producto":
                    productos.add(new Producto(
                            codigo, nombre, categoria, marca,
                            Double.parseDouble(precio),
                            Integer.parseInt(stock)));
                    break;
            }
        }

        public List<Producto> getProductos() {
            return productos;
        }
    }
}
