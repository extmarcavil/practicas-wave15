package ejercico1.transacciones;

import ejercico1.clientes.Cliente;

public class Deposito extends Transacciones {


    @Override
    public String transaccionOk() {
        return "Deposito realizado con exito";
    }

    @Override
    public String transaccionNoOk() {
        return "Esta categoria de cliente no puede realizar Depositos";
    }

    public String ejecutar (Cliente cliente){

        String respuesta;

        switch (cliente.getTipo()){
            case "Ejecutivo":
               respuesta = transaccionOk();
                break;

            case "Basico":
                respuesta = transaccionNoOk();
                break;

            case "Cobradores":
                respuesta = transaccionNoOk();
                break;

            default:
                respuesta = "Error en la transaccion";
        }
        return respuesta;
    }
}
