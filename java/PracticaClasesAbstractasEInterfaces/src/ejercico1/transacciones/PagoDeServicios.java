package ejercico1.transacciones;

import ejercico1.clientes.Cliente;

public class PagoDeServicios extends Transacciones{
    @Override
    public String transaccionOk() {
        return "Pago de servicios realizado con exito";
    }

    @Override
    public String transaccionNoOk() {
        return "Esta categoria de cliente no puede realizar pago de servicios";
    }

    public String ejecutar (Cliente cliente){

        String respuesta;

        switch (cliente.getTipo()){
            case "Ejecutivo":
                respuesta = transaccionNoOk();
                break;

            case "Basico":
                respuesta = transaccionOk();
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
