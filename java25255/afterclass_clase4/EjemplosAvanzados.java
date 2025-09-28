package inicio;
// Archivo: EjemplosAvanzados.java

public class EjemplosAvanzados {

    public static void main(String[] args) {
        // ---------- STRINGS ----------
        String nombre = "Gisele Gonzalez";

        // array de strings
        String[] nombresArrays = {"Ana", "Luis", "Carlos","Jose","Laura"};

        System.out.println("Nombre completo: " + nombresArrays[0]);
        System.out.println("Nombre completo: " + nombresArrays[1]);
        System.out.println("Nombre completo: " + nombresArrays[2]);
        System.out.println("ARRAY: " + nombresArrays.length + " elementos");
        // Recorrer el array
       
        for (int i = 0; i < nombresArrays.length; i++) {
            System.out.println("Nombre en índice " + i + ": " + nombresArrays[i]);
        }
     

        // Concatenación
        String saludo = "Hola, " + nombre;
        System.out.println(saludo);

        // Longitud
        System.out.println("Longitud: " + nombre.length());

        // Mayúsculas y minúsculas
        System.out.println("Mayúsculas: " + nombre.toUpperCase());
        System.out.println("Minúsculas: " + nombre.toLowerCase());

        // Substring
        System.out.println("Primeras 3 letras: " + nombre.substring(0, 3));

        // Comparaciones
        System.out.println("¿Es igual a 'Gisele Gonzalez'? " + nombre.equals("Gisele Gonzalez"));
        System.out.println("¿Es igual a 'gisele gonzalez' (ignorar mayúsculas)? " + nombre.equalsIgnoreCase("gisele gonzalez"));
       
        System.out.println("¿Empieza con 'Gis'? " + nombre.startsWith("Gis"));
        System.out.println("¿Termina con 'lez'? " + nombre.endsWith("lez"));

        // Buscar un carácter
        System.out.println("Posición de la primera 'e': " + nombre.indexOf("e"));

        // Reemplazar caracteres
        System.out.println("Reemplazar 'G' por 'K': " + nombre.replace("G", "K"));

        // Dividir en palabras
        String[] palabras = nombre.split(" ");
        System.out.println("Nombre: " + palabras[0] + ", Apellido: " + palabras[1]);

        // ---------- RECORRER STRING ----------
        System.out.println("\nRecorriendo cada carácter del nombre:");
        for (int i = 0; i < nombre.length(); i++) {
            System.out.println("Carácter en posición " + i + ": " + nombre.charAt(i));
        }

        // ---------- BUCLES ----------
        System.out.println("\nBucle for (1 al 5):");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("\nBucle while (1 al 5):");
        int contador = 1;
        while (contador <= 5) {
            System.out.println(contador);
            contador++;
        }

        System.out.println("\nBucle do...while (se ejecuta al menos 1 vez):");
        int numero = 6;
        do {
            System.out.println("Número: " + numero);
            numero++;
        } while (numero <= 5);

        // Foreach con arrays
        System.out.println("\nBucle foreach recorriendo un array:");
        int[] numeros = {10, 20, 30, 40};
        for (int n : numeros) {
            System.out.println("Valor: " + n);
        }

        // Foreach con lista de Strings
        System.out.println("\nForeach con array de Strings:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        // ---------- FUNCIONES PROPIAS ----------
        System.out.println("\nFunciones propias:");

        int suma = sumar(15, 25);
        System.out.println("Suma: " + suma);

        String mensaje = crearSaludo("Ana");
        System.out.println(mensaje);

        int factorialDe5 = factorial(5);
        System.out.println("Factorial de 5: " + factorialDe5);

        int cantidadVocales = contarVocales("Programacion");
        System.out.println("Cantidad de vocales en 'Programacion': " + cantidadVocales);

        int maximo = encontrarMaximo(numeros);
        System.out.println("Máximo en el array {10,20,30,40}: " + maximo);
    }

    // ---------- DEFINICIÓN DE FUNCIONES ----------
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static String crearSaludo(String nombre) {
        return "Hola " + nombre + ", ¡bienvenida!";
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Función que cuenta vocales en un String
    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }
        return contador;
    }

    // Función que devuelve el valor máximo de un array de enteros
    public static int encontrarMaximo(int[] numeros) {
        int max = numeros[0];
        for (int n : numeros) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}
