package P1_TemperaturaGlobales;

public class Main {
    public static void main(String[] args) {
        String[] vectorCiudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunsion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] matrizTemperatura = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        int indiceMenor=0;
        int menor=matrizTemperatura[0][0];
        int indiceMayor=0;
        int mayor=matrizTemperatura[0][1];
        for (int i=1; i<10;i++){
            if(matrizTemperatura[i][0]<menor){
                menor=matrizTemperatura[i][0];
                indiceMenor=i;
            }
            if(matrizTemperatura[i][1]>mayor){
                mayor=matrizTemperatura[i][1];
                indiceMayor=i;
            }
        }
        System.out.println("Menor: "+vectorCiudades[indiceMenor]);
        System.out.println("Mayor: "+vectorCiudades[indiceMayor]);
    }
}
