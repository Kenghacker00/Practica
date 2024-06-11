import java.util.Scanner;
import java.util.ArrayList;


public class App {
    private static ArrayList<Producto> catalogo = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = obtenerOpcionDelUsuario();
            switch (opcion) {
                case 1:
                    mostrarCatalogo();
                    break;
                case 2:
                    añadirProducto();
                    break;
                case 3:
                    borrarProducto();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static int obtenerOpcionDelUsuario() {
        System.out.println("1. Mostrar catálogo");
        System.out.println("2. Añadir producto");
        System.out.println("3. Borrar producto");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }

    private static void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("Catálogo de productos:");
            for (Producto producto : catalogo) {
                System.out.println(producto);
                System.out.println();
            }
        }
    }

    private static void añadirProducto() {
        System.out.print("Introduce el nombre del producto: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        System.out.print("Introduce el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Introduce el costo del producto: ");
        double costo = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Introduce la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Introduce la cantidad de productos: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        Producto nuevoProducto = new Producto(nombre, precio, costo, descripcion, cantidad);
        catalogo.add(nuevoProducto);
        System.out.println("Producto añadido al catálogo.");
    }

    private static void borrarProducto() {
        System.out.print("Introduce el nombre del producto a borrar: ");
        String nombre = scanner.nextLine();
        Producto productoABorrar = null;
        for (Producto producto : catalogo) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productoABorrar = producto;
                break;
            }
        }
        if (productoABorrar != null) {
            catalogo.remove(productoABorrar);
            System.out.println("Producto borrado del catálogo.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}