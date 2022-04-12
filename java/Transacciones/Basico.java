package Transacciones;

public class Basico implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void pagarServicios(String servicio) {
        System.out.println("Pagando servicios...");
    }

    @Override
    public void retirarEfectivo(double monto) {
        System.out.println("Retirando efectivo...");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println(tipo + " relizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("La transacción " + tipo + " no pudo ser realizada");
    }
}
