public class Basic extends Cliente implements ConsSaldo, PagoServicio, RetEfectivo{
    @Override
    public double consSaldo() {
        return 0;
    }

    @Override
    public double pagServicio() {
        return 0;
    }

    @Override
    public double retEfect(double monto) {
        return 0;
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
