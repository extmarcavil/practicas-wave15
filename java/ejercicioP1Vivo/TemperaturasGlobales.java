package ejercicioP1Vivo;

public class TemperaturasGlobales {

    public static void main(String[] args) {

        String ciudades[] = new String [10];
        int temperaturas[][] = new int [10][2];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        temperaturas [0][0] = -2;
        temperaturas [0][1] = 33;
        temperaturas [1][0] = -3;
        temperaturas [1][1] = 32;
        temperaturas [2][0] = -8;
        temperaturas [2][1] = 27;
        temperaturas [3][0] = 4;
        temperaturas [3][1] = 37;
        temperaturas [4][0] = 6;
        temperaturas [4][1] = 42;
        temperaturas [5][0] = 5;
        temperaturas [5][1] = 43;
        temperaturas [6][0] = 0;
        temperaturas [6][1] = 39;
        temperaturas [7][0] = -7;
        temperaturas [7][1] = 26;
        temperaturas [8][0] = -1;
        temperaturas [8][1] = 31;
        temperaturas [9][0] = -10;
        temperaturas [9][1] = 35;

        int tempMenor = temperaturas[0][0];
        int tempMayor = temperaturas[0][1];
        int posTempMenor = 0;
        int posTempMayor = 0;


        for (int i=0; i< temperaturas.length; i++){
            if (temperaturas[i][0] < tempMenor){
                tempMenor = temperaturas[i][0];
                posTempMenor = i;
            }
            if (temperaturas[i][1] > tempMayor){
                tempMayor = temperaturas[i][1];
                posTempMayor = i;
            }
            
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[posTempMenor] +" , con " + tempMenor + " º C");
        System.out.println("La mayor temperatura la tuvo " + ciudades[posTempMayor] +" , con " + tempMayor + " º C");

    }
}
