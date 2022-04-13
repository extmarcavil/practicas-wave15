package ejercicioBanco;

import java.util.Random;
import java.util.Scanner;

public class Basic extends Cliente {

    private ConsultaSaldo consultaSaldo;
    private PagoServicio pagoServicio;
    private RetiroEfectivo retiroEfectivo;

    public Basic() {
    }

    public Basic(ConsultaSaldo consultaSaldo, PagoServicio pagoServicio, RetiroEfectivo retiroEfectivo) {
        this.consultaSaldo = consultaSaldo;
        this.pagoServicio = pagoServicio;
        this.retiroEfectivo = retiroEfectivo;
    }

    @Override
    void ejecutarTransaccion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Transacciones disponibles para cliente basic");
        System.out.println("1. Consulta de Saldo");
        System.out.println("2. Pago de Servicio");
        System.out.println("3. Retiro de Efectivo");
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
                    this.pagoServicio.transaccionOk();
                else this.pagoServicio.transaccionNoOk();
                break;
            case 3:
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
