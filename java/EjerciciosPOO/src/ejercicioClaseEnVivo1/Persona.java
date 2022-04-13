package ejercicioClaseEnVivo1;

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

    public int calcularMC() {
        float mc = this.peso / (this.altura * this.altura);
        int resultado = 0;
        if (mc < 20) {
            resultado =  -1;
        } else if (mc >= 20 && mc <= 25){
            resultado = 0;
        } else if (mc > 25) {
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad() {
        if (this.edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nombre = '" + nombre + '\'' +
                ", Edad = " + edad +
                ", Dni = '" + dni + '\'' +
                ", Peso = " + peso + "kgs" +
                ", Altura = " + altura + "mts";
    }
}
