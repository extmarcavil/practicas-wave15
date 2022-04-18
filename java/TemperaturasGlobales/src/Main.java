import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> paises = new ArrayList<>();
        List<List<Integer>> temperaturas = new ArrayList<>();

        paises.add("Londres");
        paises.add("Madrid");
        paises.add("Nueva York");
        paises.add("Buenos Aires");
        paises.add("Asuncion");
        paises.add("San Paulo");
        paises.add("Lima");
        paises.add("Santiago de Chile");
        paises.add("Lisboa");
        paises.add("Tokio");

        temperaturas.add(Arrays.asList(-2, 33));
        temperaturas.add(Arrays.asList(-3, 32));
        temperaturas.add(Arrays.asList(-8, 27));
        temperaturas.add(Arrays.asList(4, 37));
        temperaturas.add(Arrays.asList(6, 42));
        temperaturas.add(Arrays.asList(5, 43));
        temperaturas.add(Arrays.asList(0, 39));
        temperaturas.add(Arrays.asList(-7, 36));
        temperaturas.add(Arrays.asList(-1, 31));
        temperaturas.add(Arrays.asList(-10, 35));

        String paisMin = "";
        String paisMax = "";
        Integer tempMin = 999;
        Integer tempMax = -999;

        for (int i = 0; i < paises.size(); i++) {
            String pais = paises.get(i);
            List<Integer> temps = temperaturas.get(i);
            if (temps.get(0) < tempMin) {
                paisMin = pais;
                tempMin = temps.get(0);
            }
            if (temps.get(1) > tempMax) {
                paisMax = pais;
                tempMax = temps.get(1);
            }
        }

        System.out.println("Temperatura minima " + tempMin + " en la ciudad de " + paisMin);
        System.out.println("Temperatura maxima " + tempMax + " en la ciudad de " + paisMax);
    }
}
