package ejercicios;

// Importamos las librerías necesarias
import java.util.ArrayList; // Para usar ArrayList en lugar de arrays fijos
import java.util.Scanner;   // Para leer datos del usuario desde consola

// Clase principal del programa
public class CrudArticulos {

    // ==========================
    // Variables globales
    // ==========================

    // ArrayList que guardará los artículos como Strings dinámicos
    static ArrayList<String> articulos = new ArrayList<>();

    // Scanner para leer datos de teclado
    static Scanner scanner = new Scanner(System.in);

    // Método principal que se ejecuta al correr el programa
    public static void main(String[] args) {
        int opcion = 0; // variable para almacenar la opción elegida por el usuario

        // ==========================
        // Bucle principal del menú
        // ==========================
        while (opcion != 6) { // El menú se repetirá hasta que la opción sea 6 (Salir)
            mostrarMenu(); // Llamamos al método que imprime el menú en pantalla

            // Leemos la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiamos el buffer para evitar errores al leer Strings

            // Estructura switch para decidir qué acción ejecutar según la opción elegida
            switch (opcion) {
                case 1:
                    crearArticulo(); // Llamamos al método para crear un artículo
                    break;
                case 2:
                    modificarArticulo(); // Llamamos al método para modificar un artículo existente
                    break;
                case 3:
                    listarArticulo(); // Llamamos al método para listar un artículo en base a su posición
                    break;
                case 4:
                    listarTodos(); // Llamamos al método para listar todos los artículos
                    break;
                case 5:
                    eliminarArticulo(); // Llamamos al método para eliminar un artículo
                    break;
                case 6:
                    // Mensaje de despedida
                    System.out.println("👋 ¡Gracias por usar el sistema!");
                    break;
                default:
                    // Si la opción no está entre 1 y 6, mostramos error
                    System.out.println("❌ Opción inválida.");
            }
        }
    }

    // ==========================
    // Métodos propios del CRUD
    // ==========================

    // Método para mostrar el menú en pantalla
    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ DE ARTÍCULOS =====");
        System.out.println("1. Crear artículo");
        System.out.println("2. Modificar artículo");
        System.out.println("3. Listar artículo por posición");
        System.out.println("4. Listar todos los artículos");
        System.out.println("5. Eliminar artículo");
        System.out.println("6. Salir");
        System.out.print("Elija una opción: ");
    }

    // Método para crear un nuevo artículo
    public static void crearArticulo() {
        System.out.print("Ingrese el nombre del artículo: ");
        String nuevo = scanner.nextLine(); // Leemos el nombre ingresado

        // Validamos que no esté vacío
        if (nuevo.trim().isEmpty()) {
            System.out.println("❌ El nombre no puede estar vacío.");
            return; // Salimos del método si la validación falla
        }

        // Agregamos el artículo al ArrayList
        articulos.add(nuevo);
        System.out.println("✅ Artículo agregado correctamente.");
    }

    // Método para modificar un artículo
    public static void modificarArticulo() {
        // Validamos si la lista está vacía
        if (articulos.isEmpty()) {
            System.out.println("❌ No hay artículos para modificar.");
            return;
        }

        // Mostramos todos los artículos antes de modificar
        listarTodos();
        System.out.print("Ingrese la posición a modificar (0 a " + (articulos.size() - 1) + "): ");
        int pos = scanner.nextInt(); // Leemos la posición
        scanner.nextLine(); // limpiamos el buffer

        // Validamos que la posición exista en el ArrayList
        if (pos < 0 || pos >= articulos.size()) {
            System.out.println("❌ Posición inválida.");
            return;
        }

        // Pedimos el nuevo nombre para reemplazar
        System.out.print("Ingrese el nuevo nombre: ");
        String modificado = scanner.nextLine();

        // Validamos que no sea vacío
        if (modificado.trim().isEmpty()) {
            System.out.println("❌ El nombre no puede estar vacío.");
            return;
        }

        // Reemplazamos el valor en la posición indicada
        articulos.set(pos, modificado);
        System.out.println("✅ Artículo modificado correctamente.");
    }

    // Método para mostrar un artículo por posición
    public static void listarArticulo() {
        // Si la lista está vacía no se puede mostrar nada
        if (articulos.isEmpty()) {
            System.out.println("❌ No hay artículos cargados.");
            return;
        }

        // Pedimos la posición a consultar
        System.out.print("Ingrese la posición a consultar (0 a " + (articulos.size() - 1) + "): ");
        int pos = scanner.nextInt();
        scanner.nextLine();

        // Validamos que la posición exista
        if (pos < 0 || pos >= articulos.size()) {
            System.out.println("❌ Posición inválida.");
            return;
        }

        // Mostramos el artículo en esa posición
        System.out.println("📦 Artículo en posición " + pos + ": " + articulos.get(pos));
    }

    // Método para listar todos los artículos
    public static void listarTodos() {
        // Si la lista está vacía no hay nada que mostrar
        if (articulos.isEmpty()) {
            System.out.println("❌ No hay artículos cargados.");
            return;
        }

        System.out.println("===== LISTADO DE ARTÍCULOS =====");
        // Recorremos el ArrayList y mostramos cada posición con su contenido
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println("Posición " + i + ": " + articulos.get(i));
        }
    }

    // Método para eliminar un artículo
    public static void eliminarArticulo() {
        // Si la lista está vacía no hay nada que borrar
        if (articulos.isEmpty()) {
            System.out.println("❌ No hay artículos para eliminar.");
            return;
        }

        // Mostramos todos antes de eliminar para que el usuario elija
        listarTodos();
        System.out.print("Ingrese la posición del artículo a eliminar (0 a " + (articulos.size() - 1) + "): ");
        int pos = scanner.nextInt();
        scanner.nextLine();

        // Validamos que la posición sea válida
        if (pos < 0 || pos >= articulos.size()) {
            System.out.println("❌ Posición inválida.");
            return;
        }

        // Eliminamos el artículo de la lista
        articulos.remove(pos);
        System.out.println("✅ Artículo eliminado.");
    }
    // method eliminar articulo por nombre
    // public static void eliminarArticuloPorNombre() {
    //     if (articulos.isEmpty()) {
    //         System.out.println("❌ No hay artículos para eliminar.");
    //         return;
    //     }   
    //     System.out.print("Ingrese el nombre del artículo a eliminar: ");
    //     String nombre = scanner.nextLine();
    //     boolean eliminado = articulos.remove(nombre);
    //     if (eliminado) {
    //         System.out.println("✅ Artículo eliminado.");
    //     } else {
    //         System.out.println("❌ Artículo no encontrado.");
    //     }
   
}
