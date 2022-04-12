package estructura;

//Ejercicio JAVA I - Temperaturas globales
public class TemperaturasGlobales {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "NY", "Bs As", "Asuncion", "Sao Pablo", "Lima", "Santiago de Chile","Lisboa","Tokio"};

        int temp[][] = new int [10][2];
        temp[0][0] = -2;
        temp[0][1] = 33;
        temp[1][0] = -3;
        temp[1][1] = 32;
        temp[2][0] = -8;
        temp[2][1] = 27;
        temp[3][0] = 4;
        temp[3][1] = 37;
        temp[4][0] = 6;
        temp[4][1] = 42;
        temp[5][0] = 5;
        temp[5][1] = 43;
        temp[6][0] = 0;
        temp[6][1] = 39;
        temp[7][0] = -7;
        temp[7][1] = 26;
        temp[8][0] = -1;
        temp[8][1] = 32;
        temp[9][0] = -10;
        temp[9][1] = 35;

        int tempMin = temp[0][0];
        int tempMax = temp[0][1];
        String ciudadMin = ciudades[0];
        String ciudadMax = ciudades[0];

        for (int f=1; f<temp.length; f++) {
            for (int c=0; c<temp[f].length; c++) {

                if(tempMin > temp[f][c] && c == 0){
                    tempMin = temp[f][c];
                    ciudadMin = ciudades[f];
                }
                if(tempMax < temp[f][c] && c == 1){
                    tempMax = temp[f][c];
                    ciudadMax = ciudades[f];
                }

            }

        }

        System.out.println("La menor temp la tuvo " + ciudadMin + ", con " + tempMin + "ºC");
        System.out.println("La mayor temp la tuvo " + ciudadMax + ", con " + tempMax + "ºC");
    }



}
