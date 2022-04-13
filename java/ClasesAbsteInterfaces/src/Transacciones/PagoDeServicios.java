package Transacciones;

public class PagoDeServicios implements Transaccion{

    public void validacion(String tipo){
        if(!tipo.equals("Basic")){
            transaccionNoOk();
        }
        else{
            transaccionOk();
        }
    }

    @Override
    public String transaccionOk() {
        System.out.println("Realizando el pago...");
        return null;
    }

    @Override
    public String transaccionNoOk() {
        System.out.println("Error al realizar el pago...");
        return null;
    }
}
