package uy.com.vparula;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int calcularImc(){
        double imc = peso/(Math.pow(altura,2));
        if (imc<20 ) {
            return -1;
        }
        else if (imc>25) {
            return 1;
        }else{
            return 0;
        }
    }
    public boolean esMayor(){
        return (edad>18);
    }

    @Override
    public String toString() {
        String retorno = "Hola, soy " + nombre + ".\nTengo " + edad + " años.\nMi dni es " + dni + "\nPeso " + peso + " kilos y mido "+ altura +".";
        return retorno;
    }
}
