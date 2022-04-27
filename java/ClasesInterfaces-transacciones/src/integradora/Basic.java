package integradora;

public class Basic extends TransaccionMinima implements Transaccion{

    public void pagoServicios() {
        System.out.println("Pagando servicios...");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Cliente Basic, transacción exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cliente Basic, transacción fallida.");
    }
}
