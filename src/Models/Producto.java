package Models;

public class Producto {

    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        if (cantidad < 0) {
            // ¿Qué excepciones estándar de Java utilizaría en este escenario?
            // Podríamos usar esta en este escenario para asegurarnos que no se introduzca
            // un Stock invalido.
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void restarCantidad(int cantidad) {
        this.cantidad -= cantidad;
    }

    @Override
    public String toString() {
        return nombre + ", Cantidad= " + cantidad;
    }
}
