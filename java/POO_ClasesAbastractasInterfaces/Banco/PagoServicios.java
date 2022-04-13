package POO_ClasesAbastractasInterfaces.Banco;

public class PagoServicios implements Transaction{

    @Override
    public void transactionOk() {
        System.out.println("Se hizo el pago de servicios");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se hizo el pago de servicios");
    }
}
