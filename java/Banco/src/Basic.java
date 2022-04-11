public class Basic implements TipoMovimiento3,TipoMovimiento2,Transaccion {

    @Override
    public void ConsultaDeSaldo() {
        this.TransaccionOk("Consulta de saldo");
    }

    @Override
    public void RetiroEfectivo() {
        this.TransaccionOk("Retiro de efectivo");
    }

    @Override
    public void PagoServicios() {
        this.TransaccionOk("Pago de Servicios");
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
