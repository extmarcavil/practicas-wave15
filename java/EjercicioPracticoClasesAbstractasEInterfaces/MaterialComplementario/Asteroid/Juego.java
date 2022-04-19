package EjercicioPracticoClasesAbstractasEInterfaces.MaterialComplementario.Asteroid;

import java.util.List;

public class Juego {
    private List<Asteroides> listaDeAsteroides;
    private List<Naves> listaDeNaves;
    private List<Participantes> listaDeParticipantes;

    public Juego(List<Asteroides> listaDeAsteroides, List<Naves> listaDeNaves, List<Participantes> listaDeParticipantes) {
        this.listaDeAsteroides = listaDeAsteroides;
        this.listaDeNaves = listaDeNaves;
        this.listaDeParticipantes = listaDeParticipantes;
    }

    public void ingresarParticipante(String nombre){
        listaDeParticipantes.add(new Participantes(nombre));
    }
    public void ingresarNaves(int x, int y, String nombre){
        listaDeNaves.add(new Naves(x,y,nombre));
    }
    public void ingresarAsteroides(int x, int y){
        listaDeAsteroides.add(new Asteroides(x,y));
    }

    public void distancia(){
        int i =-1;
        for (Naves naves : listaDeNaves){
            i = i + 1;
            for (Asteroides asteroides : listaDeAsteroides){
                double distancias[] = new double[listaDeNaves.size()];
                double diferenciaX = naves.getX() - asteroides.getX();
                double diferenciaY = naves.getX() - asteroides.getX();

                distancias[i] = Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
                System.out.println("Distancia de" + distancias[i]);
            }
        }
    }



}
