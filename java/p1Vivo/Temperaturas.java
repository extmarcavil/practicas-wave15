package p1Vivo;


public class Temperaturas {
    public static void main(String[] args) {
        String vector[] = new String[10];
        int matriz[][] = new int[10][10];
        vector[0] = "Londres";
        vector[1] = "Madrid";
        vector[2] = "Nueva York";
        vector[3] = "Buenos Aires";
        vector[4] = "ASuncion";
        vector[5] = "Sao Paulo";
        vector[6] = "Lima";
        vector[7] = "Santiago de chile";
        vector[8] = "Lisboa";
        vector[9] = "Tokio";
        matriz [0][0] = -2;
        matriz [0][1] = 33;
        matriz [1][0] = -3;
        matriz [1][1] = 32;
        matriz [2][0] = -8;
        matriz [2][1] = 27;
        matriz [3][0] = 4;
        matriz [3][1] = 37;
        matriz [4][0] = 6;
        matriz [4][1] = 42;
        matriz [5][0] = 5;
        matriz [5][1] = 43;
        matriz [6][0] = 0;
        matriz [6][1] = 39;
        matriz [7][0] = -7;
        matriz [7][1] = 26;
        matriz [8][0] = -1;
        matriz [8][1] = 31;
        matriz [9][0] = -10;
        matriz [9][1] = 35;

        int min = matriz[0][0];
        int max = matriz[0][1];
        int valorMin = 0;
        int valorMax = 0;
        for (int i =1; i< matriz.length; i++){
            if (matriz[i][0]<min){
                min = matriz[i][0];
                valorMin = i;
            }
            if (matriz[i][1]>max) {
                max = matriz[i][1];
                valorMax = i;
            }
        }
        System.out.println("La mayor temperatura se dio en : " + vector[valorMax] + " Y fue de : " + max);
        System.out.println("La menor temperatura se dio en : " + vector[valorMin] + " Y fue de : " + min);





    }
}
