package Ejercicio1;

public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo{
    @Override
    public void realizarConsultaDeSaldo() {
        System.out.println("Tu sueldo es XXXXXX");
    }

    @Override
    public void realizarRetiroDeEfectivo(int monto) {
        System.out.println("Retiraste " + monto);
    }

    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
