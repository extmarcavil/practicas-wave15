package Transacciones;

public class RetiroEnEfectivo implements Transaccion{

    public void validacion(String tipo){
        if(tipo.equals("Ejecutivo")){
            transaccionNoOk();
        }
        else{
            transaccionOk();
        }
    }

    @Override
    public String transaccionOk() {
        System.out.println("Realizando el retiro...");
        return null;
    }

    @Override
    public String transaccionNoOk() {
        System.out.println("Error al realizar el retiro...");
        return null;
    }
}
