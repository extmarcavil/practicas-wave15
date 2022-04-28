package abstractasInterfaces.ejercicio1;

import abstractasInterfaces.ejercicio1.Client.Basic;
import abstractasInterfaces.ejercicio1.Client.Collector;
import abstractasInterfaces.ejercicio1.Client.Ejecutive;

public class Main {

    public static void main(String[] args) {
        Ejecutive ejecutivo1 = new Ejecutive();
        Basic basicClient1 = new Basic();
        Collector collector1 = new Collector();

        ejecutivo1.getDepositoService().transactionOk();
        basicClient1.getCheckBalanceService().transactionOk();
        collector1.getCashWithdrawalService().transactionOk();
    }
}
