package Temperaturas;

public class Main {
    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};;

        // Se necesita conocer la mayor y la menor temperatura entre todas las ciudades;
        // al mismo tiempo se deberá especificar el nombre de la ciudad.

        int menorT = 0;
        int mayorT = 0;
        String ciudadMenor = ciudades[0];
        String ciudadMayor = ciudades[0];
        for (int ii = 0; ii < ciudades.length; ii++) {
            int menor = temperaturas[ii][0];
            int mayor = temperaturas[ii][1];
            if (menor < menorT) {
                menorT = menor;
                ciudadMenor = ciudades[ii];
            }
            if (mayor > mayorT) {
                mayorT = mayor;
                ciudadMayor = ciudades[ii];
            }
        }

        System.out.println("Ciudad con menor temperatura: " + ciudadMenor + " con " + menorT);
        System.out.println("Ciudad con mayor temperatura: " + ciudadMayor + " con " + mayorT);
    }
}
