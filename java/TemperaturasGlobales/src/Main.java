public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas[][] = new int[10][2];
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

        int maximaTemperatura = 0;
        int minimaTemperatura = 0;
        int filaMaximaTemperatura = 0;
        int filaMinimaTemperatura = 0;

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j<2; j++) {
                if(j == 0) {
                    if(temperaturas[i][j] < minimaTemperatura) {
                        minimaTemperatura = temperaturas[i][j];
                        filaMinimaTemperatura = i;
                    }
                } else {
                    if(temperaturas[i][j] > maximaTemperatura) {
                        maximaTemperatura = temperaturas[i][j];
                        filaMaximaTemperatura = i;
                    }
                }
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[filaMinimaTemperatura] + " con "
                + minimaTemperatura + "ºC");
        System.out.println("La mayor temperatura la tuvo " + ciudades[filaMaximaTemperatura] + " con "
                + maximaTemperatura + "ºC");

    }
}
