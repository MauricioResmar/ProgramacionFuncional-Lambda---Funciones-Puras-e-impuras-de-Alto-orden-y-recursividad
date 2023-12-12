package FuncionesPurasImpuras;
// Consideramos la siguiente función como impura debido a qué ante la entrada de los mismos parámetros,
// ésta siempre devolveria valores aleatorios modificando ademas variables globales es decir qué
// tiene efectos colaterales, así mismo es impura ya que no se limita a hacer lo que dice que hace
// sino que también invoca otra función.

public class FuncionImpura {
    private static int contador = 0;

    public static void main(String[] args) {
        double result = suma(1,2);
        double result2 = suma(1,2);
        System.out.println(result + " " + result2);
        multiplica(1,3);
        System.out.println(contador);
    }
    public static double suma (int a, int b){
        double sumador = Math.random();
        return a + b + sumador;
    }
    public static int multiplica (int a, int b){
        return a * b;
    }
}