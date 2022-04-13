package AbstractasInterfaces.Ejercicio1;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {

    private double saldo = 3000;

    @Override
    public void saldo() {
        System.out.println("Usted tiene $" + saldo + " en cuenta");
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
