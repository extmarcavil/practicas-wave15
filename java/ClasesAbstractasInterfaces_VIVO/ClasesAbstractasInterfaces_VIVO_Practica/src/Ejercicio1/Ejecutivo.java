package Ejercicio1;

//Ejecutivos: Realizan Depósitos y Transferencias.
public class Ejecutivo extends User implements Deposito, Transferencia {

    @Override
    public void depositar() {
        System.out.println("Depositando");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO exitosa");
    }

    @Override
    public void transferir() {
        System.out.println("Transfiriendo");
    }
}
