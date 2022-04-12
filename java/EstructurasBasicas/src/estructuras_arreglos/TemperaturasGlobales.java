package estructuras_arreglos;

public class TemperaturasGlobales {
    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile",
                             "Lisboa", "Tokio"};
        Integer temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int resultados[][] = temperaturaMasBaja(temperaturas);
        System.out.println("Temperatura mas baja: " + resultados[0][0] + " de la ciudad " + ciudades[resultados[0][1]]);
        System.out.println("Temperatura mas alta: " + resultados[1][0] + " de la ciudad " + ciudades[resultados[1][1]]);
    }

    public static int[][] temperaturaMasBaja(Integer temperaturas[][]) {
        int tempMenor[] = {temperaturas[0][0], -1};
        int tempMayor[] = {temperaturas[0][1], -1};
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < tempMenor[0]) {
                tempMenor[0] = temperaturas[i][0];
                tempMenor[1] = i;
            }
            if (temperaturas[i][1] > tempMayor[0]) {
                tempMayor[0] = temperaturas[i][1];
                tempMayor[1] = i;
            }
        }
        int resultados[][] = {tempMenor, tempMayor};
        return  resultados;
    }
}
