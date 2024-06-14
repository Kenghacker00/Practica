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
                    buscarProducto();
                    break;
                case 3:
                    añadirProducto();
                    break;
                case 4:
                    borrarProducto();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    private static int obtenerOpcionDelUsuario() {
        System.out.println("1. Mostrar catálogo");
        System.out.println("2. Buscar Producto");
        System.out.println("3. Añadir producto");
        System.out.println("4. Borrar producto");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }

    private static void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío");
        } else {
            System.out.println("Catálogo de productos: ");
            for (Producto producto : catalogo) {
                System.out.println(producto);
                System.out.println();
            }
        }
    }

    private static void añadirProducto() {
        System.out.print("Introduce el código del producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce el nombre del producto: ");
        String nombre = scanner.nextLine();
        double precio;
        double costo;
        do {
            System.out.print("Introduce el precio del producto: ");
            precio = scanner.nextDouble();
            System.out.print("Introduce el costo del producto (debe ser menor al precio): ");
            costo = scanner.nextDouble();
            if (costo > precio) {
                System.out.println("El costo no puede ser mayor al precio. Por favor, inténtalo de nuevo.");
            }
        } while (costo > precio);
        scanner.nextLine(); 
        System.out.print("Introduce la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Introduce la cantidad de productos: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        Producto nuevoProducto = new Producto(codigo, nombre, precio, costo, descripcion, cantidad);
        catalogo.add(nuevoProducto);
        System.out.println("Producto añadido al catálogo.");
    }

    private static void buscarProducto() {
        System.out.print("Introduce el código del producto a buscar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 
        boolean encontrado = false;

        for (Producto producto : catalogo) {
            if (producto.getCodigo() == codigo) {
                System.out.println("Producto encontrado: ");
                System.out.println(producto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void borrarProducto() {
        System.out.print("Introduce el nombre del producto a borrar: ");
        scanner.nextLine();
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
            System.out.println("Producto borrado del catálogo");
        } else {
            System.out.println("Producto no encontrado");
        }
        
        
    }
}