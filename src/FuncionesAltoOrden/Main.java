package FuncionesAltoOrden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //FuncionAltoOrdenLambda f = new FuncionAltoOrdenLambda();
        // f.pruebas();

        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("SaraL");
        nombres.add("Paco");
        nombres.add("Pepe");

        //nombres.stream().forEach(x -> System.out.println(x));
        //Stream funcion lambda programación funcional
        Stream<String> valoresA = nombres.stream().map(x -> "Hola, " + x.toUpperCase());
        valoresA.forEach(x -> System.out.println(x));

        //Escribimos lo mismo con diferente distribución para mayor legibilidad:

        Stream<String> valoresB = nombres.stream()
                .map(x -> {
                    return  "Hola, " + x.toUpperCase();
                });

        valoresB.forEach(x -> System.out.println(x));

        //Otra forma:

        Stream<String> valoresC = nombres.stream()
                .map(x -> "Hola, " + x.toUpperCase());

        valoresC.forEach(x -> System.out.println(x));

        //Ahora vamos a agregarle otro filtro para que elimine los Stream que empiecen por "P":
        System.out.println("Metodo .filter: \n");
        Stream<String> valoresD = nombres.stream()
                .map(x -> x.toUpperCase())
                .filter(x -> x.startsWith("P"));

        valoresD.forEach(x -> System.out.println(x));

        //Convertimo array a stream e iteramos sobre sus valores
        System.out.println("\nMetodo Arrays.stream para convertir array a stream, iteramos e imprimimos solo los pares mediante .filter: \n");

        int [] numeros = {1,2,3,4,5,6,7,8,9,10};

        IntStream stNumeros = Arrays.stream(numeros);

        var resultado = stNumeros.filter(x -> x % 2 == 0);
        resultado.forEach(System.out::println);

        //Metodo .reduce();
        System.out.println("\nMetodo .reduce() mediante el cual sumaremos los valores pares dados por .filter \n");

        int [] numerosB = {1,2,3,4,5,6,7,8,9,10};

        IntStream sRNumeros = Arrays.stream(numerosB);

        var resultadoB = sRNumeros.filter(x -> x % 2 == 0).reduce(0, (x, y) -> {
            System.out.println("X es: " + x + " Y es: " + y);
            return x + y;
        });

        System.out.println("Mi suma de pares es: " + resultadoB);
        //resultadoB.forEach(System.out::println);

        //Metodo .map() .filter() .reduce();
        //Esta es la forma funcional de hacerlo, esto mismo lo hubiésemos podido hacer con varios ciclos for.

        System.out.println("\nMetodo .reduce() mediante el cual sumaremos los valores pares dados por .filter \n");

        int [] numerosC = {1,2,3,4,5,6,7,8,9,10};

        IntStream sYNumeros = Arrays.stream(numerosC);

        var resultadoC = sYNumeros
                .map(x -> x * 2)
                .filter(x -> x % 2 == 0)
                .reduce(0, (x, y) -> {
            System.out.println("X es: " + x + " Y es: " + y);
            return x + y; // Semejante a sumatotal += numero;
        });

        System.out.println("Mi suma de pares es: " + resultadoC);
        //resultadoB.forEach(System.out::println);

        /*
         Ahora rescribimos el mismo codigo usando sentencias de control if y ciclo for
         .filter es como tener un if() son dos formas de hacer exactamente lo mismo
         mediante forma imperativa Poo y forma declarativa "corta" o funcional
         4 lineas con programacion funcional y 8 lineas aprox con programación imperativa poo.
         De las dos formas obtenemos lo mismo pero de la primera forma lo procesamos de forma funcional
         o declarativa y de la segunda lo procesamos de forma imperativa:
        */

        int sumatotal = 0;   // Semejante a .reduce(0, (x, y) ->
        for (int numero : numeros){ //Semejante al stream o metodo como se recorren los valores, en programación funcional la salida de una función lambda es la entrada de la siguiente función
            numero = numero * 2; //Semejante al map que lo que hace es aplicar algo sobre cada elemento obtenido
            if (numero % 2 != 0){ // Semejante al .filter que lo que hace es eliminar valores
                continue;
            }
            sumatotal += numero; //Semejante al return o función que ejecuta el .reduce(identity:0, (x, y) -> x + y);
        }
        System.out.println("Mi suma de pares es: " + resultadoC + " y con for: " + sumatotal);
    }

    //Función o metodo convencional la cual devuelve una función:
    public static String toMayuscula(String nombre){
        return nombre.toUpperCase();
    }
}
