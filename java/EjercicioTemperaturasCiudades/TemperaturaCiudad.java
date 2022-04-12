package EjercicioTemperaturasCiudades;

public class TemperaturaCiudad {

    public static void ImprimirM (int[][]temperaturas){
        for(int i= 0; i<temperaturas.length; i++){
            for(int j=0; j<temperaturas[i].length; j++){
                System.out.print(temperaturas[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void ImprimirV (String [] ciudades){
        for (int i=0; i<ciudades.length; i++){
            System.out.println("" + ciudades[i]+"");
        }
    }


    public static void ImprimirMV (String [] ciudades, int[][]temperaturas ){
        for(int i= 0; i<temperaturas.length; i++){
            for(int j=0; j<temperaturas[i].length; j++){
                System.out.print(ciudades[i]+" ");
                System.out.print(temperaturas[i][j]+"\n");
            }
            System.out.println();
        }
    }

    public static void MenorTemperatura (String [] ciudades, int[][]temperaturas){
        int temperatura = temperaturas[0][0];
        String ciudad =  ciudades[0];
        for(int i= 0; i<temperaturas.length; i++){
            for(int j=0; j<temperaturas[i].length; j++){
                if(temperatura>temperaturas[i][j]){
                    temperatura = temperaturas [i][j];
                    ciudad = ciudades[i];
                };
            }
        }
        System.out.println("La temperatura mas baja corresponde a la ciudad de: "+ciudad + ", con una temperatura de " +temperatura+".");
    }

    public static void MayorTemperatura (String [] ciudades, int[][]temperaturas){
        int temperatura = temperaturas[0][0];
        String ciudad =  ciudades[0];
        for(int i= 0; i<temperaturas.length; i++){
            for(int j=0; j<temperaturas[i].length; j++){
                if(temperatura<temperaturas[i][j]){
                    temperatura = temperaturas [i][j];
                    ciudad = ciudades[i];
                };
            }
        }
        System.out.println("La temperatura mas alta corresponde a la ciudad de: "+ciudad + ", con una temperatura de " +temperatura+".");
    }

    public static void main(String[] args) {
        String ciudades [] = new String [10];
        ciudades [0] = "Londres";
        ciudades [1] = "Madrid";
        ciudades [2] = "Nueva York";
        ciudades [3] = "Buenos Aires";
        ciudades [4] = "Asunción";
        ciudades [5] = "Sao Paulo";
        ciudades [6] = "Lima";
        ciudades [7] = "Santiago de Chile";
        ciudades [8] = "Lisboa";
        ciudades [9] = "Tokio";

        int temperaturas [][] = new int [10][2];
        temperaturas[0][0]= -2;
        temperaturas[0][1]= 33;
        temperaturas[1][0]= -3;
        temperaturas[1][1]= 32;
        temperaturas[2][0]= -8;
        temperaturas[2][1]= 27;
        temperaturas[3][0]= 4;
        temperaturas[3][1]= 37;
        temperaturas[4][0]= 6;
        temperaturas[4][1]= 42;
        temperaturas[5][0]= 5;
        temperaturas[5][1]= 43;
        temperaturas[6][0]= 0;
        temperaturas[6][1]= 39;
        temperaturas[7][0]= -7;
        temperaturas[7][1]= 26;
        temperaturas[8][0]= -1;
        temperaturas[8][1]= 31;
        temperaturas[9][0]= -10;
        temperaturas[9][1]= 35;

        //ImprimirM(temperaturas);
        //ImprimirV(ciudades);
        System.out.println("Ciudades y sus temperaturas registradas:");
        ImprimirMV(ciudades,temperaturas);
        MenorTemperatura(ciudades,temperaturas);
        MayorTemperatura(ciudades,temperaturas);

    }


}
