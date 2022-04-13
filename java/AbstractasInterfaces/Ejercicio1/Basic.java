package AbstractasInterfaces.Ejercicio1;

public class Basic implements  ConsultaSaldo, PagoServicio, RetiroEfectivo {

    private double saldo = 2000;

    @Override
    public void saldo() {
        System.out.println("Usted tiene $" + saldo + " en cuenta");
    }

    @Override
    public void pagarServicio(int numeroBoleta, double monto) {
        System.out.println("Pagando la boleta #" + numeroBoleta + " de importe $" + monto);
    }

    @Override
    public void extraer(double monto) {
        System.out.println("Extrayendo $" + monto);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción Realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar la transacción");
    }
}
