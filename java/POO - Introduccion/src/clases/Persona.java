package clases;

public class Persona {

    private String nombre;
    private String dni;
    private int edad;
    private float peso;
    private float altura;


    public Persona (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona (String nombre, String dni, int edad, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //metodos

    public String calcularIMC() {
        double imc = peso/(Math.pow(this.altura, 2));
        if(imc < 20)
            return "Bajo peso";
        else if (imc >= 20 && imc <= 25)
            return "Peso saludable";
        else
            return "Sobre peso";
    }

    public boolean esMayorDeEdad(){
        return edad > 17;
    }

    public String toString() {
        String mayor;
        if (esMayorDeEdad())
            mayor = "(es mayor de edad)";
        else
            mayor = "(es menor de edad)";
        return "Nombre: " + this.nombre + "\tEdad: " + this.edad + mayor + "\tDni: " + this.dni + "\tAltura: " + this.altura +
                "\tPeso: " + this.peso + "\tResultado IMC: " + calcularIMC() + ".";
    }
}
