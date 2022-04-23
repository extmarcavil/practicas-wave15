package ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.db;

import ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.model.Deporte;

import java.util.Map;

public class DB {
    private static final Map<String, Deporte> deportes=Map.of(
            "futbol",new Deporte("futbol","medio"),
            "tenis",new Deporte("tenis","avanzado"),
            "padel", new Deporte("padel","principiante")
    );

}
