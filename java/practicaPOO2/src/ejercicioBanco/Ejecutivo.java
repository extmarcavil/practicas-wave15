package ejercicioBanco;

import java.util.Random;
import java.util.Scanner;

public class Ejecutivo extends Cliente {

    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo(Deposito deposito, Transferencia transferencia) {
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    @Override
    void ejecutarTransaccion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Transacciones disponibles para cliente ejecutivo");
        System.out.println("1. Depósito");
        System.out.println("2. Transferencia");
        System.out.println("Por favor, elija la transacción que desea realizar");
        int opcion = Integer.parseInt(scanner.nextLine());
        Random r = new Random();

        switch (opcion) {
            case 1:
                if (r.nextInt(2) == 1)
                    this.deposito.transaccionOk();
                else this.deposito.transaccionNoOk();
                break;
            case 2:
                if (r.nextInt(2) == 1)
                    this.transferencia.transaccionOk();
                else this.transferencia.transaccionNoOk();
                break;
            default:
                System.out.println("Opción invalida.");
            break;
        }
    }
}
