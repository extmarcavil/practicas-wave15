package cliente;

import interfaces.Consulta;
import interfaces.Retiro;
import main.RealizarTransaccion;

public class Cobrador extends Cliente implements Retiro, Consulta {

    public Cobrador(String nombre) {
        super(nombre);
    }


    @Override
    public void consulta() {
        RealizarTransaccion.ApplyTransaction("Consulta");
    }

    @Override
    public void retiroEfectivo() {
        RealizarTransaccion.ApplyTransaction("Retiro");
    }
}
