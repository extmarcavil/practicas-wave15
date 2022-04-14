package tempCiudaddes;

public class tempCiudades {
    public static void main(String[] args) {
        String ciudades []= new String[10];
        int temperaturas [][] = new int[2][10];
        int temperaturaMenor=0;
        int temperaturaMayor=0;
        String ciudadMayor="";
        String ciudadMenor = "";

        ciudades [0] = "Londres";
        ciudades [1] = "Madrid";
        ciudades [2] = "Nueva York";
        ciudades [3] = "Buenos aires";
        ciudades [4] = "Asuncion";
        ciudades [5] = "Sao pablo";
        ciudades [6] = "Lima";
        ciudades [7] = "Santiago de chile";
        ciudades [8] = "Lisboa";
        ciudades [9] = "Tokio";


        temperaturas [0][0]=-2;
        temperaturas [0][1]=-3;
        temperaturas [0][2]=-8;
        temperaturas [0][3]=4;
        temperaturas [0][4]=6;
        temperaturas [0][5]=5;
        temperaturas [0][6]=0;
        temperaturas [0][7]=-7;
        temperaturas [0][8]=-1;
        temperaturas [0][9]=-10;

        temperaturas [1][0]=33;
        temperaturas [1][1]=32;
        temperaturas [1][2]=27;
        temperaturas [1][3]=37;
        temperaturas [1][4]=42;
        temperaturas [1][5]=43;
        temperaturas [1][6]=39;
        temperaturas [1][7]=26;
        temperaturas [1][8]=31;
        temperaturas [1][9]=35;


        for (String c: ciudades) {
           // System.out.println(c);
        }

        for(int f = 0; f<2 ;f++){
            for( int c = 0; c < 10;c++){
               // System.out.println(temperaturas[f][c]);
                if(temperaturas[f][c]>temperaturaMayor){
                    temperaturaMayor = temperaturas[f][c];
                    ciudadMayor = ciudades[c];
                }

                if(temperaturas[f][c]<temperaturaMenor){
                    temperaturaMenor = temperaturas[f][c];
                    ciudadMenor = ciudades[c];
                }
            }
        }

        System.out.println("La temperatura mayor es " + temperaturaMayor + " en la ciudad " + ciudadMayor);
        System.out.println("La temperatura menor es " + temperaturaMenor + " en la ciudad " + ciudadMenor);



    }
}
