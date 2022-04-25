package ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.dto;

public class DeportistaDTO {
    private String fullName;
    private String deporte;

    public DeportistaDTO(String fullName, String deporte) {
        this.fullName = fullName;
        this.deporte = deporte;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
