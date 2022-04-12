import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


/*
    Se desea crear al menos 2 clases que extiendan de una clase prototipo, que genera un valor en función, a una serie progresiva.
    La clase prototipo contendrá tres métodos. El primero de los métodos es el encargado de devolver un número que corresponderá al
    valor siguiente a la serie progresiva. Otro método para reiniciar la serie, y un último que recibirá un valor que servirá para
    establecer el valor inicial de la serie. Las clases deben estar preparadas para recibir cualquier tipo de dato numérico no primitivo.
    Escenarios:
    Si se crea una serie de 2 cada vez que se llame el método valor siguiente devolverá:
    Primera vez 2
    Segunda vez 4
    Tercera vez 6
    Cuarta vez 8
    Así sucesivamente cada vez que se llama al método.
    Si por ejemplo se emplea el método para establecer un valor inicial 1, cada vez que se llame al método el valor siguiente devolverá:
    Primera vez 3
    Segunda vez 5
    Tercera vez 7
    Cuarta vez 9
    Así sucesivamente cada vez que se llama al método.
    De igual forma si es una serie de 3, cada vez que se llame al método el valor siguiente devolverá:
    Primera vez 3
    Segunda vez 6
    Tercera vez 9
    Cuarta vez 12
    Así sucesivamente cada vez que se llama al método.
*/
//{2, 4, }

    public static void main(String[] args) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        imprimir(2, list);
        imprimir(2, list);

    }

    public static int imprimir(int valorInicial,List<Integer> lista){
        int suma = 0;
        lista.add(valorInicial);
        System.out.println(valorInicial);
        suma = valorInicial * valorInicial;
        lista.add(suma);
        int valorFinal = valorInicial * valorInicial;
        return valorFinal;
    }
}
