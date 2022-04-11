public class temperaturas_globales {
    public static void main(String[] args) {

        int temperatura_minima = 0;
        int indice = 0;

        String ciudades[] = new String[]
                {"Londres","Madrid","Nueva York","Buenos Aires", "Asunción",
                        "São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int [][] temperaturas = {{-2,33},{-1,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-1,26},{-1,31},{-10,35}};

        for(int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas.length; j++) {
                if(temperaturas[i][j] < temperatura_minima) {
                    temperatura_minima = temperaturas[i][j];
                    indice = i;
                }else {
                    break;
                }
            }
        }
        System.out.println("La menor temperatura, entre las ciudades, la tuvo " + ciudades[indice]+", con "+ temperatura_minima +"ºC.");
    }
}
