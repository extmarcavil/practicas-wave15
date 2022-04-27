package series;

public class SerieTres extends Prototipo{

    public SerieTres(Double valorInicial) {
        super.asignarValorInicial(valorInicial);
    }

    @Override
    public Number devolverSiguiente() {
        Number ultimo = super.devolverUltimo();
        Double siguiente = Double.sum(Double.parseDouble(ultimo.toString()), 3);
        super.insertarValor(siguiente);
        return siguiente;
    }
}
