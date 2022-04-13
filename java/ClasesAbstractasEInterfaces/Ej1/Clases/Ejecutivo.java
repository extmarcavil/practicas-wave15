package ClasesAbstractasEInterfaces.Ej1.Clases;

import ClasesAbstractasEInterfaces.Ej1.Interfaces.Deposito;
import ClasesAbstractasEInterfaces.Ej1.Interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void depositar() {
        System.out.println("Depositando.....");
    }

    @Override
    public void transferir() {
        System.out.println("Transfiriendo.....");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("La operacion " + tipoTransaccion + " se realizo correctamente");
    }

    @Override
    public void transaccionError(String tipoTransaccion) {
        System.out.println("La operacion " + tipoTransaccion + " fallo");
    }
}
