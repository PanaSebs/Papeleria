package papeleria;

import java.util.Scanner;

public class Papeleria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        while (true) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        inventario.agregarProducto();
                        break;
                    case 2:
                        inventario.mostrarInventario();
                        break;
                    case 3:
                        inventario.eliminarProducto();
                        break;
                    case 4:
                        inventario.buscarProducto();
                        break;
                    case 5:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Por favor, seleccione una opción válida.");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Asegúrese de ingresar datos válidos.");
                scanner.nextLine();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Agregar Producto");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Buscar Producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
}