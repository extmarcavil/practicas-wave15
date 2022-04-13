package ejercicio1;

public class Ejercicio1 {
    public static class Automovil {

        public String marca;
        public String color;
        public double kilometros;

        public Automovil(String marca, String color, double kilometros) {
            this.marca = marca;
            this.color = color;
            this.kilometros = kilometros;
        }

        public String mostrarMarcaYColor() {
            return "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Automovil auto1 = new Automovil("fiat", "rojo", 35.55);
        auto1.mostrarMarcaYColor();
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;


    }
