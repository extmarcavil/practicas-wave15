package ejercico1.transacciones;

import ejercico1.clientes.Cliente;

public class ConsultaDeSaldo extends Transacciones{
    @Override
    public String transaccionOk() {
        return "Consulta de saldo realizada con exito";
    }

    @Override
    public String transaccionNoOk() {
        return "Esta categoria de cliente no puede realizar consulta de saldo";
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
                respuesta = transaccionOk();
                break;

            default:
                respuesta = "Error en la transaccion";
        }
        return respuesta;
    }
}
