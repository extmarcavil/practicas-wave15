package IntroJavaP1_TemperaturasGlobales;

public class Main {
    public static void main(String[] args) {
        String[] vectorCiudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] matrizTemperaturas = {
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

        int menorTemp = 0;
        int mayorTemp = 0;

        int menor=matrizTemperaturas[0][0];
        int mayor=matrizTemperaturas[0][1];

        for (int i=1;i< vectorCiudades.length;i++){
            //Temperatura minima
            if(matrizTemperaturas[i][0]<menor){
                menor=matrizTemperaturas[i][0];
                menorTemp=i;
            }
            //Temperatura maxima
            if (matrizTemperaturas[i][1]>mayor){
                mayor=matrizTemperaturas[i][1];
                mayorTemp=i;
            }
        }
        System.out.println("La menor temperatura fue de " + +menor+"ºC en la ciudad de "+vectorCiudades[menorTemp]+".");
        System.out.println("La mayor temperatura fue de " + +mayor+"ºC en la ciudad de "+vectorCiudades[mayorTemp]+".");
    }
}
