package ejerciciosAfter;

import java.util.Scanner;

public class CrudArticulos {
    public static void main(String[] args) {
        // ==========================
        // Declaraciones iniciales
        // ==========================

        // Array de String para almacenar hasta 10 artículos
        String[] articulos = new String[10];

        // Contador de artículos cargados
        int cantidadArticulos = 0;

        // Scanner para leer datos del usuario
        Scanner scanner = new Scanner(System.in);

        // ============================================================
        // A partir de aquí, los alumnos deben ir resolviendo el enunciado:
        // ============================================================

        /*
         * 1. Menú principal:
         *   - Mostrar opciones:
         *     1. Crear artículo
         *     2. Modificar artículo
         *     3. Listar artículo por posición
         *     4. Listar todos los artículos
         *     5. Eliminar artículo
         *     6. Salir
         *   - Usar un bucle while para repetir hasta que elija "Salir".
         *   - Validar que la opción ingresada esté entre 1 y 6.
         */

        /*
         * 2. Crear artículo:
         *   - Pedir nombre del artículo.
         *   - Validar que no esté vacío.
         *   - Guardarlo en la primera posición libre del array.
         *   - Incrementar el contador.
         */

        /*
         * 3. Modificar artículo:
         *   - Pedir número de posición (índice del array).
         *   - Validar que esté dentro del rango y que no esté vacío.
         *   - Pedir nuevo nombre y reemplazarlo.
         */

        /*
         * 4. Listar artículo por posición:
         *   - Pedir índice.
         *   - Validar y mostrar solo si existe un artículo en esa posición.
         */

        /*
         * 5. Listar todos los artículos:
         *   - Recorrer el array con un bucle for o foreach.
         *   - Mostrar los artículos cargados, indicando su posición.
         */

        /*
         * 6. Eliminar artículo:
         *   - Pedir índice.
         *   - Validar y poner en null esa posición si está ocupada.
         */

        /*
         * 7. Salir:
         *   - Mostrar mensaje de despedida y finalizar el programa.
         */

        // Fin del main
    }
}
