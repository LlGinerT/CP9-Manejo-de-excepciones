import java.util.Arrays;

import Models.Inventario;
import Models.Pedido;
import Models.Producto;
import Models.ProductoNoDisponibleException;

public class App {
    public static void procesarPedido(Inventario inventario, Pedido pedido) throws ProductoNoDisponibleException {
        for (Producto producto : pedido.getProductos()) {
            if (!inventario.verificarDisponibilidad(producto.getNombre(), producto.getCantidad())) {
                // ¿Cómo implementaría la excepción personalizada ProductoNoDisponibleException?
                // Podríamos usarla al procesar los pedidos y comprobar si hay stock disponible.
                throw new ProductoNoDisponibleException(
                        "-------------------------" + "\nError en el pedido: " + pedido.getId()
                                + "\nProducto no disponible: " + producto.getNombre() + "\n-------------------------");
            }
        }

        for (Producto producto : pedido.getProductos()) {
            inventario.restarProducto(producto.getNombre(), producto.getCantidad());
        }

        System.out.println("Pedido procesado: " + pedido);
    }

    public static void main(String[] args) {
        try {
            // agregar productos
            Inventario inventario = new Inventario();
            inventario.agregarProducto(new Producto("Laptop", 10));
            inventario.agregarProducto(new Producto("Mouse", 50));
            inventario.agregarProducto(new Producto("Teclado", 30));

            System.out.println("Inventario Inicial:");
            System.out.println(inventario);

            // Crear pedidos
            Pedido[] pedidos = {
                    new Pedido(Arrays.asList(
                            new Producto("Laptop", 4),
                            new Producto("Mouse", 5))),
                    new Pedido(Arrays.asList(
                            new Producto("Mouse", 5),
                            new Producto("Teclado", 3))),
                    new Pedido(Arrays.asList(
                            new Producto("Teclado", 40), // Este pedido lanzará una excepción
                            new Producto("Laptop", 1))),
                    new Pedido(Arrays.asList(
                            new Producto("Mouse", 10),
                            new Producto("Teclado", 5))),
                    new Pedido(Arrays.asList(
                            new Producto("Mouse", 15),
                            new Producto("Teclado", 3))),
                    new Pedido(Arrays.asList(
                            new Producto("Laptop", 4),
                            new Producto("Mouse", 10),
                            new Producto("Teclado", 5))),
                    new Pedido(Arrays.asList(
                            new Producto("Mouse", 5),
                            new Producto("Teclado", 10))),
                    new Pedido(Arrays.asList(
                            new Producto("Mouse", 8)))

            };

            // Procesar pedidos
            for (Pedido pedido : pedidos) {
                // ¿Cómo manejaría las excepciones lanzadas durante el procesamiento del pedido
                // en la función principal?
                // La podríamos manejar con un try/catch mientras iteramos por los pedidos
                // comprobando el stock
                try {
                    procesarPedido(inventario, pedido);
                } catch (ProductoNoDisponibleException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("\nInventario final:");
            System.out.println(inventario);
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la creación de inventario: " + e.getMessage());
        }
    }
}