package EjercicioPOO;

import java.util.HashMap;

public class Persona {
    private String nombre;
    private int dni;
    private int edad;
    private float peso;
    private float altura;

    public Persona() {
    }

    public Persona(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, int dni, int edad, float peso, float altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso / Math.pow(2, altura);

        if(imc < 20)
            return -1;
        else if(imc <= 25)
            return 0;
        else
            return 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String toString() {
        String str = "Nombre: " + this.nombre + "\n";

        str += "DNI: " + this.dni + "\n";

        HashMap<Integer, String> equivalenciasIMC = new HashMap<>();
        equivalenciasIMC.put(-1, "Bajo peso");
        equivalenciasIMC.put(0, "Saludable");
        equivalenciasIMC.put(1, "Sobrepeso");

        str += "Indicador IMC: " + equivalenciasIMC.get(this.calcularIMC()) + "\n";

        if(this.esMayorDeEdad()) {
            str += "Es mayor de edad\n";
        } else {
            str += "Es menor de edad\n";
        }

        return str;
    }

}
