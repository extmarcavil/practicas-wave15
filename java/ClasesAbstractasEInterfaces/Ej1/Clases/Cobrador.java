package ClasesAbstractasEInterfaces.Ej1.Clases;

import ClasesAbstractasEInterfaces.Ej1.Interfaces.ConsultaSaldo;
import ClasesAbstractasEInterfaces.Ej1.Interfaces.RetiroEfectivo;

public class Cobrador implements ConsultaSaldo, RetiroEfectivo {

    @Override
    public void saldo() {
        System.out.println("Consulta de Saldo Cobrador....");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retiro de Efectivo....");
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
