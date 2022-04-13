package ejercicioBanco;

/*Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre ellas se encuentran:
Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo, Pago de Servicios.
Todas las transacciones tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().

A partir de esto existen diferentes tipos de clientes que pueden interactuar con el banco:
Ejecutivos: Realizan Depósitos y Transferencias.
Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
Cobradores: Realizan retiro de efectivo y consulta de saldos.

Implementar el escenario según corresponda para permitir a los clientes mencionados con anterioridad,
el acceso a los diferentes métodos según la operación que deseen realizar.

Notas a tener en cuenta:
No es necesario implementar cálculos o funciones matemáticas. Los métodos pueden ser implementaciones de mensajes
mediante System.out.println. Por ejemplo, al hacer un depósito, que aparezca el mensaje “Realizándose depósito”.
Basic, Cobrador y Ejecutivos pueden ser tratados como clases.
Transacción puede ser tratada como una Interfaz. Tener en cuenta que existen diferentes tipos de transacciones que
implementarán esta interfaz principal.*/

public class EjercicioBanco {

    public static void main(String[] args) {
        //Test cliente basic
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        PagoServicio pagoServicio = new PagoServicio();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        Cliente basic = new Basic(consultaSaldo, pagoServicio, retiroEfectivo);
        basic.ejecutarTransaccion();

        //Test cliente ejecutivo
        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        Cliente ejecutivo = new Ejecutivo(deposito, transferencia);
        ejecutivo.ejecutarTransaccion();

        //Test client cobrador
        Cliente cobrador = new Cobrador(retiroEfectivo, consultaSaldo);
        cobrador.ejecutarTransaccion();
    }
}
