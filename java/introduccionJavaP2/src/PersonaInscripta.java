import java.util.Objects;

public class PersonaInscripta {
    private Integer numero;
    private Categoria categoria;
    private Persona persona;
    private Integer montoPagar;

    public Integer getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(Integer montoPagar) {
        this.montoPagar = montoPagar;
    }

    public PersonaInscripta(Integer numero, Categoria categoria, Persona persona, Integer montoPagar) {
        this.numero = numero;
        this.categoria = categoria;
        this.persona = persona;
        this.montoPagar = montoPagar;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "PersonaInscripta{" +
                "numero=" + numero +
                ", categoria=" + categoria +
                ", montoPagar=" + montoPagar +
                "," + persona +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaInscripta that = (PersonaInscripta) o;
        return Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
