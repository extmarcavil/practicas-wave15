public class main {
    public static void main(String[] args) {

        String ciudades[] = new String[10];

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int temperaturas[][] = new int[10][10];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int tempMax = 0;
        int tempMin = 0;
        int indiceMax = 0;
        int indiceMin = 0;

        for (int i=0;i<temperaturas.length;i++){
            for (int j=0;j<temperaturas[i].length;j++){
                    if (temperaturas[i][j] >= tempMax){
                        tempMax = temperaturas[i][j];
                        indiceMax = i;
                    }
                    if (temperaturas[i][j] <= tempMin){
                        tempMin = temperaturas[i][j];
                        indiceMin = i;
                    }
                }
            }

        System.out.println("La ciudad que registró la mayor temperatura es: " + ciudades[indiceMax] + " con " + tempMax +
                " grados.");
        System.out.println("La ciudad que registró la menor temperatura es: " + ciudades[indiceMin] + " con " + tempMin +
                " grados.");
    }
}
