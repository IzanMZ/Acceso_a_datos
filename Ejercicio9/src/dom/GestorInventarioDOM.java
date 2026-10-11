/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dom;

import modelo.Producto;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author isard
 */
public class GestorInventarioDOM {

    private static final String ARCHIVO = "inventario.xml";

    public static void anadirProducto(Producto p) {
        try {
            File fichero = new File(ARCHIVO);
            DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;

            if (fichero.exists()) {
                doc = builder.parse(fichero);
            } else {
                doc = builder.newDocument();
                doc.appendChild(doc.createElement("inventario"));
            }

            NodeList lista = doc.getElementsByTagName("producto");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elemento = (Element) lista.item(i);

                if (elemento.getAttribute("codigo")
                        .equalsIgnoreCase(p.getCodigo())) {
                    System.out.println(
                            "Ya existe un producto con ese código");
                    return;
                }
            }

            Element producto = doc.createElement("producto");
            producto.setAttribute("codigo", p.getCodigo());

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(p.getNombre());
            producto.appendChild(nombre);

            Element categoria = doc.createElement("categoria");
            categoria.setTextContent(p.getCategoria());
            producto.appendChild(categoria);

            Element marca = doc.createElement("marca");
            marca.setTextContent(p.getMarca());
            producto.appendChild(marca);

            Element precio = doc.createElement("precio");
            precio.setTextContent(String.valueOf(p.getPrecio()));
            producto.appendChild(precio);

            Element stock = doc.createElement("stock");
            stock.setTextContent(String.valueOf(p.getStock()));
            producto.appendChild(stock);

            doc.getDocumentElement().appendChild(producto);

            Transformer transformer
                    = TransformerFactory.newInstance().newTransformer();
            transformer.transform(
                    new DOMSource(doc),
                    new StreamResult(fichero));

            System.out.println("Producto añadido correctamente");

        } catch (Exception e) {
            System.out.println("Error al añadir el producto");
        }
    }

    public static void mostrarProductos() {
        try {
            File fichero = new File(ARCHIVO);

            if (!fichero.exists()) {
                System.out.println(
                        "El fichero inventario.xml no existe");
                return;
            }

            DocumentBuilder builder
                    = DocumentBuilderFactory.newInstance()
                            .newDocumentBuilder();
            Document doc = builder.parse(fichero);

            NodeList lista = doc.getElementsByTagName("producto");

            if (lista.getLength() == 0) {
                System.out.println("El inventario está vacío");
                return;
            }

            for (int i = 0; i < lista.getLength(); i++) {
                Element p = (Element) lista.item(i);

                System.out.println("\nProducto");
                System.out.println("Código: "
                        + p.getAttribute("codigo"));
                System.out.println("Nombre: "
                        + p.getElementsByTagName("nombre")
                                .item(0).getTextContent());
                System.out.println("Categoría: "
                        + p.getElementsByTagName("categoria")
                                .item(0).getTextContent());
                System.out.println("Marca: "
                        + p.getElementsByTagName("marca")
                                .item(0).getTextContent());
                System.out.println("Precio: "
                        + p.getElementsByTagName("precio")
                                .item(0).getTextContent() + " €");
                System.out.println("Stock: "
                        + p.getElementsByTagName("stock")
                                .item(0).getTextContent());
            }

        } catch (Exception e) {
            System.out.println("Error al leer el inventario");
        }
    }

    public static void actualizarStock(String codigo, int nuevoStock) {
        try {
            File fichero = new File(ARCHIVO);

            if (!fichero.exists()) {
                System.out.println(
                        "El fichero inventario.xml no existe");
                return;
            }

            DocumentBuilder builder
                    = DocumentBuilderFactory.newInstance()
                            .newDocumentBuilder();
            Document doc = builder.parse(fichero);

            NodeList lista = doc.getElementsByTagName("producto");

            for (int i = 0; i < lista.getLength(); i++) {
                Element p = (Element) lista.item(i);

                if (p.getAttribute("codigo").equalsIgnoreCase(codigo)) {
                    p.getElementsByTagName("stock")
                            .item(0).setTextContent(
                            String.valueOf(nuevoStock));

                    Transformer transformer
                            = TransformerFactory.newInstance()
                                    .newTransformer();
                    transformer.transform(
                            new DOMSource(doc),
                            new StreamResult(fichero));

                    System.out.println(
                            "Stock actualizado correctamente.");
                    return;
                }
            }

            System.out.println(
                    "No existe ningún producto con ese código.");

        } catch (Exception e) {
            System.out.println("Error al actualizar el stock");
        }
    }
}
