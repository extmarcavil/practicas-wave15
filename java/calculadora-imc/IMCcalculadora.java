public class IMCcalculadora {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Alan", 25, "38166153", 77, 177);
        persona1.mostrarPersona();
        System.out.println(persona1.calcularIMC());
        if (persona1.edad()) {
            System.out.println("La persona es mayor de 18 años");
        } else {
            System.out.println("La persona es menor de 18 años");
        }
    }
    public static class Persona  {

        private String nombre;
        private int edad;
        private String dni;
        private double peso;
        private double altura;

        public Persona (String nombre, int edad, String dni, int peso, int altura) {
            this.nombre=nombre;
            this.edad=edad;
            this.dni=dni;
            this.peso=peso;
            this.altura=altura;
        }

        public void mostrarPersona() {
            System.out.println(nombre + " " + edad);
        }

        public String calcularIMC() {
            String mensaje = null;
            double imc = this.peso/((this.altura/100)*(this.altura/100));
            if (imc < 20) {
                mensaje = "Bajo peso";
            } else if (imc > 25) {
                mensaje = "Sobrepeso";
            } else {
                mensaje = "Peso saludable";
            }
            return mensaje;
        }

        public boolean edad() {
            if (edad >= 18) {
                return true;
            } else {
                return false;
            }
        }
    }
}
