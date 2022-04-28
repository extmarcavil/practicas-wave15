package abstractasInterfaces.ejercicio1.Client;

import abstractasInterfaces.ejercicio1.Transaction.Impl.Deposit;
import abstractasInterfaces.ejercicio1.Transaction.Transaction;
import abstractasInterfaces.ejercicio1.Transaction.Impl.Transfer;

public class Ejecutive {

    private Transaction depositoService;
    private Transaction transferenciaService;

    public Ejecutive() {
        this.depositoService = new Deposit();
        this.transferenciaService = new Transfer();
    }

    public Transaction getDepositoService() {
        return depositoService;
    }

    public void setDepositoService(Transaction depositoService) {
        this.depositoService = depositoService;
    }

    public Transaction getTransferenciaService() {
        return transferenciaService;
    }

    public void setTransferenciaService(Transaction transferenciaService) {
        this.transferenciaService = transferenciaService;
    }
}
