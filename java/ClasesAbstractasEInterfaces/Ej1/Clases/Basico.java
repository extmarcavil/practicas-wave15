package ClasesAbstractasEInterfaces.Ej1.Clases;

import ClasesAbstractasEInterfaces.Ej1.Interfaces.ConsultaSaldo;
import ClasesAbstractasEInterfaces.Ej1.Interfaces.PagoServicios;
import ClasesAbstractasEInterfaces.Ej1.Interfaces.RetiroEfectivo;

public class Basico implements ConsultaSaldo, PagoServicios, RetiroEfectivo {

    @Override
    public void saldo() {
        System.out.println("Consulta de Saldo Cliente....");
    }

    @Override
    public void pago() {
        System.out.println("Pago de Servicio....");
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
