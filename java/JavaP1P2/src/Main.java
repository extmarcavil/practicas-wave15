public class Main {

    public static void main(String[] args) {
        String cities [] = new String[10];
        int temperature [][] = new int[10][2];

        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        temperature[0][0] = -2;
        temperature[0][1] = 33;
        temperature[1][0] = -3;
        temperature[1][1] = 32;
        temperature[2][0] = -8;
        temperature[2][1] = 27;
        temperature[3][0] = 4;
        temperature[3][1] = 37;
        temperature[4][0] = 6;
        temperature[4][1] = 42;
        temperature[5][0] = 5;
        temperature[5][1] = 43;
        temperature[6][0] = 0;
        temperature[6][1] = 39;
        temperature[7][0] = -7;
        temperature[7][1] = 26;
        temperature[8][0] = -1;
        temperature[8][1] = 31;
        temperature[9][0] = -10;
        temperature[9][1] = 35;

        int highestTemp = temperature[0][1];
        int lowestTemp = temperature[0][0];
        String nameHighestTemp = cities[0];
        String nameLowestTemp = cities[0];

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < temperature[i].length; j++) {
                if (temperature[i][j] < lowestTemp){
                    lowestTemp = temperature[i][j];
                    nameLowestTemp = cities[i];
                }
                if (temperature[i][j] > highestTemp){
                    highestTemp = temperature[i][j];
                    nameHighestTemp = cities[i];
                }
            }
        }

        System.out.println("La ciudad con menor temperatura es " + nameLowestTemp + ", con " + lowestTemp +"º C.");
        System.out.println("La ciudad con mayor temperatura es " + nameHighestTemp + ", con " + highestTemp +"º C.");
    }
}
