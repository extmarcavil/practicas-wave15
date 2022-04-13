package ejercicioIntegradorTurismo;

public enum ReservaType {

    RESERVA_HOTEL(1),
    COMIDA(2),
    BOLETO_VIAJE(3),
    TRANSPORTE(4);

    private final int value;

    ReservaType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}