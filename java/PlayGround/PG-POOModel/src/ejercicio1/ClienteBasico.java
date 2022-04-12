package ejercicio1;

public class ClienteBasico extends Cliente{

    public ClienteBasico(boolean tieneDatosEnRegla) {
        super(tieneDatosEnRegla);
    }

    @Override
    public String nombre() {
        return "Cliente basico";
    }

    public void realizarConsultaDeSaldo() {
        ConsultarSaldo nuevaConsulta = new ConsultarSaldo(this);
        nuevaConsulta.imprimirResultado();
    }
}
