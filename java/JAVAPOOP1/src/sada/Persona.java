package sada;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private double altura;


    public Persona(){
        this("", 0, "", 0, 0);
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        setNombre(nombre);
        setDni(dni);
        setEdad(edad);
        setAltura(altura);
        setPeso(peso);
    }

    public Persona(String nombre, int edad, String dni) {
        setNombre(nombre);
        setDni(dni);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    private void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }

    public int getPeso() {
        return peso;
    }

    private void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    private void setAltura(double altura) {
        this.altura = altura;
    }


    public int calcularIMC(int peso, double altura){
        int devolver;
        double imc =  peso/(altura*2);
        if(imc < 20){
             devolver = -1;
        }else{
            if(imc >= 20 && imc <= 25){
                devolver = 0;
            } else {
                devolver = 1;
            }

        }

        return devolver;
    }


    public boolean esMayorDeEdad(int edad){
        boolean devolver;
        if( edad >= 18){
            devolver = true;
        } else {
            devolver = false;
        }

        return devolver;
    }

    @Override
    public String toString() {
        String esMayor;

        if (edad >= 18) {

            esMayor = "Es mayor de edad";
        } else {
            esMayor = "Es menor";
        }
        


        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad + esMayor + '\'' +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
