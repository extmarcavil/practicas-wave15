package ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.db;

import ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.model.Deporte;
import ejerciciosdto.ejerciciopracticop2.ejerciciodeportistas.model.Persona;

import java.util.List;
import java.util.Map;

public class DB {

    private static final Map<String, Deporte> deportes=Map.of(
            "futbol",new Deporte("futbol","medio"),
            "tenis",new Deporte("tenis","avanzado"),
            "padel", new Deporte("padel","principiante")
    );

    private static final Map<String, List<Persona>> deportistas = Map.of(
            "futbol",List.of(
                    new Persona("Lucas","Jimenez",50),
                    new Persona("Leo","Messi",60),
                    new Persona("Martin","Palermo",75)
            ),
            "padel",List.of(
                    new Persona("Juan","Lebron",35),
                    new Persona("Ale","Galan",25),
                    new Persona("Lucas","lucas",27)

            ),
            "tenis",List.of(
                    new Persona("Rafa","Nadal",35),
                    new Persona("Roger","Federer",40),
                    new Persona("Juan Martin","Del Potro",30)
            )


    );

    public static Map<String, Deporte> getDeportes() {
        return deportes;
    }

    public static Map<String, List<Persona>> getDeportistas() {
        return deportistas;
    }
}
