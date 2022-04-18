package ejercicio;

public abstract class SeriePrototipo<T> {

    protected T valorActual;
    protected T valorInicialSerie;
    protected T factorDeIncremento;

    // Se desea crear al menos 2 clases que extiendan de una clase prototipo,
    // que genera un valor en función, a una serie progresiva.
    // La clase prototipo contendrá tres métodos. El primero de los métodos
    // es el encargado de devolver un número que corresponderá al valor
    // siguiente a la serie progresiva. Otro método para reiniciar la serie,
    // y un último que recibirá un valor que servirá para establecer el valor
    // inicial de la serie. Las clases deben estar preparadas para recibir
    // cualquier tipo de dato numérico no primitivo.


    protected SeriePrototipo(T valorInicial,T factorDeIncremento) {
        this.valorInicialSerie = valorInicial;
        this.factorDeIncremento = factorDeIncremento;
        this.valorActual = valorInicialSerie;
    }

    public abstract T obtenerProximoNumero();

    public void reiniciarSerie() {
        valorActual = valorInicialSerie ;
    }

    public void definirValorInicial(T valorInicial){
        this.valorInicialSerie = valorInicial;
        this.valorActual = valorInicialSerie;
    }



}
