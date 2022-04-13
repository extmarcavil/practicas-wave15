import Transacciones.Deposito;

public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");

        Cobrador persona = new Cobrador("Juan");    //Inserte Tipo: Cobrador, Ejecutivo o Basic.
                                                           //Inserte el nombre de la persona.

        System.out.println("Usuario: " + persona.nombre);
        System.out.println(" ");
        String operacion = persona.relizarConsulta();                 //Inserte el tipo de operacion:
        System.out.println(operacion);                                      // relizarConsulta()
                                                                            // realizarPagoDeServicio()
        System.out.println("====================================");         // realizarRetiroEfectivo()
                                                                            // relizarDeposito()
                                                                            // realizarTransferencia()
    }
}
