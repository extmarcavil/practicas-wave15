public class Ejecutivos implements  TipoMovimiento1,Transaccion {
    @Override
    public void Deposito() {
        this.TransaccionOk("Depoisto");
    }

    @Override
    public void Transferencia() {
        this.TransaccionOk("Transferencia");
    }

    @Override
    public void TransaccionOk(String Accion) {
        System.out.println("Se realizo la acciòn: " + Accion + " correctamente");
    }

    @Override
    public void TransaccionNoOk(String Accion) {
        System.out.println("No se realizo la acciòn: " + Accion);
    }
}
