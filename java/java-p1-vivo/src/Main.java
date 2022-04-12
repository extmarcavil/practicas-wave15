public class Main {

    public static void main(String[] args) {
        String[] ciudades = new String[10];
        int[][] temperaturas = new int[10][2];

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        temperaturas[0] = new int[]{-2, 33};
        temperaturas[1] = new int[]{-3, 32};
        temperaturas[2] = new int[]{-8, 27};
        temperaturas[3] = new int[]{4, 37};
        temperaturas[4] = new int[]{6, 42};
        temperaturas[5] = new int[]{5, 43};
        temperaturas[6] = new int[]{0, 39};
        temperaturas[7] = new int[]{-7, 26};
        temperaturas[8] = new int[]{-1, 31};
        temperaturas[9] = new int[]{-10, 35};

        int temperaturaMinimaIndex = 0;
        int temperaturaMaximaIndex = 0;
        int temperaturaMinima = 0;
        int temperaturaMaxima = 0;

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                temperaturaMinima = temperaturas[i][0];
                temperaturaMaxima = temperaturas[i][1];
            }
            if (temperaturas[i][0] <= temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                temperaturaMinimaIndex = i;
            }
            if (temperaturas[i][1] >= temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                temperaturaMaximaIndex = i;
            }
        }

        System.out.println("La ciudad de " + ciudades[temperaturaMinimaIndex] + " tuvo la menor temperatura con " + temperaturas[temperaturaMinimaIndex][0] + " grados.");
        System.out.println("La ciudad de " + ciudades[temperaturaMaximaIndex] + " tuvo la mayor temperatura con " + temperaturas[temperaturaMaximaIndex][1] + " grados.");
    }
}
