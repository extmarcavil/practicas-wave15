package ejercicioPOOP1Vivo;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int cacularIMC() {
        double imc =peso/(Math.pow(altura,2));
        int resultado=-1;
        if(imc < 20){
            resultado= -1;
        }else if(imc >=20 && imc <=25) {
            resultado= 0;
        }else if(imc>25){
            resultado= 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad() {
        if (edad>=18)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
