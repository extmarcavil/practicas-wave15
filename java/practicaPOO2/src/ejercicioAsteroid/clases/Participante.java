package ejercicioAsteroid.clases;

import ejercicioAsteroid.interfaces.IVehiculoEspacial;

public class Participante {

    private String nombre;
    private IVehiculoEspacial vehiculoEspacial;

    public Participante(String nombre, IVehiculoEspacial vehiculoEspacial) {
        this.nombre = nombre;
        this.vehiculoEspacial = vehiculoEspacial;
    }

    public String getNombre() {
        return nombre;
    }

    public IVehiculoEspacial getVehiculoEspacial() {
        return vehiculoEspacial;
    }

    public int obtenerPuntuacionParticipante() {
        return this.getVehiculoEspacial().obtenerPuntaje();
    }
}
