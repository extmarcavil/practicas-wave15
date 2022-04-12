package principal;
/*Se desea crear al menos 2 clases que extiendan de una clase prototipo,
 que genera un valor en función, a una serie progresiva.
 La clase prototipo contendrá tres métodos.
 El primero de los métodos es el encargado de devolver un número que corresponderá al valor siguiente
  a la serie progresiva. Otro método para reiniciar la serie, y un último que recibirá un valor que servirá
  para establecer el valor inicial de la serie. Las clases deben estar preparadas para recibir cualquier tipo
   de dato numérico no primitivo.

*/
public abstract class Prototipo<T extends Number> {
   private T valorInicial;
   private T valorActual;
   private T progresion;

    public Prototipo () {
    }


    public void setProgresion(T prog) {
        this.progresion= prog;
    }

    public T getProgresion() {
        return progresion;
    }

    public void setValorInicial (T valor) {
        this.valorInicial=valor;
        this.valorActual= this.valorInicial;
    }

    public void reiniciar() {
        this.valorActual= this.valorInicial;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }
    public void setValorActual(T valorActual) {
        this.valorActual= valorActual;
    }

    public abstract T getValorSig();



}
