public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona () {

    }

    public Persona (String nombre, int edad, String dni) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float cacularIMC(){
        float imc = peso/(altura*altura);
        if(imc < 20) {
            return -1;
        }
        else {
            if (imc >= 20 && imc <= 25) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "  Nombre=" + nombre +
                "\n  Edad=" + edad +
                "\n  DNI=" + dni  +
                "\n  Peso=" + peso +
                "\n  Altura=" + altura;
    }
}
