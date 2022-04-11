package main;

public class RealizarTransaccion {

    public RealizarTransaccion() {
    }

    public static void ApplyTransaction(String tipo) {
        switch(tipo) {
            case "Consulta":
                System.out.println("La consulta de saldo ha sido Exitosa!!");
                break;
            case "Transferencia":
                System.out.println("La transferencia ha sido Exitosa!!");
                break;
            case "Deposito":
                System.out.println("El deposito ha sido Exitoso!!");
                break;
            case "Retiro":
                System.out.println("El retiro de efectivo ha sido Exitoso!!");
                break;
            case "Pago":
                System.out.println("El pago de servicio ha sido Exitoso!!");
                break;
        }
    }

    private void message (String mensaje) {
        System.out.println(mensaje);
    }

}
