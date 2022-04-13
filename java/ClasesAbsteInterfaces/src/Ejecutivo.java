import Transacciones.*;

public class Ejecutivo {

    String nombre;

    public Ejecutivo(String nombre) {
        this.nombre = nombre;
    }

    public String relizarConsulta(){
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.validacion("Ejecutivo");
        return "";
    }

    public String realizarPagoDeServicio(){
        PagoDeServicios pago = new PagoDeServicios();
        pago.validacion("Ejecutivo");
        return "";
    }

    public String realizarRetiroEfectivo(){
        RetiroEnEfectivo retiro = new RetiroEnEfectivo();
        retiro.validacion("Ejecutivo");
        return "";
    }

    public String relizarDeposito(){
        Deposito deposito = new Deposito();
        deposito.validacion("Ejecutivo");
        return "";
    }

    public String realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        transferencia.validacion("Ejecutivo");
        return "";
    }
}
