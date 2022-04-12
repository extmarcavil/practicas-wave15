package ejercicio1;

public class Main {

    public static void main(String[] args) {

        ClienteEjecutivo unClienteEjecutivoConDatosFalsos = new ClienteEjecutivo(false);
        ClienteEjecutivo unClienteEjecutivoConDatosVerdaderos= new ClienteEjecutivo(true);

        ClienteCobrador unClienteCobradorConDatosFalsos = new ClienteCobrador(false);
        ClienteCobrador unClienteCobradorConDatosVerdaderos = new ClienteCobrador(true);

        ClienteBasico unClienteBasicoConDatosFalsos = new ClienteBasico(false);
        ClienteBasico unClienteBasicoConDatosVerdaderos = new ClienteBasico(true);

        System.out.println("1 - Prueba Cliente Ejecutivo con datos falsos no puede depositar ");
        unClienteEjecutivoConDatosFalsos.realizarDeposito();
        System.out.println("2 - Prueba Cliente Ejecutivo con datos verdaderos puede depositar ");
        unClienteEjecutivoConDatosVerdaderos.realizarDeposito();
        System.out.println("3 - Prueba Cliente Ejecutivo con datos falsos no puede transferir ");
        unClienteEjecutivoConDatosFalsos.realizarTransferencia();
        System.out.println("4 - Prueba Cliente Ejecutivo con datos verdaderos puede transferir ");
        unClienteEjecutivoConDatosVerdaderos.realizarTransferencia();

        System.out.println("5 - Prueba Cliente Basico con datos falsos no puede consultar saldo ");
        unClienteBasicoConDatosFalsos.realizarConsultaDeSaldo();
        System.out.println("6 - Prueba Cliente Basico con datos verdaderos puede consultar saldo ");
        unClienteBasicoConDatosVerdaderos.realizarConsultaDeSaldo();

        System.out.println("7 - Prueba Cliente Cobrador con datos falsos no puede consultar saldo ");
        unClienteCobradorConDatosFalsos.realizarConsultaDeSaldo();
        System.out.println("8 - Prueba Cliente Cobrador con datos verdaderos puede consultar saldo ");
        unClienteCobradorConDatosVerdaderos.realizarConsultaDeSaldo();







    }
}
