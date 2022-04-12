public class Cobrador extends Cliente implements ConsSaldo, RetEfectivo{

    @Override
    public double consSaldo() {
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
