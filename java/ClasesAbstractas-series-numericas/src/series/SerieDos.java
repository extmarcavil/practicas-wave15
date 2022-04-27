package series;

public class SerieDos extends Prototipo{

    public SerieDos(Integer valorInicial) {
        super.asignarValorInicial(valorInicial);
    }

    @Override
    public Number devolverSiguiente() {
        Number ultimo = super.devolverUltimo();
        Integer siguiente = Integer.sum(Integer.parseInt(ultimo.toString()), 2);
        super.insertarValor(siguiente);
        return siguiente;
    }
}
