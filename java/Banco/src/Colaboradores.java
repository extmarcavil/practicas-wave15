public class Colaboradores implements  TipoMovimiento2,Transaccion {
    @Override
    public void ConsultaDeSaldo() {
        this.TransaccionOk("Consulta de saldo");
    }

    @Override
    public void RetiroEfectivo() {
        this.TransaccionOk("Retiro de efectivo");
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
