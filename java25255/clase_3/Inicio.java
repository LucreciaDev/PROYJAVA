package inicio;

// importamos scanner para levantar datos del user
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        // Imprime "Hola Mundo desde Java!" en la consola
        System.out.println("Hola Mundo desde Java!");

        //COMO LEVANTAR DATOS POR TECLADO Y GUARDARLO EN MEMORIA
        //Creamos un objeto Scanner para leer la entrada del usuario
        //Tipo de dato del objeto  nombre = new(palabra reservada para instanciar un objeto en memoria) constructor de la clase con los parametros que recibe para crear ese objeto en memoria.
        Scanner scanner = new Scanner(System.in);
        // Pedimos al usuario que ingrese un número
        System.out.println("Ingrese su edad: ");
        // Leemos el número ingresado por el usuario
        int edad = scanner.nextInt();
        // Imprimimos el número que ingresó el usuario
        System.out.println("Su edad es: " + edad);

        //Ingreso de string
        System.out.println("Ingrese su nombre: ");
        //String nombre = scanner.next(); // next() lee hasta el primer espacio
        String nombreUser = scanner.nextLine(); // nextLine() lee toda la línea incluyendo espacios
        System.out.println("Su nombre es: " + nombreUser);

        //Ingreso de un decimal
        System.out.println("Ingrese su altura en metros (ej: 1.75): ");
        double altura = scanner.nextDouble();
        System.out.println("Su altura es: " + altura + " metros");
        //Ingreso de un caracter
        System.out.println("Ingrese la inicial de su nombre: ");
        char inicial = scanner.next().charAt(0); // lee el primer caracter de la entrada
        System.out.println("La inicial de su nombre es: " + inicial);
        //Ingreso de un booleano
        System.out.println("¿Es usted estudiante? (true/false): ");
        boolean esEstudiante = scanner.nextBoolean();
        System.out.println("¿Es usted estudiante? " + esEstudiante);

        // Cerramos el scanner para liberar recursos
        scanner.close();

        // VARIABLES PRIMITIVAS EN JAVA
        // Tipos de datos primitivos en Java
        int numeroEntero = 10; // Entero
        double numeroDecimal = 10.5; // Decimal
        char caracter = 'A'; // Caracter
        boolean esVerdadero = true; // Booleano
        // Imprimimos las variables
        System.out.println("Número Entero: " + numeroEntero);
        System.out.println("Número Decimal: " + numeroDecimal);
        System.out.println("Caracter: " + caracter);
        System.out.println("Es Verdadero: " + esVerdadero);

        // Diferencias entre tipos de datos primitivos y sus clases envolventes (Wrapper Classes)
        // Tipos primitivos: int, double, char, boolean
        // Clases envolventes: Integer, Double, Character, Boolean
        // Las clases envolventes permiten trabajar con objetos y ofrecen métodos útiles
        // Diferencias:
        // Los tipos primitivos son más eficientes en términos de memoria y rendimiento.
        // Las clases envolventes permiten trabajar con objetos y ofrecen métodos útiles.
        // Las clases envolventes pueden ser nulas, mientras que los tipos primitivos no.
        // Las clases envolventes son necesarias para trabajar con colecciones (por ejemplo, ArrayList).
        // En general, se recomienda usar tipos primitivos cuando no se necesita la funcionalidad adicional de las clases envolventes.
        // int vs Integer   
        int primitivo = 5; // Tipo primitivo
        Integer envolvente = 5; // Clase envolvente
        // Autoboxing: conversión automática de tipo primitivo a clase envolvente
        Integer autoboxing = primitivo; // int a Integer
        // Unboxing: conversión automática de clase envolvente a tipo primitivo
        int unboxing = envolvente; // Integer a int 
        // Imprimimos las variables
        System.out.println("Primitivo: " + primitivo);
        System.out.println("Envolvente: " + envolvente);
        System.out.println("Autoboxing: " + autoboxing);
        System.out.println("Unboxing: " + unboxing);
        //double vs Double
        double primitivoD = 10.5; // Tipo primitivo
        Double envolventeD = 10.5; // Clase envolvente
        // Autoboxing: conversión automática de tipo primitivo a clase envolvente
        Double autoboxingD = primitivoD; // double a Double
        // Unboxing: conversión automática de clase envolvente a tipo primitivo
        double unboxingD = envolventeD; // Double a double
        //char vs Character
        char primitivoC = 'A'; // Tipo primitivo
        Character envolventeC = 'A'; // Clase envolvente
        // Autoboxing: conversión automática de tipo primitivo a clase envolvente
        Character autoboxingC = primitivoC; // char a Character
        // Unboxing: conversión automática de clase envolvente a tipo primitivo
        char unboxingC = envolventeC; // Character a char
        //boolean vs Boolean
        boolean primitivoB = true; // Tipo primitivo
        Boolean envolventeB = true; // Clase envolvente
        // Autoboxing: conversión automática de tipo primitivo a clase envolvente
        Boolean autoboxingB = primitivoB; // boolean a Boolean
        // Unboxing: conversión automática de clase envolvente a tipo primitivo
        boolean unboxingB = envolventeB; // Boolean a boolean

        // algunos métodos de wrapper classes
        // Integer
        int maxInt = Integer.MAX_VALUE; // Valor máximo de un int
        int minInt = Integer.MIN_VALUE; // Valor mínimo de un int
        String intToString = Integer.toString(100); // Convierte int a String
        int stringToInt = Integer.parseInt("100"); // Convierte String a int
        // Double
        double maxDouble = Double.MAX_VALUE; // Valor máximo de un double
        double minDouble = Double.MIN_VALUE; // Valor mínimo de un double
        String doubleToString = Double.toString(10.5); // Convierte double a String
        double stringToDouble = Double.parseDouble("10.5"); // Convierte String a double
        // Character
        char charValue = Character.toUpperCase('a'); // Convierte a mayúscula
        boolean isDigit = Character.isDigit('5'); // Verifica si es dígito
        boolean isLetter = Character.isLetter('A'); // Verifica si es letra
        // Boolean
        boolean booleanValue = Boolean.parseBoolean("true"); // Convierte String a boolean
        String booleanToString = Boolean.toString(true); // Convierte boolean a String
        // Imprimimos los métodos de las clases envolventes
        System.out.println("Integer Max: " + maxInt);
        System.out.println("Integer Min: " + minInt);
        System.out.println("Int to String: " + intToString);
        System.out.println("String to Int: " + stringToInt);
        System.out.println("Double Max: " + maxDouble);
        System.out.println("Double Min: " + minDouble);
        System.out.println("Double to String: " + doubleToString);
        System.out.println("String to Double: " + stringToDouble);
        System.out.println("Character to Upper Case: " + charValue);
        System.out.println("Is Digit: " + isDigit);
        System.out.println("Is Letter: " + isLetter);
        System.out.println("String to Boolean: " + booleanValue);
        System.out.println("Boolean to String: " + booleanToString);

        // STRINGS EN JAVA, explicacion de  == y equals()
        // Los Strings en Java son objetos inmutables que representan secuencias de caracteres.

        // VAMOS CON CUATRO CASOS PARA ENTENDER COMO MANEJA LA MEMORIA JAVA CON STRINGS
        //IMPORTANTE:
        /*
         * Literales
         * Cuando escribís directamente un literal:
         * String a = "Hola";
         * El texto "Hola" se guarda automáticamente en el String Pool (una zona especial dentro de la memoria heap  y se le asigna una referencia en memoria).
         * Si ya existía "Hola" en el pool, Java reutiliza el mismo objeto, es decir no crea un nuevo objeto,
           sino que tengo dos variables apuntando al mismo objeto en memoria.
         * Si no existía ese String Literal en la memoria, lo agrega al pool, es decir crea un nuevo objeto en memoria.
         * Por eso dos literales iguales siempre apuntan al mismo objeto.
        */
        // CASO 1:
        /*Aquí declaramos una variable llamada nombre de tipo String y le asignamos el valor "Gabriel".
          En Java, las cadenas (String) SON OBJETOS INMUTABLES, pero hay un detalle importante: los literales de cadenas se almacenan en el String Pool (una zona especial de memoria).En este caso, "Gabriel" se guarda en ese pool de strings.*/
        String nombre = "Gabriel";
        /*Aquí declaramos una variable llamada otroNombre de tipo String y le asignamos el valor "Gabriel".
         Como ese literal ya existe en el String Pool, Java no crea un nuevo objeto, sino que reutiliza el mismo.
         Resultado:
         nombre y otroNombre apuntan al mismo objeto en memoria.
        */
        String otroNombre = "Gabriel";
        // Con el comparador de igualdad (==) comparamos las referencias en memoria de ambos objetos.
        // Como ambos apuntan al mismo objeto, la comparación devuelve true.
        // Con el método equals() comparamos el contenido de las cadenas.
        // Como ambas cadenas tienen el mismo contenido, la comparación también devuelve true.

        System.out.println(nombre == otroNombre); // true
        System.out.println(nombre.equals(otroNombre)); // true

        // CASO 2:
        String nombre2 = "Gisele";
        String otroNombre2 = "Carla";
        /* aqui se asignan dentro del String Pool estos dos literales, pero a cada uno se le reserva un espacio de la memoria distinto ya que el contenido no es igual
         * Resultado:
         * nombre2 y otroNombre2 apuntan a objetos diferentes en memoria. entonces == devuelve false
         * y equals tambien devuelve false porque el contenido es diferente
         */
        System.out.println(nombre2 == otroNombre2); // false
        System.out.println(nombre2.equals(otroNombre2)); // false

        // CASO 3:
        String nombre3 = new String("Mariana");
        String otroNombre3 = new String("Mariana");
        /* Aquí usamos el operador new para crear dos nuevos objetos String en memoria, ambos con el contenido "Mariana".
         *Se crean dos nuevos objetos en el heap, fuera del pool.
         * Aunque el contenido es el mismo, cada llamada a new crea un objeto distinto en memoria.
         * Resultado:
         * nombre3 y otroNombre3 apuntan a objetos diferentes en memoria. entonces == devuelve false
         * pero equals devuelve true porque el contenido es igual
         * Si querés que un String creado con new se guarde o reutilice en el String Pool, usás el método .intern():
         */
        //CASO:
        // LOS STRING SON INMUTABLES, ES DECIR QUE NO PUEDEN CAMBIAR SU CONTENIDO. 
        String nombreUno = "Gabriel";
        String nombreDos = "Gabriel";

        System.out.println(nombreUno == nombreDos); // true
            
        //aca vemos como si le "estamos cambiando el contenido a nombreDos" pero en realidad lo que sucede es que como Juan no existe en el String Pool, se crea un nuevo objeto en memoria y nombreDos ahora apunta a ese nuevo objeto, si Juan ya existiera en el String Pool, nombreDos pasaria a apuntar a ese objeto ya existente en el String Pool.
        //
        nombreDos = "Juan"; // nombreDos ahora apunta a otro objeto

        System.out.println(nombreUno == nombreDos); // false
        System.out.println(nombreUno); // Gabriel
        System.out.println(nombreDos); // Juan

              
        
        // Operadores de comparación
        // > mayor que
        // < menor que
        // >= mayor o igual que
        // <= menor o igual que
        // == igual que
        // != diferente que

        // Operadores lógicos
        // && (AND)
        // || (OR)
        // ! (NOT)

        //Condicionales and
        // v && v = v
        // v && f = f
        // f && v = f
        // f && f = f
        //Condicionales or
        // v || v = v
        // v || f = v
        // f || v = v
        // f || f = f
        // Condicionales not
        // !v = f
        // !f = v

        // Verificamos si el usuario es mayor de edad
        if ( edad >= 18 ){ // si es mayor o igual a 18 entra al bloque y muestro que puede ingresar al sistema
            System.out.println("Puede ingresar al sistema");
        } else {// sino, entra al bloque else y muestro que no puede ingresar al sistema
            System.out.println("No puede ingresar al sistema");
        }

        // COMO VALIDAR LOS DATOS QUE SE INGRESAN CON SCANNER
        // Validamos que la edad ingresada sea un número positivo
        if (edad < 0) {
            System.out.println("La edad no puede ser negativa.");
        } else if (edad < 18) {
            System.out.println("Eres menor de edad.");
        } else {
            System.out.println("Eres mayor de edad.");
            // Aquí puedes agregar más lógica si es necesario
        }
        // Si el usuario ingresa un valor no numérico, el programa lanzará una excepción InputMismatchException.
        // Para manejar esto, podríamos usar un bloque try-catch (no implementado aquí para mantenerlo simple).
        
    }
}



