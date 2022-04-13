package ejercicioBanco;

import java.util.ArrayList;

public abstract class Cliente {
    protected ArrayList transacciones = new ArrayList();

    public abstract <T> void realizarTransaccion(T transaccion);

    @Override
    public String toString() {
        return "Cliente{" +
                "transacciones=" + transacciones.size() +
                '}';
    }
}
