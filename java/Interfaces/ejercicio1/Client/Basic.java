package abstractasInterfaces.ejercicio1.Client;

import abstractasInterfaces.ejercicio1.Transaction.Impl.CashWithdrawal;
import abstractasInterfaces.ejercicio1.Transaction.Impl.CheckBalance;
import abstractasInterfaces.ejercicio1.Transaction.Impl.PayServices;
import abstractasInterfaces.ejercicio1.Transaction.Transaction;

public class Basic {

    private Transaction checkBalanceService;
    private Transaction payServicesService;
    private Transaction cashWithdrawalService;

    public Basic() {
        this.checkBalanceService = new CheckBalance();
        this.payServicesService = new PayServices();
        this.cashWithdrawalService = new CashWithdrawal();
    }

    public Transaction getCheckBalanceService() {
        return checkBalanceService;
    }

    public void setCheckBalanceService(Transaction checkBalanceService) {
        this.checkBalanceService = checkBalanceService;
    }

    public Transaction getPayServicesService() {
        return payServicesService;
    }

    public void setPayServicesService(Transaction payServicesService) {
        this.payServicesService = payServicesService;
    }

    public Transaction getCashWithdrawalService() {
        return cashWithdrawalService;
    }

    public void setCashWithdrawalService(Transaction cashWithdrawalService) {
        this.cashWithdrawalService = cashWithdrawalService;
    }
}
