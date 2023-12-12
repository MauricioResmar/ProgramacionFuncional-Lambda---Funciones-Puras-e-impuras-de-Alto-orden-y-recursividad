package Recursion;

import java.util.stream.IntStream;

public class funcionRecursividad {
    public static void main(String[] args) {

        // suma(5); 1 + 2 + 3 + 4 + 5 => 15
        System.out.println(suma(5));
        sumaRecursiva(5);

        tailRecursion(5);
        headRecursion(5);

        System.out.println("Suma iterativa: " + suma(5));
        System.out.println("Suma recursiva: " + sumaRecursiva(5));
        System.out.println("Suma funcional: " + sumaFuncional(5));

        System.out.println("\nFactorial iterativa: " + factorial(5));
        System.out.println("Factorialrecursiva: " + factorialRecursivo(5));
        System.out.println("Factorial funcional: " + factorialFuncional(5));

        // Medimos el tiempo de ejecución de nuestra función mediante el metodo System.currentTimeMillis();
        long tiempoInicial = System.currentTimeMillis();
        System.out.println("\nBenchmark usando metodo System.currentTimeMillis(): ");
        for (int i = 0; i <= 1000000; i ++) {
            sumaFuncional(100);
        }
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Ms en total: " + (tiempoFinal - tiempoInicial));
    }

    //Función iterativa suma()
    public static int suma(int max) {
        int resultado = 0;

       for(int i = 0; i <= max; i ++ ) {
           resultado = resultado + i;   
       }
       return resultado;
    }

    // Función recursiva sumaRecursiva()

    //   -> 5
    //   -> 5 - 1
    //    -> 4 - 1
    //     -> 3 - 1
    //      -> 2 - 1
    //       -> 1 - 1
    //        -> 0 - 1
    //         -> -1 - 1
    //  **la función se invoca así misma, y cada vez que lo hace se decrementa el número
    //              hasta que se cumpla la setencia retornando hasta 5 nuevamente.
    // sumaRecursiva(5)
    //  sumaRecursiva(4) // 5-1
    //   sumaRecursiva(3) // 4-1
    //    sumaRecursiva(4) // 3-1
    //     sumaRecursiva(3) // 2-1
    //      sumaRecursiva(2) // 1-1
    //       sumaRecursiva(1) // 0-1
    //        sumaRecursiva(0) // -1 -1
    public static int sumaRecursiva(int numero) {
        if (numero == 1) {
            return 1;
        }
        return numero + sumaRecursiva(numero - 1);
    }

    //Tail Recursión o recursividad de cola : cuando la función recursiva se llama a sí misma al final

    public static void tailRecursion(int valor) {
        System.out.println("\nTail Recursion o recursividad de cola: \n");
        if (valor == 0 ) {
            return;
        }
        System.out.println(valor);
        tailRecursion(valor - 1);
    }

    //Head Recursion o recursividad de encabezado : en éste caso la función recursiva se invoca a sí misma l valor y posteriormente muestra o imprime el valor:

    public static void headRecursion(int valor) {
        System.out.println("\nHead Recursion o recursividad de encabezado: \n");
        if (valor == 0) {
            return;
        }
        headRecursion(valor - 1);
        System.out.println(valor);
    }

    //Recursion Funcional : Y por supuesto, la función puede implementarse con sentencias funcionales o programación declarativa .map(x->); .filter(x->); .reduce(x->);

    public static int sumaFuncional(int numero) {
        // suma(5); 1 + 2 + 3 + 4 + 5 => 15
        return IntStream.rangeClosed(1, 5).reduce(0, (a, b) -> a + b);
    }

    //Vamos a implementar el factorial de un número utilizando una función iterativa una recursiva y una funcional:

    //Función iterativa factorial:

    public static int factorial(int numero) {
        int resultado = 1;

        for (int i = 1; i <= numero; i++) {
            resultado = resultado * i;
        }
        return  resultado;
    }

    //Función recursiva factorial:

    public static int factorialRecursivo(int numero){
        if (numero == 0){
            return 1;
        }
        return numero * factorialRecursivo(numero - 1);
    }

    //Versión funcional o recursividad funcional:

    public static int factorialFuncional(int numero){
        return IntStream.rangeClosed(1, numero)
                .reduce(1,(a, b) -> a * b);
    }
}
