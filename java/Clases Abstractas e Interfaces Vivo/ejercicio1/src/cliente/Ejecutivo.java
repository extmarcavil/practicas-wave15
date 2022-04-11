package cliente;

import interfaces.*;
import main.RealizarTransaccion;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    public Ejecutivo(String nombre) {
        super(nombre);
    }


    @Override
    public void depositoEfectivo() {
        RealizarTransaccion.ApplyTransaction("Deposito");
    }

    @Override
    public void transferencia() {
        RealizarTransaccion.ApplyTransaction("Transferencia");
    }
}
