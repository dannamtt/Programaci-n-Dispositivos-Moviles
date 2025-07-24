/*
 *   NOMBRE: Danna Paola Muñoz Tenorio
 *   MATERIA: Programación de Dispositivos Móviles
 *   ARCHIVO: Producto - que especificaciones tiene (nombre, precio y la imagen)
 */

public class Product {
    public String name;
    public int price;
    public String imageName;

    public Product(String name, int price, String imageName) {
        this.name = name;
        this.price = price;
        this.imageName = imageName;
    }
}
