import Transacciones.*;

public class Basic {

    String nombre;

    public Basic(String nombre) {
        this.nombre = nombre;
    }


    public String relizarConsulta(){
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.validacion("Basic");
        return "";
    }

    public String realizarPagoDeServicio(){
        PagoDeServicios pago = new PagoDeServicios();
        pago.validacion("Basic");
        return "";
    }

    public String realizarRetiroEfectivo(){
        RetiroEnEfectivo retiro = new RetiroEnEfectivo();
        retiro.validacion("Basic");
        return "";
    }

    public String relizarDeposito(){
        Deposito deposito = new Deposito();
        deposito.validacion("Basic");
        return "";
    }

    public String realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        transferencia.validacion("Basic");
        return "";
    }
}
