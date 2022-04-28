package abstractasInterfaces.ejercicio1.Client;

import abstractasInterfaces.ejercicio1.Transaction.Impl.CashWithdrawal;
import abstractasInterfaces.ejercicio1.Transaction.Impl.CheckBalance;
import abstractasInterfaces.ejercicio1.Transaction.Transaction;

public class Collector {

    private Transaction cashWithdrawalService;
    private Transaction checkBalanceService;

    public Collector() {
        this.cashWithdrawalService = new CashWithdrawal();
        this.checkBalanceService = new CheckBalance();
    }

    public Transaction getCashWithdrawalService() {
        return cashWithdrawalService;
    }

    public void setCashWithdrawalService(Transaction cashWithdrawalService) {
        this.cashWithdrawalService = cashWithdrawalService;
    }

    public Transaction getCheckBalanceService() {
        return checkBalanceService;
    }

    public void setCheckBalanceService(Transaction checkBalanceService) {
        this.checkBalanceService = checkBalanceService;
    }
}
