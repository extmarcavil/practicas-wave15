package matrices;

public class ejemplo {
    public static void main(String[] args) {
        String  Ciudades [] = new String[10];
        int Temperaturas [][] = new int[10][2];
        Ciudades[0]="Londres";
        Ciudades[1]="Madrid";
        Ciudades[2]="Nueva York";
        Ciudades[3]="Buenos Aires";
        Ciudades[4]="Asuncion";
        Ciudades[5]="Sao Paulo";
        Ciudades[6]="Lima";
        Ciudades[7]="Santiago de Chile";
        Ciudades[8]="Lisboa";
        Ciudades[9]="Tokio";

        Temperaturas [0][0] = -2;
        Temperaturas [0][1] = 33;
        Temperaturas [1][0] = -3;
        Temperaturas [1][1] = 32;

        Temperaturas [2][0] = -8;
        Temperaturas [2][1] = 27;
        Temperaturas [3][0] = 4;
        Temperaturas [3][1] = 37;
        Temperaturas [4][0] = 6;
        Temperaturas [4][1] = 42;

        Temperaturas [5][0] = 5;
        Temperaturas [5][1] = 43;
        Temperaturas [6][0] = 0;
        Temperaturas [6][1] = 39;
        Temperaturas [7][0] = -7;
        Temperaturas [7][1] = 26;
        Temperaturas [8][0] = -1;
        Temperaturas [8][1] = 31;
        Temperaturas [9][0] = -10;
        Temperaturas [9][1] = 35;
        int minTemperatura = Temperaturas[0][0];
        int maxTemperatura = Temperaturas[0][0];
        int posMin = 0;
        int posMax=0;
        for (int i = 0; i < Temperaturas.length; i++)	{
            for (int j = 0; j < Temperaturas[i].length; j++) {
                if (j == 0) {//min
                    if (Temperaturas[i][j] < minTemperatura) {
                        minTemperatura = Temperaturas[i][j];
                        posMin = i;
                    }
                } else {//max
                    if (Temperaturas[i][j] > maxTemperatura) {
                        maxTemperatura = Temperaturas[i][j];
                        posMax = i;
                    }
                }

            }
        }
        System.out.println("la ciudad con menor temperatura es:" + Ciudades[posMin] +
                ",con una temperatura de: " + minTemperatura);
        System.out.println("la ciudad con mayor temperatura es:" + Ciudades[posMax] +
                ",con una temperatura de: " + maxTemperatura);


    }

}
