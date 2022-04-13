public class TemperaturasGlobales {

    static final String[] nombresCiudades={
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asuncion",
            "Sao Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio",
    };

    static final int[][] temperaturasRegistradas= {
            {-2,33},
            {-3,32},
            {-8,27},
            {4,37},
            {6,42},
            {5,43},
            {0,39},
            {-7,26},
            {1,31},
            {-10,35}
    };

    public static void main(String[] args) {

        int min=0,max=0;
        int valMin=temperaturasRegistradas[0][0],valMax=temperaturasRegistradas[0][1];

        for (int i = 1; i < temperaturasRegistradas.length; i++) {
            if (temperaturasRegistradas[i][0]<valMin){
                min=i;
                valMin=temperaturasRegistradas[i][0];
            }
            if (temperaturasRegistradas[i][1]>valMax) {
                max=i;
                valMax=temperaturasRegistradas[i][1];
            }
        }

        System.out.println("Temperatura Max:"+valMax+" y se registra en "+nombresCiudades[max]);
        System.out.println("Temperatura Min:"+valMin+" y se registra en "+nombresCiudades[min]);
    }
}
