package papeleria;

import java.util.Scanner;

public class Inventario {

    private static final int CMax = 100;
    private Producto[] inventario = new Producto[CMax];
    private int contador = 0;
    private Scanner scanner = new Scanner(System.in);

    public void agregarProducto() {
        try {
            if (contador < CMax) {
                System.out.print("Ingrese el código del producto: ");
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
                System.out.println("Producto agregado con éxito.");
            } else {
                System.out.println("Inventario lleno. No se pueden agregar más productos.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese datos válidos.");
            scanner.nextLine();
        }
    }

    public void mostrarInventario() {
        if (contador == 0) {
            System.out.println("No hay productos en el inventario. Agregue productos primero.");
            return;
        }

        System.out.println("Inventario de la papelería:");
        for (int i = 0; i < contador; i++) {
            Producto producto = inventario[i];
            System.out.println("Código: " + producto.getCodigo()
                    + ", Nombre: " + producto.getNombre()
                    + ", Precio: " + producto.getPrecio()
                    + ", Cantidad: " + producto.getCantidad());
        }
    }

    public void eliminarProducto() {
        if (contador == 0) {
            System.out.println("No hay productos en el inventario. Agregue productos primero.");
            return;
        }

        try {
            System.out.print("Ingrese el código del producto a eliminar: ");
            String codigo = scanner.nextLine();

            for (int i = 0; i < contador; i++) {
                if (inventario[i] != null && inventario[i].getCodigo().equals(codigo)) {
                    for (int j = i; j < contador - 1; j++) {
                        inventario[j] = inventario[j + 1];
                    }
                    inventario[contador - 1] = null;
                    contador--;
                    System.out.println("Producto eliminado con éxito.");
                    return;
                }
            }

            System.out.println("Producto no encontrado en el inventario.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un código válido.");
            scanner.nextLine();
        }
    }

    public void buscarProducto() {
        if (contador == 0) {
            System.out.println("No hay productos en el inventario. Agregue productos primero.");
            return;
        }

        try {
            System.out.print("Ingrese el código del producto a buscar: ");
            String codigo = scanner.nextLine();

            for (int i = 0; i < contador; i++) {
                if (inventario[i] != null && inventario[i].getCodigo().equals(codigo)) {
                    Producto producto = inventario[i];
                    System.out.println("Producto encontrado - Código: " + producto.getCodigo()
                            + ", Nombre: " + producto.getNombre()
                            + ", Precio: " + producto.getPrecio()
                            + ", Cantidad: " + producto.getCantidad());
                    return;
                }
            }

            System.out.println("Producto no encontrado en el inventario.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un código válido.");
            scanner.nextLine();
        }
    }

    public void actualizarProducto() {
        if (contador == 0) {
            System.out.println("No hay productos en el inventario. Agregue productos primero.");
            return;
        }

        try {
            System.out.print("Ingrese el código del producto a actualizar: ");
            String codigo = scanner.nextLine();

            for (int i = 0; i < contador; i++) {
                if (inventario[i] != null && inventario[i].getCodigo().equals(codigo)) {
                    Producto producto = inventario[i];
                    System.out.println("Producto encontrado - Código: " + producto.getCodigo()                            
                            + ", Precio: " + producto.getPrecio()
                            + ", Cantidad: " + producto.getCantidad());

                    System.out.println("Seleccione qué atributo desea actualizar:");                    
                    System.out.println("1. Precio");
                    System.out.println("2. Cantidad");
                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el nuevo precio del producto: ");
                            double nuevoPrecio = scanner.nextDouble();
                            producto.setPrecio(nuevoPrecio);
                            System.out.println("Precio actualizado con éxito.");
                            break;
                        case 2:
                            System.out.print("Ingrese la nueva cantidad del producto: ");
                            int nuevaCantidad = scanner.nextInt();
                            producto.setCantidad(nuevaCantidad);
                            System.out.println("Cantidad actualizada con éxito.");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            return;
                    }
                    return;
                }
            }

            System.out.println("Producto no encontrado en el inventario.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese datos válidos.");
            scanner.nextLine();
        }
    }
}
