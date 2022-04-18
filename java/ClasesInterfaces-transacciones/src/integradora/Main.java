package integradora;

public class Main {

    public static void main(String[] args){
        Basic clienteBasic = new Basic();
        Cobrador clienteCobrador = new Cobrador();
        Ejecutivo clienteEjecutivo = new Ejecutivo();

        System.out.println("\n--Cliente Basic---\n");
        clienteBasic.consultaSaldo();
        clienteBasic.transaccionNoOk();
        clienteBasic.pagoServicios();
        clienteBasic.transaccionOK();
        clienteBasic.retiroEfectivo();

        System.out.println("\n--Cliente Cobrador---\n");
        clienteCobrador.retiroEfectivo();
        clienteCobrador.transaccionNoOk();
        clienteCobrador.consultaSaldo();
        clienteCobrador.transaccionOK();

        System.out.println("\n--Cliente Ejecutivo---\n");
        clienteEjecutivo.deposito();
        clienteEjecutivo.transaccionOK();
        clienteEjecutivo.transferencia();
        clienteEjecutivo.transaccionNoOk();
    }
}
