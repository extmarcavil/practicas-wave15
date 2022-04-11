package Ejercicio1;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo{
    @Override
    public void realizarConsultaDeSaldo() {
        System.out.println("No tenes plata, gracias, vuelva prontos");
    }

    @Override
    public void realizarPagoDeServicios(int monto, String servicio) {
        System.out.println("Pagaste " + monto + " al servicio " + servicio);
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
