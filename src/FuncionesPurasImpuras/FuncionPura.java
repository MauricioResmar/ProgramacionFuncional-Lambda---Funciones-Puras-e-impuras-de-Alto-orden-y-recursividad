package FuncionesPurasImpuras;
/* Como primer concepto de función pura, esta cumple un requisito, siempre va a devolver
*  el mismo valor cuando sus parámetros de entrada no varían. Además no tiene efectos colaterales
*  como modificar una variable no local es decir perteneciente a la clase más no a la función
*/

/* Además para que nuestra función sea pura, tiene que hacer completamente lo que dice,
* si nuestra función dice que suma, lo único que tiene que hacer es sumar.
*/


public class FuncionPura {

    public static void main(String[] args) {
       int result = suma(1,2);
       int result2 = suma(1,2);
       System.out.println(result + " " + result2);
    }
    public static int suma (int a, int b){
        return a + b;
    }
}
