package papeleria;

public class Producto {

    String codigo;
    String nombre;
    double precio;
    int cantidad;

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
