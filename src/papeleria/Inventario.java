package papeleria;

import java.util.*;

public class Inventario {

    int CAPACIDAD_MAXIMA = 200;
    Producto[] inventario = new Producto[CAPACIDAD_MAXIMA];
    int contador = 0;
    Scanner scanner = new Scanner(System.in);

    public void agregarProducto() {
        if (contador < CAPACIDAD_MAXIMA) {
            System.out.print("Ingrese el codigo del producto: ");
            String codigo = scanner.nextLine();
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            inventario[contador] = new Producto(codigo, nombre, precio, cantidad);
            contador++;
            System.out.println("Producto agregado con exito.");
        } else {
            System.out.println("Inventario lleno. No se pueden agregar más productos.");
        }
    }

    public void mostrarInventario() {
        if (contador == 0) {
            System.out.println("No hay productos en el inventario. Agregue productos primero.");
        } else {
            for (int i = 0; i < contador; i++) {
                Producto producto = inventario[i];
                if (producto != null) {
                    System.out.println("Codigo: " + producto.getCodigo()
                            + ", Nombre: " + producto.getNombre()
                            + ", Precio: " + producto.obtenerPrecio()
                            + ", Cantidad: " + producto.getCantidad());
                }
            }
        }
    }

    public void eliminarProducto() {
        System.out.print("Ingrese el codigo del producto a eliminar: ");
        String codigo = scanner.nextLine();

        for (int i = 0; i < contador; i++) {
            if (inventario[i] != null && inventario[i].getCodigo().equals(codigo)) {
                for (int j = i; j < contador - 1; j++) {
                    inventario[j] = inventario[j + 1];
                }
                inventario[contador - 1] = null;
                contador--;
                System.out.println("Producto eliminado con exito.");
                return;
            }
        }

        System.out.println("Producto no encontrado en el inventario.");
    }

    public void buscarProducto() {
        System.out.print("Ingrese el codigo del producto a buscar: ");
        String codigo = scanner.nextLine();

        for (int i = 0; i < contador; i++) {
            if (inventario[i] != null && inventario[i].getCodigo().equals(codigo)) {
                Producto producto = inventario[i];
                System.out.println("Producto encontrado - Codigo: " + producto.getCodigo()
                        + ", Nombre: " + producto.getNombre()
                        + ", Precio: " + producto.obtenerPrecio()
                        + ", Cantidad: " + producto.getCantidad());
                return;
            }
        }

        System.out.println("Producto no encontrado en el inventario.");
    }
}
