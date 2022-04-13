package ejercicioBanco;

import java.util.Random;
import java.util.Scanner;

public class Cobrador extends Cliente {

    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobrador(RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo) {
        this.retiroEfectivo = retiroEfectivo;
        this.consultaSaldo = consultaSaldo;
    }

    @Override
    void ejecutarTransaccion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Transacciones disponibles para cliente cobrador");
        System.out.println("1. Consulta de Saldo");
        System.out.println("2. Retiro de efectivo");
        System.out.println("Por favor, elija la transacción que desea realizar");
        int opcion = Integer.parseInt(scanner.nextLine());
        Random r = new Random();

        switch (opcion) {
            case 1:
                if (r.nextInt(2) == 1)
                    this.consultaSaldo.transaccionOk();
                else this.consultaSaldo.transaccionNoOk();
                break;
            case 2:
                if (r.nextInt(2) == 1)
                    this.retiroEfectivo.transaccionOk();
                else this.retiroEfectivo.transaccionNoOk();
                break;
            default:
                System.out.println("Opción invalida.");
                break;
        }
    }
}
