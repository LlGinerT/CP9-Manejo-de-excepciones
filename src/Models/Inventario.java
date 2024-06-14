package Models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getNombre().equals(producto.getNombre())) {
                p.restarCantidad(-producto.getCantidad());
                return;
            }
        }
        productos.add(producto);
    }

    public boolean verificarDisponibilidad(String nombreProducto, int cantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equals(nombreProducto) && p.getCantidad() >= cantidad) {
                return true;
            }
        }
        return false;
    }

    public void restarProducto(String nombreProducto, int cantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equals(nombreProducto)) {
                p.restarCantidad(cantidad);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder inventarioStr = new StringBuilder();
        for (Producto producto : productos) {
            inventarioStr.append(producto).append("\n");
        }
        return inventarioStr.toString();
    }
}
