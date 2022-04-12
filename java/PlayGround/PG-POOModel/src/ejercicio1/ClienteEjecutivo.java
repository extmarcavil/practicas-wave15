package ejercicio1;

public class ClienteEjecutivo extends Cliente{

    public ClienteEjecutivo(boolean datosEnRegla) {
        super(datosEnRegla);
    }

    @Override
    public String nombre() {
        return "Cliente Ejecutivo";
    }

    public void realizarDeposito(){
       Deposito nuevoDeposito = new Deposito(this);
       nuevoDeposito.imprimirResultado();
    }

    public void realizarTransferencia() {
        Transferencia nuevaTransferencia = new Transferencia(this);
        nuevaTransferencia.imprimirResultado();
    }
}
