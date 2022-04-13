package ClasesAbstractasEInterfaces.Ej1;

import ClasesAbstractasEInterfaces.Ej1.Clases.Basico;
import ClasesAbstractasEInterfaces.Ej1.Clases.Cobrador;
import ClasesAbstractasEInterfaces.Ej1.Clases.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basico.pago();
        basico.retirarEfectivo();
        basico.saldo();
        basico.transaccionError("Retiro de Efectivo");
        basico.transaccionOk("Pago de Servicio");

    }
}
