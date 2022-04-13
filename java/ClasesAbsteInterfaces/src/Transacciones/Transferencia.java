package Transacciones;

public class Transferencia implements Transaccion{

    public void validacion(String tipo){
        if(!tipo.equals("Ejecutivo")){
            transaccionNoOk();
        }
        else{
            transaccionOk();
        }
    }

    @Override
    public String transaccionOk() {
        System.out.println("Realizando la transferencia...");
        return null;
    }

    @Override
    public String transaccionNoOk() {
        System.out.println("Fallo al realizar la transferencia");
        return null;
    }
}
