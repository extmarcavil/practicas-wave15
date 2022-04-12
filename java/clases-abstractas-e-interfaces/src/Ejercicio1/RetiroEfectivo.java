package Ejercicio1;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro exitoso.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No puede retirar efectivo en este momento.");
    }
}
