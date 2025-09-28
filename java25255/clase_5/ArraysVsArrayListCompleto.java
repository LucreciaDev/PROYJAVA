package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraysVsArrayListCompleto {
    public static void main(String[] args) {
        // ============================================================
        // ARRAYS FIJOS
        // ============================================================
        /*
         * Un ARRAY en Java es una estructura de datos de TAMAÑO FIJO.
         * - Se declara con un tipo (int, String, etc.).
         * - Su tamaño se establece al crearlo y NO puede cambiarse.
         * - Ventajas: más rápido y más eficiente en memoria.
         * - Desventajas: no se puede ampliar ni reducir dinámicamente.
         */

        // Crear un array de enteros de tamaño 3
        int[] numeros = new int[3];
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;

        // Intentar agregar una posición extra da error de índice
        // numeros[3] = 40; ❌ -> ArrayIndexOutOfBoundsException

        // Array de String inicializado directamente
        String[] nombres = {"Ana", "Juan", "Pedro"};

        // Recorrer con for
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Posición " + i + ": " + nombres[i]);
        }

        // Arrays utilitarios
        int[] datos = {5, 9, 1, 7};
        Arrays.sort(datos); // ordena ascendente
        System.out.println("Array ordenado: " + Arrays.toString(datos));

        int[] copia = Arrays.copyOf(datos, datos.length);
        System.out.println("Copia del array: " + Arrays.toString(copia));

        System.out.println("¿Son iguales datos y copia? " + Arrays.equals(datos, copia));

        // ============================================================
        // ARRAYLIST
        // ============================================================
        /*
         * Un ArrayList es una clase de Java que representa una lista dinámica.
         * Internamente usa un array, pero maneja automáticamente el tamaño.
         * Es más flexible que un array normal.
         */

        ArrayList<String> lista = new ArrayList<>();

        // ---------------- MÉTODOS PRINCIPALES ----------------

        // add(E e): agrega al final, devuelve boolean (true si se agregó)
        lista.add("Lapicera"); // true
        lista.add("Cuaderno");

        // add(int index, E e): inserta en una posición
        lista.add(1, "Carpeta"); // no devuelve nada (void)
        // En un arrayList de Java, no podes "saltarte posiciones" dejando null las posiciones intermedias o anteriores
        // el method add agrega siempre al final de la lista
        // el method add con indice, inserta en la posición indicada, si esa posición existe y corre el resto a la derecha
        // lista.add(5, "Tijera"); // ❌ IndexOutOfBoundsException en el caso de un error da excepcion.
        /* ejemplo
         * ArrayList<String> lista = new ArrayList<>();
         * lista.add("A"); // índice 0 [A]
         * lista.add("B"); // índice 1 [A , B]
         * lista.add(1, "C"); // inserta "C" en índice 1, "B" pasa a índice 2 [A , C , B]
         * 
         */

        // get(int index): devuelve el elemento en la posición
        System.out.println("Elemento en pos 1: " + lista.get(1));

        // set(int index, E e): reemplaza y devuelve el elemento anterior
        String reemplazado = lista.set(1, "Mochila");
        System.out.println("Elemento reemplazado: " + reemplazado);

        // remove(int index): elimina por índice y devuelve el elemento eliminado
        String eliminado = lista.remove(0);
        System.out.println("Elemento eliminado en pos 0: " + eliminado);
        // QUE DEVUELVE CUANDO NO ENCUENTRA EL ÍNDICE? -> IndexOutOfBoundsException

        // remove(Object o): elimina por valor y devuelve boolean (true si lo encontró y borró)
        boolean borrado = lista.remove("Mochila");
        System.out.println("¿Se eliminó 'Mochila'? " + borrado);

        // contains(Object o): devuelve true si existe el valor
        System.out.println("¿Contiene 'Cuaderno'? " + lista.contains("Cuaderno"));

        // size(): devuelve el número de elementos
        System.out.println("Tamaño de la lista: " + lista.size());

        // isEmpty(): true si está vacía
        System.out.println("¿Está vacía? " + lista.isEmpty());

        // indexOf(Object o): devuelve el índice de la primera aparición o -1 si no existe
        lista.add("Cartuchera");
        lista.add("Cuaderno");
        lista.add("Cartuchera");
        System.out.println("Primer índice de 'Cartuchera': " + lista.indexOf("Cartuchera"));

        // lastIndexOf(Object o): última aparición
        System.out.println("Último índice de 'Cartuchera': " + lista.lastIndexOf("Cartuchera"));

        // subList(int from, int to): devuelve una vista parcial de la lista (no una copia)
        System.out.println("Sublista (0 a 2): " + lista.subList(0, 2));

        // clear(): borra todos los elementos (void)
        lista.clear();
        System.out.println("Lista después de clear(): " + lista);

        // addAll(Collection c): agrega varios elementos de otra colección
        lista.addAll(Arrays.asList("A", "B", "C"));

        // removeAll(Collection c): elimina todos los que coincidan
        lista.removeAll(Arrays.asList("B", "C"));
        System.out.println("Lista después de removeAll: " + lista);

        // retainAll(Collection c): conserva solo los que coincidan
        lista.addAll(Arrays.asList("B", "C", "D"));
        lista.retainAll(Arrays.asList("A", "D"));
        System.out.println("Lista después de retainAll: " + lista);

        // clone(): devuelve un objeto copia (shallow copy)
        @SuppressWarnings("unchecked")
        ArrayList<String> clon = (ArrayList<String>) lista.clone();
        System.out.println("Clon de la lista: " + clon);

        // toArray(): convierte a un array de Object
        Object[] array1 = lista.toArray();
        System.out.println("Array convertido: " + Arrays.toString(array1));

        // toArray(T[] a): convierte al tipo de array indicado
        String[] array2 = lista.toArray(new String[0]);
        System.out.println("Array tipado: " + Arrays.toString(array2));

        // sort con Collections
        lista.clear();
        lista.addAll(Arrays.asList("Zorro", "Gato", "Perro"));
        Collections.sort(lista); // ordena ascendente
        System.out.println("Ordenado: " + lista);

        Collections.reverse(lista); // invierte orden
        System.out.println("Reverso: " + lista);

        Collections.shuffle(lista); // mezcla aleatoriamente
        System.out.println("Mezclado: " + lista);

        System.out.println("Máximo: " + Collections.max(lista));
        System.out.println("Mínimo: " + Collections.min(lista));

        // forEach con lambda
        System.out.println("Recorrido con forEach:");
        lista.forEach(item -> System.out.println("Elemento: " + item));

        // stream(): convierte la lista en un flujo (útil con programación funcional)
        //s -> s.contains("a") // PARAMETRO (String s) -> CUERPO (s.contains("a"))
        long cantidadConA = lista.stream().filter((elementoLista) -> elementoLista.contains("a")).count();
        System.out.println("Cantidad de elementos con 'a': " + cantidadConA);
        // El stream permite operaciones funcionales como filter, map, reduce, etc.
        //lo puedo hacer sin stream?
        // porque no usar filter directamente sobre la lista ? 

        // LAMBDAS ESTRUCTURA BASICA:
        /* QUE ES UNA LAMBDA
         * Una lambda es una función anónima (sin nombre) que se puede pasar como parámetro.
         */
        // PARAMETROS -> CUERPO
        /*
         * (parametros) -> {
         *      // cuerpo
         *      return valor; // si es necesario
         * }
         */
        // ============================================================
        // DIFERENCIAS PRINCIPALES
        // ============================================================
        /*
         * ARRAY:
         *  - Tamaño fijo.
         *  - Más rápido y eficiente en memoria.
         *  - Se usa para datos de tamaño conocido.
         *
         * ARRAYLIST:
         *  - Tamaño dinámico (se agranda y achica automáticamente).
         *  - Tiene métodos útiles (add, remove, contains, size, sort, etc.).
         *  - Se usa para colecciones donde la cantidad de elementos cambia.
         *
         * NOTA:
         *  - Un array de String NO puede agregar posiciones dinámicamente.
         *    Si lo definís con tamaño 3, siempre tendrá 3.
         *  - Un ArrayList<String> sí puede crecer dinámicamente.
         */
    }
}
