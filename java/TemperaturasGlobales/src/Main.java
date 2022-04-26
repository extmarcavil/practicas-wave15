public class Main {

    public static void main(String[] args) {
        String[] ciudades = {
                "Londres",
                "Madris",
                "Nueva York",
                "Buenos Aires",
                "Asunciòn",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int[][] temperaturas = {
                {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},
                {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}
        };

        int min = 0;
        int max = 0;

        for (int i = 1; i < temperaturas[0].length; i++) {
            if(temperaturas[0][min] > temperaturas[0][i]){
                min = i;
            }
            if(temperaturas[1][max] < temperaturas[1][i]){
                max = i;
            }
        }
        System.out.println("La mayor temperatura la tuvo " + ciudades[max] + ", con " + temperaturas[1][max] + "ºC.");
        System.out.println("La menor temperatura la tuvo " + ciudades[min] + ", con " + temperaturas[0][min] + "ºC.");

    }
}
