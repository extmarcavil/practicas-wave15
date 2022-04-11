package cliente;

import interfaces.Consulta;
import interfaces.PagoServicio;
import interfaces.Retiro;
import main.RealizarTransaccion;

public class Basic extends Cliente implements Consulta, PagoServicio, Retiro {

    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void consulta() {
        RealizarTransaccion.ApplyTransaction("Consulta");
    }

    @Override
    public void pagoServicio() {
        RealizarTransaccion.ApplyTransaction("Pago");
    }

    @Override
    public void retiroEfectivo() {
        RealizarTransaccion.ApplyTransaction("Retiro");
    }

}
