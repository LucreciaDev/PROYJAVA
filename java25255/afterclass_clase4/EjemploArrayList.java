package inicio;
// Archivo: EjemploArrayList.java

import java.util.ArrayList;
import java.util.Collections;

public class EjemploArrayList {
    public static void main(String[] args) {

        // ---------- CREACIÓN DE ARRAYLIST ----------
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Carlos");
        nombres.add("Gisele");

        System.out.println("Lista de nombres: " + nombres);

        // ---------- ACCEDER A ELEMENTOS ----------
        System.out.println("Primer nombre: " + nombres.get(0));
        System.out.println("Último nombre: " + nombres.get(nombres.size() - 1));

        // ---------- RECORRER ARRAYLIST ----------
        System.out.println("\nRecorrer con for clásico:");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("Índice " + i + ": " + nombres.get(i));
        }

        System.out.println("\nRecorrer con foreach:");
        for (String n : nombres) {
            System.out.println("Nombre: " + n);
        }

        System.out.println("\nRecorrer con forEach y lambda:");
        nombres.forEach(n -> System.out.println(">> " + n));

        // ---------- MODIFICAR Y ELIMINAR ----------
        nombres.set(1, "Lucía");
        System.out.println("\nLista modificada: " + nombres);

        nombres.remove("Carlos");
        nombres.remove(0);
        System.out.println("Lista después de eliminar: " + nombres);

        // ---------- ORDENAR ----------
        Collections.sort(nombres);
        System.out.println("Lista ordenada: " + nombres);

        // ---------- BÚSQUEDAS ----------
        System.out.println("¿Contiene 'Gisele'? " + nombres.contains("Gisele"));
        System.out.println("Posición de 'Gisele': " + nombres.indexOf("Gisele"));

        // ---------- ARRAYLIST DE NÚMEROS ----------
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(5);
        numeros.add(30);
        numeros.add(20);

        System.out.println("\nLista de números: " + numeros);

        Collections.sort(numeros);
        System.out.println("Números ordenados: " + numeros);

        double promedio = calcularPromedio(numeros);
        System.out.println("Promedio de la lista: " + promedio);

        int maximo = encontrarMaximo(numeros);
        System.out.println("Número máximo: " + maximo);
    }

    // ---------- FUNCIONES PROPIAS ----------
    public static double calcularPromedio(ArrayList<Integer> lista) {
        int suma = 0;
        for (int num : lista) {
            suma += num;
        }
        return (double) suma / lista.size();
    }

    public static int encontrarMaximo(ArrayList<Integer> lista) {
        int max = lista.get(0);
        for (int num : lista) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
