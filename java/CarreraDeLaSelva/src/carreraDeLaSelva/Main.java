package carreraDeLaSelva;

public class Main {
    public static void main(String[] args) {
        CarreraDeLaSelva carreraDeLaSelva = new CarreraDeLaSelva();

        Participante p1 = new Participante();
        p1.setNombre("Cosme");
        p1.setApellido("Fulanito");
        p1.setCelular("123");
        p1.setDni("123");
        p1.setEdad(43);
        p1.setGrupoSanguineo("A+");
        p1.setNumeroDeEmergencia("123");

        Participante p2 = new Participante();
        p2.setNombre("Ash");
        p2.setApellido("Ketchum (o como sea)");
        p2.setCelular("123");
        p2.setDni("123");
        p2.setEdad(10);
        p2.setGrupoSanguineo("A+");
        p2.setNumeroDeEmergencia("123");

        Participante p3 = new Participante();
        p3.setNombre("Dean");
        p3.setApellido("Winchester");
        p3.setCelular("123");
        p3.setDni("123");
        p3.setEdad(25);
        p3.setGrupoSanguineo("A+");
        p3.setNumeroDeEmergencia("123");

        carreraDeLaSelva.incribirParticipante("chico", p2);
        carreraDeLaSelva.incribirParticipante("chico", p1);
        carreraDeLaSelva.mostrarParticipantesDeCircuito("chico");

        carreraDeLaSelva.desinscribirParticipante("chico", p2);

        carreraDeLaSelva.mostrarParticipantesDeCircuito("chico");

        carreraDeLaSelva.incribirParticipante("medio", p2);
        carreraDeLaSelva.incribirParticipante("medio", p3);

        carreraDeLaSelva.incribirParticipante("avanzado", p1);
        carreraDeLaSelva.incribirParticipante("avanzado", p2);

        carreraDeLaSelva.calcularMontos();
    }
}
