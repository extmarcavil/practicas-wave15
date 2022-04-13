package POO.P1;

public class Persona {

    private String nombre;
    private Integer edad;
    private String dni;
    private Integer peso; // kg
    private Integer altura; // cm


    public Persona() {}

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, Integer peso, Integer altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        Integer calculo = peso / (int) Math.pow(altura, 2)/100;

        return calculo < 20 ? -1 : calculo <= 25 ? 0 : 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", Dni='" + dni + '\'' +
                ", Peso (kg)=" + peso +
                ", Altura (cm)=" + altura;
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Nico", 25, "1111111");
        Persona persona3 = new Persona("Juan", 44, "12345678", 76, 175);

        String peso = persona3.calcularIMC() == -1 ? "Bajo peso" : persona3.calcularIMC() == 0 ? "Peso Saludable" : "Sobrepeso";

        System.out.println(peso);
        System.out.println(persona3.esMayorDeEdad() ? "Mayor de edad" : "Menor de edad");
        System.out.println(persona3.toString());
    }

}
