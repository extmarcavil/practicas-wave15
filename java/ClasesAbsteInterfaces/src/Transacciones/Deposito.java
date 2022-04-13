package Transacciones;

public class Deposito implements Transaccion{

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
        System.out.println("Realizando el depósito...");
        return null;
    }

    @Override
    public String transaccionNoOk() {
        System.out.println("Fallo al realizar el depósito");
        return null;
    }
}
