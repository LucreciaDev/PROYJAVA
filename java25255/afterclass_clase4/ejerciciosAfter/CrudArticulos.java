package ejerciciosAfter;

import java.util.Scanner;

public class CrudArticulos {
    public static void main(String[] args) {
        // ==========================
        // Declaraciones iniciales
        // ==========================

        // Array de String para almacenar hasta 10 artículos
        String[] articulos = new String[10];

        // Scanner para leer datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Variable para controlar la opción del menú
        int opcion = 0;

        // ========================
        // Bucle principal del menú
        // ==========================
        while (opcion != 6) { // se repite mientras no elija salir
            // Mostrar menú
            System.out.println("\n===== MENÚ DE ARTÍCULOS =====");
            System.out.println("1. Crear artículo");
            System.out.println("2. Modificar artículo");
            System.out.println("3. Listar artículo por posición");
            System.out.println("4. Listar todos los artículos");
            System.out.println("5. Eliminar artículo");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            // Leer opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            // ==========================
            // Switch para ejecutar la opción
            // ==========================
            switch (opcion) {
                case 1: // Crear artículo
                    System.out.print("Ingrese el nombre del artículo: ");
                    String nuevo = scanner.nextLine();

                    // Validar que no esté vacío
                    if (nuevo.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    // Buscar una posición libre en el array
                    boolean guardado = false;
                    for (int i = 0; i < articulos.length; i++) {
                        if (articulos[i] == null) {
                            articulos[i] = nuevo;
                            System.out.println(" Artículo guardado en la posición " + i);
                            guardado = true;
                            break;
                        }
                    }

                    if (!guardado) {
                        System.out.println("No hay más espacio para artículos.");
                    }
                    break;

                case 2: // Modificar artículo
                    System.out.print("Ingrese la posición del artículo a modificar (0-9): ");
                    int posMod = scanner.nextInt();
                    scanner.nextLine();

                    // Validar posición
                    if (posMod < 0 || posMod >= articulos.length) {
                        System.out.println("Posición inválida.");
                        break;
                    }

                    if (articulos[posMod] == null) {
                        System.out.println("No hay artículo en esa posición.");
                        break;
                    }

                    // Pedir nuevo nombre
                    System.out.print("Ingrese el nuevo nombre: ");
                    String modificado = scanner.nextLine();

                    if (modificado.trim().isEmpty()) {
                        System.out.println(" El nombre no puede estar vacío.");
                        break;
                    }

                    articulos[posMod] = modificado;
                    System.out.println(" Artículo modificado correctamente.");
                    break;

                case 3: // Listar artículo por posición
                    System.out.print("Ingrese la posición a consultar (0-9): ");
                    int posVer = scanner.nextInt();

                    if (posVer < 0 || posVer >= articulos.length) {
                        System.out.println("Posición inválida.");
                        break;
                    }

                    if (articulos[posVer] == null) {
                        System.out.println("No hay artículo en esa posición.");
                    } else {
                        System.out.println("Artículo en posición " + posVer + ": " + articulos[posVer]);
                    }
                    break;

                case 4: // Listar todos los artículos
                    System.out.println("===== LISTADO DE ARTÍCULOS =====");
                    for (int i = 0; i < articulos.length; i++) {
                        if (articulos[i] != null) {
                            System.out.println("Posición " + i + ": " + articulos[i]);
                        } else {
                            System.out.println("Posición " + i + ": [vacío]");
                        }
                    }
                    break;

                case 5: // Eliminar artículo
                    System.out.print("Ingrese la posición del artículo a eliminar (0-9): ");
                    int posDel = scanner.nextInt();

                    if (posDel < 0 || posDel >= articulos.length) {
                        System.out.println("Posición inválida.");
                        break;
                    }

                    if (articulos[posDel] == null) {
                        System.out.println(" No hay artículo en esa posición.");
                    } else {
                        articulos[posDel] = null; // Se elimina asignando null
                        System.out.println("Artículo eliminado.");
                    }
                    break;

                case 6: // Salir
                    System.out.println("¡Gracias por usar el sistema!");
                    break;

                default: // Si ingresa algo fuera del 1-6
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}
