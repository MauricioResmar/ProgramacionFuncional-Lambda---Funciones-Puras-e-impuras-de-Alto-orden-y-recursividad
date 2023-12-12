package FuncionesAltoOrden;
import java.util.function.Function;
public class FuncionAltoOrdenLambda {

    /**
     * Las siguientes funciones de orden superior retornan mediante lambds tanto un String como un Integer
     * @return
     * @author Mauricio Restrepo Marín
     */
    //Function Lambda o de orden superior la cual devuelve otra función
    private Function<String, String> toMayus = (x) -> x.toUpperCase();
    private Function<Integer, Integer> sumador = (x) -> x.sum(x, x);

    public void pruebas (){
        System.out.println(toMayus.apply("Mauri"));
        System.out.println(sumador.apply(5));

        saluda(toMayus, "Mauro");
    }

    public void saluda(Function<String, String> mifuncion, String nombre){
        mifuncion.apply(nombre);
    }
}
