package ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.dto;

public class DeporteDTO {
    private String nivel;

    public DeporteDTO(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
