package carreraSelva;


public class Categoria {

    Participante participante;
    int monto;
    int nroParticipante;

    public Categoria(Participante participante, int monto, int nroParticipante) {
        this.participante = participante;
        this.monto = monto;
        this.nroParticipante = nroParticipante;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getNroParticipante() {
        return nroParticipante;
    }

    public void setNroParticipante(int nroParticipante) {
        this.nroParticipante = nroParticipante;
    }
}
