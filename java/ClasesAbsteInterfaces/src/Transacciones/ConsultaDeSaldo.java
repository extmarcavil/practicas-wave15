package Transacciones;

public class ConsultaDeSaldo implements Transaccion {

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
        System.out.println("Consultando datos...");
        return null;
    }

    @Override
    public String transaccionNoOk() {
        System.out.println("Error al consultar los datos...");
        return null;
    }
}
