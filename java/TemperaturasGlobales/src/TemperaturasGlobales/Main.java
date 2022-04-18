package TemperaturasGlobales;

public class Main {

    public static void main (String[] args) {
        String[] cities = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = new int[10][2];
        temperatures[0][0] = -2;
        temperatures[1][0] = -3;
        temperatures[2][0] = -8;
        temperatures[3][0] = 4;
        temperatures[4][0] = 6;
        temperatures[5][0] = 5;
        temperatures[6][0] = 0;
        temperatures[7][0] = -7;
        temperatures[8][0] = -1;
        temperatures[9][0] = -10;
        temperatures[0][1] = 33;
        temperatures[1][1] = 32;
        temperatures[2][1] = 27;
        temperatures[3][1] = 37;
        temperatures[4][1] = 42;
        temperatures[5][1] = 43;
        temperatures[6][1] = 39;
        temperatures[7][1] = 26;
        temperatures[8][1] = 31;
        temperatures[9][1] = 35;

        int lowTemp = temperatures[0][0];
        int highTemp = temperatures[0][1];
        String lowTempCity = cities[0];
        String highTempCity = cities[0];

        for(int i=1; i<temperatures.length; i++){
            for(int j=0; j<temperatures[i].length; j++){
                if(temperatures[i][j] < lowTemp) {
                    lowTemp = temperatures[i][j];
                    lowTempCity = cities[i];
                }
                if(temperatures[i][j] > highTemp) {
                    highTemp = temperatures[i][j];
                    highTempCity = cities[i];
                }
            }
        }

        System.out.println("Menor temperatura es de " + lowTempCity + " con temperatura: " + lowTemp);
        System.out.println("Mayor temperatura es de " + highTempCity + " con temperatura: " + highTemp);

    }
}
