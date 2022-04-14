import java.util.Scanner;

public class Vectores {
    String[] ciudades = new String[9];
    int[][] temperaturas = new int[9][2];
    Scanner sc;

    public Vectores() {
        this.sc = new Scanner(System.in);
    }

    public void cargaCiudad() {
        for (int i = 0; i < this.ciudades.length; ++i) {
            System.out.println("Ingrese ciudad, esta sera almacenada en la posición: " + i);
            this.ciudades[i] = this.sc.nextLine();
        }

    }

    public void cargaTemperaturas() {
        for (int i = 0; i < this.temperaturas.length; ++i) {
            for (int j = 0; j < this.temperaturas[i].length; ++j) {
                System.out.println("Ingrese temperaturas, se almacenará en la posición: " + i + " " + j);
                this.temperaturas[i][j] = this.sc.nextInt();
                System.out.println(this.temperaturas[i][j]);
            }
        }

    }

    public void imprimir() {
        for (int x = 0; x < this.temperaturas.length; ++x) {
            System.out.println("Ciudad: " + x + ".- " + this.ciudades[x]);
            System.out.println("---------------");
            System.out.println();

            for (int y = 0; y < this.temperaturas[x].length; ++y) {
                System.out.println("Temperaturas: ");
                System.out.println("Min  Max");
                System.out.println(this.temperaturas[x][y] + " || " + this.temperaturas[x][y + 1]);
                System.out.println("---------------");
                ++y;
            }
        }

    }
}


