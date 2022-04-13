import Transacciones.*;

public class Cobrador {

    String nombre;

    public Cobrador(String nombre) {
        this.nombre = nombre;
    }


    public String relizarConsulta(){
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.validacion("Cobrador");
        return "";
    }

    public String realizarPagoDeServicio(){
        PagoDeServicios pago = new PagoDeServicios();
        pago.validacion("Cobrador");
        return "";
    }

    public String realizarRetiroEfectivo(){
        RetiroEnEfectivo retiro = new RetiroEnEfectivo();
        retiro.validacion("Cobrador");
        return "";
    }

    public String relizarDeposito(){
        Deposito deposito = new Deposito();
        deposito.validacion("Cobrador");
        return "";
    }

    public String realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        transferencia.validacion("Cobrador");
        return "";
    }
}
