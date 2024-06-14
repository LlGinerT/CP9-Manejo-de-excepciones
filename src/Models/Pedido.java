package Models;

import java.util.List;

public class Pedido {
    private static int idGenerator = 1;
    private int id;
    private List<Producto> productos;

    public Pedido(List<Producto> productos) {
        this.id = idGenerator++;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "id_pedido= " + id +
                " Productos= " + productos;
    }
}
